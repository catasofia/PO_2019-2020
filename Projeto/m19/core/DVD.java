package m19.core;

public class DVD extends Work{
  private String _director;
  private String _iGACNumber;

  public DVD(int id, String title, String director, int price, 
  Category cat, String iGACNumber,int copies){
      super(id, copies, title, price, cat);
      _director = director;
      _iGACNumber = iGACNumber;
  }

  public String getDirector(){
    return _director;
  }

  public String getIGACNumber(){
    return _iGACNumber;
  }

  protected String displayWork(){
    return super.getID() + " - " + super.getCopiesAvailable() + " de " +
    super.getCopies() + " - DVD - " + super.getTitle() + " - " + super.getPrice() +
    " - " + super.getCategory().toString() + " - " + _director + " - " + _iGACNumber + "\n";
  }
}