package net.sf.libgrowl.internal;


/**
 * icon created using an URL
 * 
 * @author Bananeweizen
 * 
 */
public class UrlIcon extends Icon {

  private String mUrl;

  public UrlIcon(final String iconUrl) {
    mUrl = iconUrl;
  }

  @Override
  public void header(final String headerName, final Message message) {
    message.header(headerName, mUrl);
  }

}
