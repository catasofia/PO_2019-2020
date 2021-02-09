package m19.core.exception;

public class UserActiveException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  private int _id;

  /**
   * @param id
   */
  public UserActiveException(int id) {
    _id = id;
  }

  /** @return id */
  public int getId() {
    return _id;
  }
}
