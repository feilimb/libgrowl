package net.sf.libgrowl;

import java.util.ArrayList;

import net.sf.libgrowl.internal.IProtocol;
import net.sf.libgrowl.internal.Message;
import net.sf.libgrowl.internal.NotifyMessage;
import net.sf.libgrowl.internal.RegisterMessage;

/**
 * GrowlConnector is the entry point for sending notifications to Growl. Typical
 * use looks like this:
 * <p>
 * <code>
 * // connect to Growl on the given host<br>
 * GrowlConnector growl = new GrowlConnector("hostname");<br>
 * <br>
 * // give your application a name and icon (optionally)<br>
 * Application downloadApp = new Application("Downloader", "http://example.com/icon.png");<br>
 * <br>
 * // create reusable notification types, their names are used in the Growl settings<br>
 * NotificationType downloadStarted = new NotificationType("Download started", "c:\started.png");<br>
 * NotificationType downloadFinished = new NotificationType("Download finished", "c:\finished.jpg");<br>
 * NotificationType[] notificationTypes = new NotificationType[] { downloadStarted, downloadFinished };<br>
 * <br>
 * // now register the application in growl<br>
 * growl.register(downloadApp, notificationTypes);<br>
 * <br>
 * // create a notification with specific title and message<br> 
 * Notification ubuntuDownload = new Notification(downloadApp, downloadStarted, "Ubuntu 9.4", "654 MB");<br>
 * <br>
 * // finally send the notification<br>  
 * growl.notify(ubuntuDownload);<br>
 * </code>
 * </p>
 * 
 * @author Bananeweizen
 * 
 */
public class GrowlConnector {

  private String mHost;
  private int mPort;
  private ArrayList<NotificationType> mRegisteredNotifications = new ArrayList<NotificationType>();

  /**
   * create a growl connection to localhost, port 23053
   */
  public GrowlConnector() {
    this("localhost");
  }

  /**
   * create a growl connection to the given host, port 23053
   * 
   * @param host
   *          host name
   */
  public GrowlConnector(final String host) {
    this(host, IProtocol.DEFAULT_GROWL_PORT);
  }

  /**
   * create a growl connection to the given host on the given port number
   * 
   * @param host
   *          host name
   * @param port
   *          port number
   */
  public GrowlConnector(final String host, final int port) {
    super();
    mHost = host;
    mPort = port;
  }

  /**
   * registers your application with Growl
   * <p>
   * Only after registering an application, it can send notifications. You can
   * re-register your application as often as you want (e.g. during every
   * program start), Growl will be able to handle this.
   * </p>
   * 
   * @param application
   *          your application
   * @param notificationTypes
   *          all notification types supported by your application
   * @return response, see {@link IResponse}
   */
  public final int register(final Application application,
      final NotificationType[] notificationTypes) {
    final Message message = new RegisterMessage(application, notificationTypes);
    final int result = message.send(mHost, mPort);
    if (result == IResponse.OK) {
      setNotificationsRegistered(notificationTypes);
    }
    return result;
  }

  /**
   * remember the registered notification types internally to detect wrong usage
   * of the {@link GrowlConnector#notify(Notification)} method
   * 
   * @param notificationTypes
   */
  private void setNotificationsRegistered(
      final NotificationType[] notificationTypes) {
    for (NotificationType notificationType : notificationTypes) {
      mRegisteredNotifications.add(notificationType);
    }
  }

  /**
   * sends a notification to Growl
   * <p>
   * Your application must have been registered first, see
   * {@link #register(Application, NotificationType[])}
   * </p>
   * 
   * @param notification
   *          notification to send to Growl
   * @return response, see {@link IResponse}
   */
  public final int notify(final Notification notification) {
    if (!isRegistered(notification.getNotificationType())) {
      System.err.println("You need to register the notification type "
          + notification.getNotificationType().getDisplayName()
          + " before using it in notifications.");
    }
    final Message message = new NotifyMessage(notification);
    return message.send(mHost, mPort);
  }
 
  private boolean isRegistered(final NotificationType notificationType) {
    return mRegisteredNotifications.contains(notificationType);
  }

  /**
   * command line interface to send a message to Growl. You can use this like<br>
   * <code>
   * java -jar libgrowl.jar "host" "Application name" "Notification type" "Notification title" "Notification text"
   * </code>
   * 
   * @param args
   *          array of arguments, must be in this order:
   *          <ul>
   *          <li>host name where Growl is running</li>
   *          <li>application name to be displayed in Growl settings</li>
   *          <li>notification type name to be displayed in Growl settings</li>
   *          <li>notification title</li>
   *          <li>notification text</li>
   *          </ul>
   */
  public static void main(final String[] args) {
    final String host = args[0];
    final String appName = args[1];
    final String notificationName = args[2];
    final String title = args[3];
    final String message = args[4];
    final GrowlConnector growl = new GrowlConnector(host);
    final Application application = new Application(appName);
    final NotificationType notificationType = new NotificationType(
        notificationName);
    final NotificationType[] notificationTypes = new NotificationType[] { notificationType };
    growl.register(application, notificationTypes);
    final Notification notification = new Notification(application,
        notificationType,
        title, message);
    growl.notify(notification);
  }
}