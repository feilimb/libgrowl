package net.sf.libgrowl.internal;

import net.sf.libgrowl.Notification;

public class NotifyMessage extends Message {

  public NotifyMessage(final Notification notification) {
    super(IProtocol.MESSAGETYPE_NOTIFY);

    // application name, required
    header(IProtocol.HEADER_APPLICATION_NAME, notification.getApplication()
        .getName());

    // notification name, required
    header(IProtocol.HEADER_NOTIFICATION_NAME, notification.getNotificationType()
        .getType());

    // id, optional
    final String id = notification.getId();
    if (id != null) {
      header(IProtocol.HEADER_NOTIFICATION_ID, id);
    }

    // title, required
    header(IProtocol.HEADER_NOTIFICATION_TITLE, notification.getTitle());

    // text, optional
    final String text = notification.getText();
    if (text != null) {
      header(IProtocol.HEADER_NOTIFICATION_TEXT, text);
    }

    // sticky, optional
    header(IProtocol.HEADER_NOTIFICATION_STICKY, notification.getSticky());

    // priority, optional
    header(IProtocol.HEADER_NOTIFICATION_PRIORITY, notification.getPriority());

    // icon, optional
    final Icon icon = notification.getIcon();
    if (icon != null) {
      icon.header(IProtocol.HEADER_NOTIFICATION_ICON, this);
    }
    
    // url callback, optional
    if (notification.getUrlCallback() != null)
    {
       header("Notification-Callback-Target", notification.getUrlCallback());
    }
    
    /*
     * // optional callback final String callbackId =
     * notification.getCallbackId(); if (callbackId != null) {
     * header(IProtocol.HEADER_NOTIFICATION_CALLBACK_ID, callbackId); }
     */
  }

}
