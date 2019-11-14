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
  private Map<Integer, User> _utentes;
  //private HashMap<Integer, Request> _requisicoes;
  private Map<Integer, Work> _obras;

  public Library(){
    _nextUserID = 0;
    _nextObraID = 0;
    _date = new Date();
    _utentes = new HashMap<>();
    //_requisicoes = new HashMap<>();
    _obras = new HashMap<>();
  }

  //==================== User ====================
  protected void registarUtente(String nome, String email) throws UserRegistFailedException{
    if(!nome.isEmpty() && !email.isEmpty())
      _utentes.put(_nextUserID,new User(_nextUserID++,nome, email));
    else throw new UserRegistFailedException(nome, email);
  }

  protected int getNextUtente(){
    return _nextUserID;
  }
  
  protected User obterUtente(int id) {
    if (id<_nextUserID) return _utentes.get(id);
    else return null;
  }

  protected String showUser(int id) throws NoSuchUserIdException{
    User u = obterUtente(id);
    if(u != null) return u.showUser(); 
    else throw new NoSuchUserIdException(id);
  }

  protected String showUsers(){
    String a="";
    List<User> utentes = new ArrayList<>(_utentes.values());

    Collections.sort(utentes, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  
    for (User utente:utentes)
      a+= utente.showUser();
    return a;
  }

  protected void verifyUser(){
    /*for(User i : _utentes)
      i.verificaUtente();*/
  }

  protected void pagarMulta(){}


  //==================== Work ====================
  protected void registarLivro(String titulo, String autor, int preco, 
  Category cat, String iSBN,int exemplares){
    _obras.put(_nextObraID, new Book(_nextObraID++, titulo, autor, preco, cat, iSBN, exemplares));
  }

  protected void registarDVD(String titulo, String realizador, int preco, 
  Category cat, String numeroIGAC,int exemplares){
    _obras.put(_nextObraID, new DVD(_nextObraID++, titulo, realizador, preco, cat, numeroIGAC, exemplares));
  }

  protected Work obterObra(int id){
    if (id<_nextObraID) return _obras.get(id);
    else return null;
  }

  protected String mostrarObra(int id) throws NoSuchWorkIdException{
    Work o = obterObra(id);
    if (o != null)
      return o.mostrarObra();
    else
      throw new NoSuchWorkIdException(id);
  }

  protected String mostrarObras(){
    String a="";
    for (int i=0;i<_nextObraID;i++)
      if (obterObra(i)!=null) a+=_obras.get(i).mostrarObra();
    return a;
  }

  protected void efetuaPesquisa(){}


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
    Parser parse=new Parser(this);
    parse.parseFile(filename);
  }
}

