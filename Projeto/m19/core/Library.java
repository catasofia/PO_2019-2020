package m19.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

import m19.app.exception.*;
import m19.core.exception.*;

import m19.core.exception.MissingFileAssociationException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.BadEntrySpecificationException;

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
  private Tempo _tempo;
  private HashMap<Integer, Utente> _utentes;
  private HashMap<Integer, Requisicoes> _requisicoes;
  private HashMap<Integer, Obra> _obras;

  public Library(){
    _nextUserID = 0;
    _nextObraID = 0;
    _tempo = new Tempo();
    _utentes = new HashMap<>();
    _requisicoes = new HashMap<>();
    _obras = new HashMap<>();
  }

  //==================== Utente ====================
  protected void registarUtente(String nome, String email) throws UserRegistFailedException{
    if(!nome.isEmpty() && !email.isEmpty())
      _utentes.put(_nextUserID,new Utente(_nextUserID++,nome, email));
    else throw new UserRegistFailedException(nome, email);
  }

  protected int getNextUtente(){
    return _nextUserID;
  }
  
  protected Utente obterUtente(int id) {
    if (id<_nextUserID) return _utentes.get(id);
    else return null;
  }

  protected String mostrarUtente(int id) throws NoSuchUserIdException{
    Utente u = obterUtente(id);
    if(u != null) return u.mostrarUtente(); 
    else throw new NoSuchUserIdException(id);
  }

  protected String mostrarUtentes(){
    String a="";
    List<Utente> utentes = new ArrayList<>(_utentes.values());

    Collections.sort(utentes, new Comparator<Utente>() {
      @Override
      public int compare(Utente o1, Utente o2) {
        return o1.obterNome().compareTo(o2.obterNome());
      }
    });
  
    for (Utente utente:utentes)
      a+= utente.mostrarUtente();
    return a;
  }

  protected void verificaUtentes(){
    /*for(Utente i : _utentes)
      i.verificaUtente();*/
  }

  protected void pagarMulta(){}


  //==================== Obra ====================
  protected void registarLivro(String titulo, String autor, int preco, 
  Categoria cat, String iSBN,int exemplares){
    _obras.put(_nextObraID, new Livro(_nextObraID++, titulo, autor, preco, cat, iSBN, exemplares));
  }

  protected void registarDVD(String titulo, String realizador, int preco, 
  Categoria cat, String numeroIGAC,int exemplares){
    _obras.put(_nextObraID, new DVD(_nextObraID++, titulo, realizador, preco, cat, numeroIGAC, exemplares));
  }

  protected Obra obterObra(int id){
    if (id<_nextObraID) return _obras.get(id);
    else return null;
  }

  protected String mostrarObra(int id) throws NoSuchWorkIdException{
    Obra o = obterObra(id);
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
  protected int mostrarData(){
    return _tempo.obterDia();
  }

  protected void avançarData(int tempo){
    _tempo.alteraDia(tempo);
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

