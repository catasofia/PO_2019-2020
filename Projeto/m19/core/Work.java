package m19.core;

import java.io.Serializable;

public abstract class Work implements Serializable{
  private int _iDObra;
  private int _copies;
  private int _copiesAvailable;
  private String _title;
  private int _price;
  private Category _category;

  private static final long serialVersionUID = 201901101348L;

  public Work(int iDObra,int copies, String title, int price, Category category){
    _iDObra = iDObra;
    _copies = copies;
    _copiesAvailable = copies;
    _title = title;
    _price = price;
    _category = category;
  }

  protected String getTitle(){
    return _title;
  }

  protected int getCopies(){
    return _copies;
  }

  protected int getPrice(){
    return _price;
  }

  protected int getID(){
    return _iDObra;
  }

  protected int getCopiesAvailable(){
    return _copiesAvailable;
  }

  protected Category getCategory(){
    return _category;
  }
  
  protected void changeCopies(int nCopies){
    _copiesAvailable = nCopies;
  }

  protected boolean areCopiesAvailable(){
    return _copiesAvailable != 0;
  }
  
  abstract protected String displayWork();

}
