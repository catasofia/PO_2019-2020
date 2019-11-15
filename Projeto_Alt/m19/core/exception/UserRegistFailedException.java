package m19.core.exception;

public class UserRegistFailedException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  private String _name;
  private String _email;

  /**
   * @param name
   * @param email
   */
  public UserRegistFailedException(String name, String email) {
    _name = name;
    _email = email;
  }

  /** @return id */
  public String getName() {
    return _name;
  }

  public String getEmail(){
      return _email;
  }
}