package m19.core;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Work implements Serializable, Observable {
  private int _workId;
  private int _copies;
  private int _copiesAvailable;
  private String _title;
  private int _price;
  private Category _category;
  private Map<Integer, User> _deliverObservers;
  private Map<Integer, User> _requestsObservers;

  private static final long serialVersionUID = 201901101348L;

  public Work(int workId, int copies, String title, int price, Category category) {
    _workId = workId;
    _copies = copies;
    _copiesAvailable = copies;
    _title = title;
    _price = price;
    _category = category;
    _deliverObservers = new HashMap<>();
    _requestsObservers = new HashMap<>();
  }

  protected void setPrice(){
    _price+=5;
  }

  protected String getTitle() {
    return _title;
  }

  protected int getCopies() {
    return _copies;
  }

  protected int getPrice() {
    return _price;
  }

  protected int getId() {
    return _workId;
  }

  protected int getCopiesAvailable() {
    return _copiesAvailable;
  }

  protected Category getCategory() {
    return _category;
  }

  protected void changeCopies(int nCopies) {
    _copiesAvailable += nCopies;
  }

  protected boolean areCopiesAvailable() {
    return _copiesAvailable != 0;
  }

  abstract protected String subClass();

  protected String displayWork() {
    return getId() + " - " + getCopiesAvailable() + " de " + getCopies() + " - " + subClass() + " - " + getTitle()
        + " - " + getPrice() + " - " + getCategory().toString();
  }

  /* OBSERVER */
  public void register(User observer) {
    _deliverObservers.put(observer.getUserID(), observer);
  }

  public void unregister(User observer) {
    _deliverObservers.remove(observer.getUserID(), observer);
  }

  public void notifyObserversDeliver(String message) {
    Notification notification = new Notification("ENTREGA: ", message);
    List<User> observers = new ArrayList<>(_deliverObservers.values());
    for (User observer : observers) {
      observer.update(notification);
      unregister(observer);
    }
  }

  public void notifyObserversRequest(String message) {
    Notification notification = new Notification("REQUISICAO: ", message);
    List<User> observers = new ArrayList<>(_requestsObservers.values());
    for (User observer : observers) {
      observer.update(notification);
    }
  }
}
