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
  private int _nextUserID;
  private int _nextObraID;
  private Date _date;
  private Map<Integer, User> _users;
  private Map<Integer, Work> _works;

  public Library(){
    _nextUserID = 0;
    _nextObraID = 0;
    _date = new Date();
    _users = new HashMap<>();
    _works = new HashMap<>();
  }

  //==================== User ====================
  /**
   * Register a User by name and email
   * 
   * @param name
   *        name of the User
   * @param email
   *        email of the User
   * @throws UserRegistFailedException
   */
  protected void registerUser(String name, String email) throws UserRegistFailedException{
    if(!name.isEmpty() && !email.isEmpty())
      _users.put(_nextUserID,new User(_nextUserID++,name, email));
    else throw new UserRegistFailedException(name, email);
  }

  /**
   * Get's the _nextUserID private attribute
   */
  protected int getNextUser(){
    return _nextUserID;
  }
  
  /**
   * Returns the User of  by giving a certain ID
   * 
   * @param id
   *        ID of the User
   */
  protected User getUser(int id) {
    if (id < _nextUserID) return _users.get(id);
    else return null;
  }

  /**
   * Returns the string to display the User by the given id
   * 
   * @param id
   *        ID of the User
   * @throws NoSuchUserIdException
   */
  protected String showUser(int id) throws NoSuchUserIdException{
    User u = getUser(id);
    if(u != null) return u.showUser(); 
    else throw new NoSuchUserIdException(id);
  }

  /**
   * Shows all users sorted by name
   * 
   */
  protected String showUsers(){
    String a = "";
    List<User> users = new ArrayList<>(_users.values());

    Collections.sort(users, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  
    for (User user:users)
      a += user.showUser();
    return a;
  }


  //==================== Work ====================

  /**
   * Register a book by its title, author, price, category, iSBN 
   * and number of copies
   * @param title
   *             title of the book
   * @param author
   *             author of the book
   * @param price
   *             price of the book
   * @param cat
   *             category of the book
   * @param iSBN
   *             iSBN number of the book
   * @param copies
   *             number of copies of the book 
   */
  protected void registerBook(String title, String author, int price, 
  Category cat, String iSBN,int copies){
    _works.put(_nextObraID, new Book(_nextObraID++, title, author, price, cat, iSBN, copies));
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
   * @param iGACNumber
   *            iGAC number of the DVD
   * @param copies
   *            number of copies of the DVD
   */
  protected void registerDVD(String title, String director, int price, 
  Category cat, String iGACNumber,int copies){
    _works.put(_nextObraID, new DVD(_nextObraID++, title, director, price, cat, iGACNumber, copies));
  }

  /**
   * @param id
   *          id of the work
   * @return the work associated to the given id
   */
  protected Work getWork(int id){
    if (id < _nextObraID) return _works.get(id);
    else return null;
  }


  /**
   * searches the work according to the given id and displays it
   * @param id
   *          id of the work
   * @return a String to display the work associated to the given id
   * @throws NoSuchWorkIdException if the given id has no work associated to it
   */
  protected String displayWork(int id) throws NoSuchWorkIdException{
    Work o = getWork(id);
    if (o != null)
      return o.displayWork();
    else
      throw new NoSuchWorkIdException(id);
  }

  /**
   * @return all the works in the library
   */
  protected String displayWorks(){
    String a = "";
    for (int i = 0;i < _nextObraID; i++)
      if (getWork(i) != null) a += _works.get(i).displayWork();
    return a;
  }


  //==================== Tempo ====================
  /**
   * Returns the current day
   */
  protected int getDate(){
    return _date.getDate();
  }

  /**
   * Change the current day by adding nDay to the day
   */
  protected void changeDate(int nDay){
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
   * @throws UserRegistFailedException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException, UserRegistFailedException {
    Parser parse = new Parser(this);
    parse.parseFile(filename);
  }
}

