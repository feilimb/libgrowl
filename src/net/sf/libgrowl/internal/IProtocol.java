package net.sf.libgrowl.internal;

import net.sf.libgrowl.IPriority;

/**
 * @author Bananeweizen
 * 
 */
public interface IProtocol {

  /**
   * no encryption
   */
  static final String ENCRYPTION_NONE = "NONE";
  /**
   * GNTP version
   */
  static final String GNTP_VERSION = "GNTP/1.0";
  /**
   * Optional - The icon of the application
   */
  static final String HEADER_APPLICATION_ICON = "Application-Icon";
  /**
   * Required - The name of the application that is registering
   */
  static final String HEADER_APPLICATION_NAME = "Application-Name";
  /**
   * Optional - The name of the notification that is displayed to the user
   * (defaults to the same value as Notification-Name)
   */
  static final String HEADER_NOTIFICATION_DISPLAY_NAME = "Notification-Display-Name";
  /**
   * Optional - Indicates if the notification should be enabled by default
   * (defaults to False)
   */
  static final String HEADER_NOTIFICATION_ENABLED = "Notification-Enabled";
  /**
   * Optional - The icon to display with the notification.
   */
  static final String HEADER_NOTIFICATION_ICON = "Notification-Icon";
  /**
   * Optional - A unique ID for the notification. If present, serves as a hint
   * to the notification system that this notification should replace any
   * existing on-screen notification with the same ID. This can be used to
   * update an existing notification. The notification system may ignore this
   * hint.
   */
  static final String HEADER_NOTIFICATION_ID = "Notification-ID";
  /**
   * Required - The name (type) of the notification being registered
   */
  static final String HEADER_NOTIFICATION_NAME = "Notification-Name";
  /**
   * Optional - A higher number indicates a higher priority. This is a display
   * hint for the receiver which may be ignored. (valid values are between -2
   * and 2, defaults to 0)
   * 
   * @see IPriority
   */
  static final String HEADER_NOTIFICATION_PRIORITY = "Notification-Priority";
  /**
   * Optional - Indicates if the notification should remain displayed until
   * dismissed by the user. (default to False)
   */
  static final String HEADER_NOTIFICATION_STICKY = "Notification-Sticky";
  /**
   * Optional - The notification's text. (defaults to "")
   */
  static final String HEADER_NOTIFICATION_TEXT = "Notification-Text";
  /**
   * Required - The notification's title
   */
  static final String HEADER_NOTIFICATION_TITLE = "Notification-Title";
  /**
   * Required - The number of notifications being registered
   */
  static final String HEADER_NOTIFICATIONS_COUNT = "Notifications-Count";
  /**
   * Optional - The machine name/host name of the sending computer
   */
  static final String HEADER_ORIGIN_MACHINE_NAME = "Origin-Machine-Name";
  /**
   * Optional - The identify of the sending computer OS/platform. Example: Mac
   * OS X
   */
  static final String HEADER_ORIGIN_PLATFORM_NAME = "Origin-Platform-Name";
  /**
   * Optional - The version of the the sending computer OS/platform. Example:
   * 10.6
   */
  static final String HEADER_ORIGIN_PLATFORM_VERSION = "Origin-Platform-Version";
  /**
   * Optional - The identity of the sending framework. Example:
   * GrowlAIRConnector
   */
  static final String HEADER_ORIGIN_SOFTWARE_NAME = "Origin-Software-Name";
  /**
   * Optional - The version of the sending framework. Example: 1.2
   */
  static final String HEADER_ORIGIN_SOFTWARE_VERSION = "Origin-Software-Version";
  /**
   * line break for protocol lines
   */
  static final String LINE_BREAK = "\r\n";
  /**
   * message type NOTIFICATION
   */
  static final String MESSAGETYPE_NOTIFY = "NOTIFY";
  /**
   * message type REGISTER
   */
  static final String MESSAGETYPE_REGISTER = "REGISTER";
  /**
   * Optional - A unique ID used to identify callbacks from this notification.
   */
  static final String HEADER_NOTIFICATION_CALLBACK_ID = "Notification-Callback-ID";
  /**
   * default port for communication with Growl
   */
  static final int DEFAULT_GROWL_PORT = 23053;
  /**
   * binary data identifier
   */
  static final String X_GROWL_RESOURCE = "x-growl-resource://";
  /**
   * identifier of following resource
   */
  static final String HEADER_IDENTIFIER = "Identifier";
  /**
   * byte length of following resource
   */
  static final String HEADER_LENGTH = "Length";

}
