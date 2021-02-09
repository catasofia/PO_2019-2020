package m19.core.exception;

public class NoSuchWorkIdException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  private int _id;

  /**
   * @param id
   */
  public NoSuchWorkIdException(int id) {
    _id = id;
  }

  /** @return id */
  public int getId() {
    return _id;
  }
}
