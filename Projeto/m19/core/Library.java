package m19.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.io.FileReader;
import java.io.BufferedReader;

import m19.app.exception.*;
import m19.core.exception.*;
// FIXME import other system types
// FIXME import project (core) types if needed

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
  //private HashMap<Integer, Request> _requisicoes;
  private Map<Integer, Work> _works;

  public Library(){
    _nextUserID = 0;
    _nextObraID = 0;
    _date = new Date();
    _users = new HashMap<>();
    //_requisicoes = new HashMap<>();
    _works = new HashMap<>();
  }

  //==================== User ====================
  protected void registerUser(String name, String email) throws UserRegistFailedException{
    if(!name.isEmpty() && !email.isEmpty())
      _users.put(_nextUserID,new User(_nextUserID++,name, email));
    else throw new UserRegistFailedException(name, email);
  }

  protected int getNextUtente(){
    return _nextUserID;
  }
  
  protected User getUser(int id) {
    if (id<_nextUserID) return _users.get(id);
    else return null;
  }

  protected String showUser(int id) throws NoSuchUserIdException{
    User u = getUser(id);
    if(u != null) return u.showUser(); 
    else throw new NoSuchUserIdException(id);
  }

  protected String showUsers(){
    String a = "";
    List<User> users = new ArrayList<>(_users.values());

    Collections.sort(users, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  
    for (User utente:users)
      a += utente.showUser();
    return a;
  }

  protected void verifyUser(){
    /*for(User i : _users)
      i.verificaUtente();*/
  }

  protected void payFine(){}


  //==================== Work ====================
  protected void registerBook(String title, String author, int price, 
  Category cat, String iSBN,int copies){
    _works.put(_nextObraID, new Book(_nextObraID++, title, author, price, cat, iSBN, copies));
  }

  protected void registerDVD(String title, String director, int price, 
  Category cat, String numeroIGAC,int copies){
    _works.put(_nextObraID, new DVD(_nextObraID++, title, director, price, cat, numeroIGAC, copies));
  }

  protected Work getWork(int id){
    if (id<_nextObraID) return _works.get(id);
    else return null;
  }

  protected String displayWork(int id) throws NoSuchWorkIdException{
    Work o = getWork(id);
    if (o != null)
      return o.displayWork();
    else
      throw new NoSuchWorkIdException(id);
  }

  protected String displayWorks(){
    String a="";
    for (int i = 0;i < _nextObraID;i++)
      if (getWork(i) != null) a += _works.get(i).displayWork();
    return a;
  }

  protected void performSearch(){}


  //==================== Tempo ====================
  protected int getDate(){
    return _date.getDate();
  }

  protected void changeDate(int nDay){
    _date.changeDate(nDay);
  }


  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException, UserRegistFailedException {
    Parser parse = new Parser(this);
    parse.parseFile(filename);
  }
}

