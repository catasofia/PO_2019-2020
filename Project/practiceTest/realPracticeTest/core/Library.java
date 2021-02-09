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
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;
  private int _nextUserId;
  private int _nextWorkId;
  private int _requestsEntregues;
  private Date _date;
  private Map<Integer, User> _users;
  private Map<Integer, Work> _works;
  private Map<String, Request> _requests;
  private List<Rule> _rules;

  public Library() {
    _nextUserId = 0;
    _nextWorkId = 0;
    _date = new Date();
    _users = new HashMap<>();
    _works = new HashMap<>();
    _requests = new HashMap<>();
    _rules = new ArrayList<>();
    addRules();
    _requestsEntregues = 0;
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
    if (!name.isEmpty() && !email.isEmpty() && !name.equals(email))
      _users.put(_nextUserId, new User(_nextUserId++, name, email));
    else
      throw new UserRegistFailedException(name, email);
  }

  String aumetapreco(String term) {
    Integer flag = 0;
    String search = "";
    for (int i = 0; i < _nextWorkId; i++) {
      if (getWork(i) != null) {
        Work cwork = _works.get(i);
        if (cwork.getTitle().toLowerCase().contains(term.toLowerCase())) {
          cwork.setPrice();
          search+= cwork.getTitle() + "- "+cwork.getPrice()+"\n";
          flag++;
        }
      }
    }
    return flag.toString() + "\n" + search;
  }


  String obtemValor(){
    Integer maior=0;
    String search = "";
    for (int i = 0; i < _nextUserId; i++) {
      if (getUser(i) != null) {
        User cuser = _users.get(i);
        if (cuser.getMaior() >= maior) {
          search = cuser.showUser();
          maior = cuser.getMaior();
        }
      }
    }
    return search;
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
   * @param id Id of the User
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
   * @param id Id of the User
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

  /**
   * show all the notifications of the user acording to the id received
   * 
   * @param userId user id
   * @return String with all the user notifications
   * @throws NoSuchUserIdException when the user doesn't exist
   */
  String showNotifications(int userId) throws NoSuchUserIdException {
    User currentUser = _users.get(userId);
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    return currentUser.showNotifications();
  }

  /**
   * pays the fine of the user acording to the id received
   * 
   * @param userId user id who wants to pay the fine
   * @throws NoSuchUserIdException when the user doesn't exist
   * @throws UserActiveException   when the user is active
   */
  void doPayFine(int userId) throws NoSuchUserIdException, UserActiveException {
    User currentUser = _users.get(userId);
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if (currentUser.getSituationActive())
      throw new UserActiveException(userId);

    currentUser.doPayFine();
    currentUser.update(_date.getDate());
  }

  /**
   * shows the user's fine acording to the id received
   * 
   * @param userId user id
   * @return int which is the fine of the user
   */
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
    _works.put(_nextWorkId, new Book(_nextWorkId++, title, author, price, cat, isbn, copies));
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
    _works.put(_nextWorkId, new Dvd(_nextWorkId++, title, director, price, cat, igacNumber, copies));
  }

  /**
   * searches for the work according to the received id
   * 
   * @param id id of the work
   * @return the work associated to the given id
   */
  Work getWork(int id) {
    if (id < _nextWorkId)
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
    for (int i = 0; i < _nextWorkId; i++)
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
    for (int i = 0; i < _nextWorkId; i++) {
      if (getWork(i) != null) {
        String work = _works.get(i).displayWork();
        if (work.toLowerCase().contains(term.toLowerCase()))
          search += work;
      }
    }
    return search;
  }

  // ================== Requests ===================

  /**
   * function that determines the hashcode acording to the userId and the workId
   * 
   * @param userId id of the user
   * @param workId id of the work
   * @return String corresponding to the hashcode
   */
  String hashcodeRequest(int userId, int workId) {
    return "U" + userId + "W" + workId;
  }

  /**
   * User requests a work
   * 
   * @param userId id of the user
   * @param workId id of the work
   * @return the request's deadline
   * @throws RulesFailedException  when it is impossible to request due to a
   *                               failed rule
   * @throws NoSuchUserIdException when the user doesn't exist
   * @throws NoSuchWorkIdException when the work doesn't exist
   */
  int requestWork(int userId, int workId) throws RulesFailedException, NoSuchUserIdException, NoSuchWorkIdException {
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);
    // ERROR
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if (currentWork == null)
      throw new NoSuchWorkIdException(workId);

    Request nvRequest = new Request(currentUser, currentWork, _date.getDate());
    try {

      for (Rule rule : _rules) {
        rule.check(currentUser, currentWork);
      }

      _requests.put(hashcodeRequest(userId, workId), nvRequest);
      currentUser.addWork(nvRequest);
      currentWork.changeCopies(-1);
      // In the next line, in this specific submission, it doesn't do anything
      currentWork.notifyObserversRequest(currentWork.displayWork());

      return nvRequest.getDeadline();
    } catch (RulesFailedException e) {
      throw new RulesFailedException(userId, workId, e.getRuleIndex());
    }
  }

  /**
   * User returns a work
   * 
   * @param userId
   * @param workId
   * @return user's fine
   * @throws NoSuchUserIdException when the user doesn't exist
   * @throws NoSuchWorkIdException when the work doesn't exist
   */
  int returnWork(int userId, int workId) throws NoSuchUserIdException, NoSuchWorkIdException {
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);
    // ERROR
    if (currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if (currentWork == null)
      throw new NoSuchWorkIdException(workId);

    Request delRequest = _requests.get(hashcodeRequest(userId, workId));
    if (delRequest == null || !delRequest.getState())
      return -1;
    currentUser.removeWork();
    delRequest.changeState();
    delRequest.setNumEntregue(_requestsEntregues++);
    delRequest.setClosed(_date.getDate());
    currentWork.changeCopies(1);
    currentWork.notifyObserversDeliver(currentWork.displayWork());

    if (delRequest.daysLate() > 0)
      currentUser.setFine(5 * delRequest.daysLate());

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
  /**
   * add the user to observers of the work he is interested in
   * 
   * @param userId id of the user
   * @param workId id of the work
   */
  void addUserInterested(int userId, int workId) {
    Work currentWork = _works.get(workId);
    currentWork.register(_users.get(userId));
  }

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
