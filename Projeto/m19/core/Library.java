package m19.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
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
  private int _nUtentes;
  private int _nObras;
  private Tempo _tempo;
  private HashMap<Integer, Utente> _utentes;
  private HashMap<Integer, Requisicoes> _requisicoes;
  private HashMap<Integer, Obra> _obras;

  public Library(){
    _nUtentes = 0;
    _nObras = 0;
    _tempo = new Tempo();
    _utentes = new HashMap<Integer, Utente>();
    _requisicoes = new HashMap<Integer, Requisicoes>();
    _obras = new HashMap<Integer, Obra>();
  }

  // FIXME define methods
  protected int mostrarData(){
    return _tempo.obterDia();
  }
  protected void avançarData(int tempo){
    _tempo.alteraDia(tempo);
  }

  protected int totalUtentes(){
    return _nUtentes;
  }

  protected void registarUtente(String nome, String email){
    _utentes.put(_nUtentes,new Utente(_nUtentes++,nome, email));
  }
  
  protected void registarLivro(String titulo, String autor, int preco, 
  Categoria cat, String iSBN,int exemplares){
    _obras.put(_nObras, new Livro(_nObras++, titulo, autor, preco, cat, iSBN, exemplares));
  }

  protected void registarDVD(String titulo, String realizador, int preco, 
  Categoria cat, String numeroIGAC,int exemplares){
    _obras.put(_nObras, new DVD(_nObras++, titulo, realizador, preco, cat, numeroIGAC, exemplares));
  }

  protected Obra obterObra(int id){
    for(Obra o: _obras.keyset()){
      if(o.obterID() == id){
        return o;
      }
    }
    return null;
  }
  
  protected Utente obterUtente(int id) {
    if(id<_nUtentes)
      return _utentes.get(id);
    else return null;
    
}

  protected String mostrarObra(int id) throws NoSuchWorkException{
    /*Obra o = obterObra(id);
    if (o != null)
      return _obras.get(id).mostrarObra();
    else
      throw new NoSuchWorkException(id); */return "";
  }

  protected String mostrarUtente(int id) throws NoSuchUserException{
    Utente u = obterUtente(id);
    if(u != null)
      return _utentes.get(id).mostrarUtente(); //FALTAM COISAS
    else 
      throw new NoSuchUserException(id);
  }


  protected String mostrarUtentes(){
    /*String a="";
    List<Utente> utentes = new ArrayList<>(_utentes); 

    Collections.sort(utentes, new Comparator<Utente>() {
        @Override
        public int compare(Utente o1, Utente o2) {
          return o1.obterNome().compareTo(o2.obterNome());
        }
      });


    for (Utente utente:utentes){
      a += utente.mostrarUtente() + "\n"; //FALTAM COISAS
    }
    
    return a;*/return "";
  }

  protected void pagarMulta(){}

  
  protected String mostrarObras(){
    /*String a="";
    for (Obra obra:_obras)
      a+=obra.mostrarObra();
    return a;*/return "";
  }

  protected void efetuaPesquisa(){}

  protected void verificaUtentes(){
    /*for(Utente i : _utentes)
      i.verificaUtente();*/
  }

  /*+requisitarObra(iDUtente: int, iDObra: int) : void
  +devolverObra(iDUtente: int, iDObra: int) : void
*/






  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    Parser parse=new Parser(this);
    parse.parseFile(filename);
    
    // FIXME implement method
  }
}

