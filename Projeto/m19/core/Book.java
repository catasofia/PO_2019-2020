package m19.core;

public class Book extends Work {
  private String _author;
  private String _isbn;

  public Book(int id, String title, String author, int price, Category cat, String isbn, int copies) {
    super(id, copies, title, price, cat);
    _author = author;
    _isbn = isbn;
  }

  public String getAuthor() {
    return _author;
  }

  public String getisbn() {
    return _isbn;
  }

  protected String subClass() {
    return "Livro";
  }

  protected String displayWork() {
    return super.displayWork() + " - " + _author + " - " + _isbn + "\n";
  }
}
