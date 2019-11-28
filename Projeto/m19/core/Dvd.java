package m19.core;

public class Dvd extends Work{
  private String _director;
  private String _iGACNumber;

  public Dvd(int id, String title, String director, int price, 
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

  protected String subClass(){
    return "DVD";
  }

  protected String displayWork(){
    return super.displayWork() + " - " + _director + " - " + _iGACNumber + "\n";
  }
}
