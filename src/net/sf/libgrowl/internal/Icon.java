package net.sf.libgrowl.internal;

/**
 * abstract icon representation
 * 
 * @author Bananeweizen
 * 
 */
public abstract class Icon {

  /**
   * print the header name and value for this icon
   * 
   * @param headerName
   * @param message
   */
  public abstract void header(final String headerName, final Message message);

}
