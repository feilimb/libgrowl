package net.sf.libgrowl.internal;

import net.sf.libgrowl.Application;
import net.sf.libgrowl.NotificationType;

public class RegisterMessage extends Message {

  public RegisterMessage(final Application application,
      final NotificationType[] notificationTypes) {
    super(IProtocol.MESSAGETYPE_REGISTER);

    // application name, required
    header(HEADER_APPLICATION_NAME, application.getName());

    // application icon, optional
    Icon icon = application.getIcon();
    if (icon != null) {
      icon.header(HEADER_APPLICATION_ICON, this);
    }

    // notification count, required
    header(HEADER_NOTIFICATIONS_COUNT, notificationTypes.length);

    // notification headers, separated by an empty line each
    for (NotificationType notificationType : notificationTypes) {
      lineBreak();
      // type, required
      header(HEADER_NOTIFICATION_NAME, notificationType.getType());
      // display name, optional
      header(HEADER_NOTIFICATION_DISPLAY_NAME, notificationType
          .getDisplayName());
      // enabled, optional
      header(HEADER_NOTIFICATION_ENABLED, notificationType.isEnabled());
      
      // icon, optional
      icon = notificationType.getIcon();
      if (icon != null) {
        icon.header(HEADER_NOTIFICATION_ICON, this);
      }
    }
  }

}
