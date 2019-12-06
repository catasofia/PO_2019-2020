package m19.core;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public abstract class Work implements Serializable, ObservableInterface {
  private int _iDObra;
  private int _copies;
  private int _copiesAvailable;
  private String _title;
  private int _price;
  private Category _category;
  private Set<Request> _usersRequests;
  private Map<Integer, User> _observers;

  private static final long serialVersionUID = 201901101348L;

  public Work(int iDObra,int copies, String title, int price, Category category){
    _iDObra = iDObra;
    _copies = copies;
    _copiesAvailable = copies;
    _title = title;
    _price = price;
    _category = category;
    _observers = new HashMap<>();
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
  
  protected void decreaseCopies(int nCopies){
    _copiesAvailable -= nCopies;
  }

  protected boolean areCopiesAvailable(){
    return _copiesAvailable != 0;
  }
  
  abstract protected String subClass();
  
  protected String displayWork(){
    return getID() + " - " + getCopiesAvailable() + " de " +
    getCopies() + " - " + subClass() +" - " + getTitle() + " - " + getPrice() +
    " - " + getCategory().toString();
  }

  public void register(User observer){
    _observers.put(observer.getUserID(), observer);
  }

  public void unregister(User observer){
    _observers.remove(observer.getUserID(), observer);
  }

  public void notifyObservers(String message){
    Notification notification = new Notification(message);
    List<User> observers = new ArrayList<>(_observers.values());
    for(User observer: observers){
      observer.update(notification);
    }
  }
}
