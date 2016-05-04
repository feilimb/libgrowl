package net.sf.libgrowl;

import net.sf.libgrowl.internal.Icon;
import net.sf.libgrowl.internal.UrlIcon;

/**
 * A notification type groups all the similar notifications of your application.
 * E.g. you may need a "download started" and "download finished" notification
 * type, which you can then use multiple times for each download that started or
 * finished.
 * 
 * @author Bananeweizen
 * 
 */
public class NotificationType {

  private String mNotificationTypeId;
  private String mDisplayName;
  private boolean mEnabled = true;
  private Icon mIcon;

  public NotificationType(final String notificationTypeId,
      final String displayName, final String iconUrl) {
    mNotificationTypeId = notificationTypeId;
    mDisplayName = displayName;
    if (iconUrl != null) {
      mIcon = new UrlIcon(iconUrl);
    }
  }

  public NotificationType(final String notificationTypeId,
      final String displayName) {
    this(notificationTypeId, displayName, null);
  }

  public NotificationType(final String displayName) {
    this(displayName, displayName);
  }

  public String getType() {
    return mNotificationTypeId;
  }

  public String getDisplayName() {
    return mDisplayName;
  }

  public boolean isEnabled() {
    return mEnabled;
  }

  public void setEnabled(final boolean enabled) {
    mEnabled = enabled;
  }

  public void setDisplayName(final String displayName) {
    mDisplayName = displayName;
  }

  /**
   * get the icon displayed for this notification type in the Growl settings
   * 
   * @return the icon or <code>null</code>
   */
  public Icon getIcon() {
    return mIcon;
  }
}
