package net.sf.libgrowl;

/**
 * response of a Growl request
 * 
 * @author Bananeweizen
 * 
 */
public interface IResponse {

  /**
   * no error occurred
   */
  static final int OK = 0;
  /**
   * an error occurred
   */
  static final int ERROR = 1;

}
