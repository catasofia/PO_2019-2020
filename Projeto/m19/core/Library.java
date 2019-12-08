/**
 * Catarina Sousa, N 93695
 * Nelson Trindade N 93743
 * Group: 51
 * Shift: Tuesdays at 13h
 */

package m19.core;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import m19.app.exception.*;
import m19.core.exception.*;

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable/* , ObservableInterface */ {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;
  private int _nextUserId;
  private int _nextObraId;
  private Date _date;
  private Map<Integer, User> _users;
  private Map<Integer, Work> _works;
  private Map<String, Request> _requests;
  private List<Rule> _rules;
  // private Map<User, Work> _observers;

  public Library() {
    _nextUserId = 0;
    _nextObraId = 0;
    _date = new Date();
    _users = new HashMap<>();
    _works = new HashMap<>();
    _requests = new HashMap<>();
    _rules = new ArrayList<>();
    addRules();
    // _observers = new HashMap<>();
  }

  // ==================== User ====================
  /**
   * Register a User by name and email
   * 
   * @param name  name of the User
   * @param email email of the User
   * @throws UserRegistFailedException when the name or the email are empty
   *                                   strings
   */
  void registerUser(String name, String email) throws UserRegistFailedException {
    if (!name.isEmpty() && !email.isEmpty())
      _users.put(_nextUserId, new User(_nextUserId++, name, email));
    else
      throw new UserRegistFailedException(name, email);
  }

  /**
   * Get's the _nextUserId private attribute
   * 
   * @return next user id
   */
  int getNextUser() {
    return _nextUserId;
  }

  /**
   * Returns the User of the received ID
   * 
   * @param id ID of the User
   * @return user if he exists
   */
  User getUser(int id) {
    if (id < _nextUserId)
      return _users.get(id);
    else
      return null;
  }

  /**
   * Returns the string to display the User by the given id
   * 
   * @param id ID of the User
   * @throws NoSuchUserIdException if the given id has no user associated to it
   * @return a String to show the user associated to the given id
   */
  String showUser(int id) throws NoSuchUserIdException {
    User current_user = getUser(id);
    if (current_user != null)
      return current_user.showUser();
    else
      throw new NoSuchUserIdException(id);
  }

  /**
   * Shows all users sorted by name
   * 
   * @return all the users in the library
   */
  String showUsers() {
    String allUsers = "";
    List<User> users = new ArrayList<>(_users.values());

    Collections.sort(users, new Comparator<User>() {
      @Override
      public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
      }
    });

    for (User user : users)
      allUsers += user.showUser();
    return allUsers;
  }

  String showNotifications(int userId) throws NoSuchUserIdException {
    User currentUser = _users.get(userId);
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    return currentUser.showNotifications();
  }

  void doPayFine(int userId) throws NoSuchUserIdException, UserActiveException {
    User currentUser = _users.get(userId);
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if (currentUser.getSituationActive())
      throw new UserActiveException(userId);
    currentUser.doPayFine();
    currentUser.update(_date.getDate());
  }

  int getFine(int userId) {
    User currenUser = _users.get(userId);
    return currenUser.getFine();
  }

  // ==================== Work ====================
  /**
   * Register a book by its title, author, price, category, isbn and number of
   * copies
   * 
   * @param title  title of the book
   * @param author author of the book
   * @param price  price of the book
   * @param cat    category of the book
   * @param isbn   isbn number of the book
   * @param copies number of copies of the book
   */
  void registerBook(String title, String author, int price, Category cat, String isbn, int copies) {
    _works.put(_nextObraId, new Book(_nextObraId++, title, author, price, cat, isbn, copies));
  }

  /**
   * Register a DVD by its title, director, price, category, iGAC and number of
   * copies
   * 
   * @param title      title of the DVD
   * @param director   director of the DVD
   * @param price      price of the DVD
   * @param cat        category of the DVD
   * @param igacNumber iGAC number of the DVD
   * @param copies     number of copies of the DVD
   */
  void registerDVD(String title, String director, int price, Category cat, String igacNumber, int copies) {
    _works.put(_nextObraId, new Dvd(_nextObraId++, title, director, price, cat, igacNumber, copies));
  }

  /**
   * searches for the work according to the received id
   * 
   * @param id id of the work
   * @return the work associated to the given id
   */
  Work getWork(int id) {
    if (id < _nextObraId)
      return _works.get(id);
    else
      return null;
  }

  /**
   * searches the work according to the given id and displays it
   * 
   * @param id id of the work
   * @return a String to display the work associated to the given id
   * @throws NoSuchWorkIdException if the given id has no work associated to it
   */
  String displayWork(int id) throws NoSuchWorkIdException {
    Work current_work = getWork(id);
    if (current_work != null)
      return current_work.displayWork();
    else
      throw new NoSuchWorkIdException(id);
  }

  /**
   * searches the works sorted by the id and displays them
   * 
   * @return all the works in the library
   */
  String displayWorks() {
    String allWorks = "";
    for (int i = 0; i < _nextObraId; i++)
      if (getWork(i) != null)
        allWorks += _works.get(i).displayWork();
    return allWorks;
  }

  /**
   * searchs for the term received in the argument in every work
   * 
   * @param term term to search for
   * @return a String to display all the works that have "term" in its description
   */
  String performSearch(String term) {
    String search = "";
    for (int i = 0; i < _nextObraId; i++) {
      if (getWork(i) != null) {
        String work = _works.get(i).displayWork();
        if (work.toLowerCase().contains(term.toLowerCase()))
          search += work;
      }
    }
    return search;
  }

  // ================== Requests ===================

  
  String hashcodeRequest(int userId, int workId) {
    return "U" + userId + "W" + workId;
  }

  int requestWork(int userId, int workId) throws RulesFailedException, NoSuchUserIdException, NoSuchWorkIdException {
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);

    else if (currentWork == null)
      throw new NoSuchWorkIdException(workId);

    Request nvRequest = new Request(currentUser, currentWork, _date.getDate());
    try {
      for (Rule rule : _rules) { // PODE TER DUAS DO MESMO GENERO, VER SE TA ATIVO/INATIVO
        rule.check(currentUser, currentWork);
      }

      _requests.put(hashcodeRequest(userId, workId), nvRequest);
      currentUser.addWork(nvRequest);
      currentWork.decreaseCopies(1);

      return nvRequest.getDeadline();
    } catch (RulesFailedException e) {
      throw new RulesFailedException(userId, workId, e.getRuleIndex());
    }
  }

  int returnWork(int userId, int workId) throws NoSuchUserIdException, NoSuchWorkIdException {
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);

    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if (currentWork == null)
      throw new NoSuchWorkIdException(workId);

    Request rv = _requests.get(hashcodeRequest(userId, workId));
    if (rv == null || !rv.getState() || currentUser.removeWork(rv) == -1)
      return -1;

    // System.out.println("Antes: "+rv.getState());
    rv.changeState();
    // System.out.println("Depois: "+rv.getState());
    rv.setClosed(_date.getDate());
    // System.out.println("Estado do request entregue: " + rv.getState());
    currentWork.decreaseCopies(-1); // Ver melhor
    currentWork.notifyObservers("ENTREGA: " + currentWork.displayWork());

    if (rv.daysLate() > 0)
      currentUser.setFine(5 * rv.daysLate());
    // UPDATES
    currentUser.update();
    currentUser.update(_date.getDate());
    return currentUser.getFine();
  }

  // ==================== Tempo ====================
  /**
   * Returns the current day
   * 
   * @return current day
   */
  int getDate() {
    return _date.getDate();
  }

  /**
   * Change the current day by adding nDay to the day
   * 
   * @param nDay number of days to advance
   */
  void changeDate(int nDay) {
    _date.changeDate(nDay);
    for (int i = 0; i < _users.size(); i++)
      _users.get(i).update(_date.getDate());
  }

  // ===============================================
  void addUserInterested(int userId, int workId) {
    Work currentWork = _works.get(workId);
    currentWork.register(_users.get(userId));
  }

  /*
   * public void register(User observer){ _observers.put(observer.getUserID(),
   * observer); }
   * 
   * public void unregister(User observer){
   * _observers.remove(observer.getUserID(), observer); }
   * 
   * public void notifyObservers(String message){ Notification notification = new
   * Notification(message); List<User> observers = new
   * ArrayList<>(_observers.values()); for(User observer: observers){
   * observer.update(notification); } }
   */

  // ==================== Rules ====================

  void addRules() {
    _rules.add(new CheckRequestTwice());
    _rules.add(new CheckUserIsSuspended());
    _rules.add(new CheckCopiesAvailable());
    _rules.add(new CheckNumberRequests());
    _rules.add(new CheckWorkCategory());
    _rules.add(new CheckWorkPrice());
  }

  // ==================== Files ====================
  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   * @throws UserRegistFailedException      when the name or the email are empty
   *                                        strings
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException, UserRegistFailedException {
    Parser parse = new Parser(this);
    parse.parseFile(filename);
  }
}
