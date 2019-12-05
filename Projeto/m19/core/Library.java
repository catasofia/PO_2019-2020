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
  private int _nextObraId;
  private Date _date;
  private Map<Integer, User> _users;
  private Map<Integer, Work> _works;
  private Map<Request_data, Request> _requests;

  public Library(){
    _nextUserId = 0;
    _nextObraId = 0;
    _date = new Date();
    _users = new HashMap<>();
    _works = new HashMap<>();
    _requests = new HashMap<>();
  }

  //==================== User ====================
  /**
   * Register a User by name and email
   * 
   * @param name
   *        name of the User
   * @param email
   *        email of the User
   * @throws UserRegistFailedException when the name or the email are empty strings
   */
    void registerUser(String name, String email) throws UserRegistFailedException{
    if(!name.isEmpty() && !email.isEmpty())
      _users.put(_nextUserId,new User(_nextUserId++,name, email));
    else throw new UserRegistFailedException(name, email);
  }

  /**
   * Get's the _nextUserId private attribute
   * 
   * @return next user id
   */
    int getNextUser(){
    return _nextUserId;
  }
  
  /**
   * Returns the User of the received ID
   * 
   * @param id
   *        ID of the User
   * @return user if he exists
   */
    User getUser(int id) {
    if (id < _nextUserId) return _users.get(id);
    else return null;
  }

  /**
   * Returns the string to display the User by the given id
   * 
   * @param id
   *        ID of the User
   * @throws NoSuchUserIdException if the given id has no user associated to it
   * @return a String to show the user associated to the given id
   */
    String showUser(int id) throws NoSuchUserIdException{
    User current_user = getUser(id);
    if(current_user != null) return current_user.showUser(); 
    else throw new NoSuchUserIdException(id);
  }

  /**
   * Shows all users sorted by name
   * 
   * @return all the users in the library
   */
    String showUsers(){
    String allUsers = "";
    List<User> users = new ArrayList<>(_users.values());

    Collections.sort(users, new Comparator<User>() {
      @Override
      public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
      }
    });
  
    for (User user:users)
      allUsers += user.showUser();
    return allUsers;
  }


  //==================== Work ====================
  /**
   * Register a book by its title, author, price, category, isbn 
   * and number of copies
   * @param title
   *             title of the book
   * @param author
   *             author of the book
   * @param price
   *             price of the book
   * @param cat
   *             category of the book
   * @param isbn
   *             isbn number of the book
   * @param copies
   *             number of copies of the book 
   */
    void registerBook(String title, String author, int price, 
  Category cat, String isbn,int copies){
    _works.put(_nextObraId, new Book(_nextObraId++, title, author, price, cat, isbn, copies));
  }

  /**
   * Register a DVD by its title, director, price, category, iGAC 
   * and number of copies
   * @param title
   *            title of the DVD
   * @param director
   *            director of the DVD  
   * @param price
   *            price of the DVD
   * @param cat
   *            category of the DVD
   * @param igacNumber
   *            iGAC number of the DVD
   * @param copies
   *            number of copies of the DVD
   */
    void registerDVD(String title, String director, int price, 
  Category cat, String igacNumber,int copies){
    _works.put(_nextObraId, new Dvd(_nextObraId++, title, director, price, cat, igacNumber, copies));
  }

  /**
   * searches for the work according to the received id
   * @param id
   *          id of the work
   * @return the work associated to the given id
   */
    Work getWork(int id){
    if (id < _nextObraId) return _works.get(id);
    else return null;
  }


  /**
   * searches the work according to the given id and displays it
   * @param id
   *          id of the work
   * @return a String to display the work associated to the given id
   * @throws NoSuchWorkIdException if the given id has no work associated to it
   */
    String displayWork(int id) throws NoSuchWorkIdException{
    Work current_work = getWork(id);
    if (current_work != null)
      return current_work.displayWork();
    else
      throw new NoSuchWorkIdException(id);
  }

  /**
   * searches the works sorted by the id and displays them
   * @return all the works in the library
   */
  String displayWorks(){
    String allWorks = "";
    for (int i = 0;i < _nextObraId; i++)
    if (getWork(i) != null) allWorks += _works.get(i).displayWork();
    return allWorks;
  }
  
/**
 * searchs for the term received in the argument in every work
 * @param term
 *          term to search for
 * @return a String to display all the works that have "term" in its description
 */
  String performSearch(String term){
    String search = "";
    for(int id = 0; id < _nextObraId; id++){
      try {
        String work = displayWork(id);
        if (work.toLowerCase().contains(term.toLowerCase()))
        search += work;
      } catch(NoSuchWorkIdException e){}
    }
    return search;
  }

  //================== Requests ===================
  
  int requestWork(int userId, int workId) throws NoSuchUserIdException, NoSuchWorkIdException{
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);
    if(currentUser == null)
      throw new NoSuchUserIdException(userId);
    else if(currentWork == null)
      throw new NoSuchWorkIdException(workId);
    if (currentWork.areCopiesAvailable()){
      Request nvRequest = new Request(currentUser, currentWork,_date.getDate());
      _requests.put(new Request_data(userId,workId), nvRequest);
      System.out.println(_requests.get(new Request_data(userId,workId)));


      return nvRequest.getDeadline();
    }
    else{
      return -1;
    }
  }
  
  int returnWork(int userId, int workId) throws NoSuchUserIdException, NoSuchWorkIdException{
    User currentUser = getUser(userId);
    Work currentWork = getWork(workId);
    Request_data data = new Request_data(userId,workId);

    if(currentUser == null) throw new NoSuchUserIdException(userId);
    else if(currentWork == null) throw new NoSuchWorkIdException(workId);
    if (_requests.remove(data)==null) return -1;
    return 0;
  }


  //==================== Tempo ====================
  /**
   * Returns the current day
   * 
   * @return current day
   */
  int getDate(){
    return _date.getDate();
  }

  /**
   * Change the current day by adding nDay to the day
   * 
   * @param nDay
   *        number of days to advance
   */
    void changeDate(int nDay){
    _date.changeDate(nDay);
    
  }


  //==================== Files ====================
  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   * @throws UserRegistFailedException when the name or the email are empty strings
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException, UserRegistFailedException {
    Parser parse = new Parser(this);
    parse.parseFile(filename);
  }
}
