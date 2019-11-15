package m19.core;

public class Book extends Work{
  private String _author;
  private String _iSBN;

  public Book(String title, String author, int price, 
    Category cat, String iSBN,int copies){
      super(copies, title, price, cat);
      _author = author;
      _iSBN = iSBN;
  }

  public String getAuthor(){
    return _author;
  }
  public String getISBN(){
    return _iSBN;
  }

  protected String displayWork(){
    return super.getCopiesAvailable() + " de " +
    super.getCopies() + " - Livro - " + super.getTitle() + " - " + super.getPrice() +
    " - " + super.getCategory().toString() + " - " + _author + " - " + _iSBN + "\n";
  }
}