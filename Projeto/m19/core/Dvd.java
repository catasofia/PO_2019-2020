package m19.core;

public class Dvd extends Work{
  private String _director;
  private String _igacNumber;

  public Dvd(int id, String title, String director, int price, 
  Category cat, String igacNumber,int copies){
      super(id, copies, title, price, cat);
      _director = director;
      _igacNumber = igacNumber;
  }

  public String getDirector(){
    return _director;
  }

  public String getigacNumber(){
    return _igacNumber;
  }

  protected String subClass(){
    return "DVD";
  }

  protected String displayWork(){
    return super.displayWork() + " - " + _director + " - " + _igacNumber + "\n";
  }
}
