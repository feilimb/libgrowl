package net.sf.libgrowl;

/**
 * all priorities allowed for use in the {@link Notification} type.
 * 
 * @author Bananeweizen
 * 
 */
public interface IPriority {
  /**
   * highest priority
   */
  public static final int EMERGENCY = 2;
  /**
   * high priority
   */
  public static final int HIGH = 1;
  /**
   * default priority
   */
  public static final int NORMAL = 0;
  /**
   * low priority
   */
  public static final int MODERATE = -1;
  /**
   * lowest priority
   */
  public static final int VERYLOW = -2;
}
