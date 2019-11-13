package m19.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;

import m19.core.exception.MissingFileAssociationException;
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
  private List<Utente> _utentes;
  private List<Requisicoes> _requisicoes;
  private List<Obra> _obras;

  public Library(){
    _nUtentes = 0;
    _nObras = 0;
    _tempo = new Tempo();
    _utentes = new ArrayList<Utente>();
    _requisicoes = new ArrayList<Requisicoes>();
    _obras = new ArrayList<Obra>();
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
    _utentes.add(new Utente(_nUtentes++,nome, email));
  }

  protected String mostrarUtente(int id){
    return _utentes.get(id).mostrarUtente(); //FALTAM COISAS
  }

  protected String mostrarUtentes(){
    String a="";

    Collections.sort(_utentes, new Comparator<Utente>() {
        @Override
        public int compare(Utente o1, Utente o2) {
          return o1.obterNome().compareTo(o2.obterNome());
        }
      });


    for (Utente utente:_utentes){
      a += utente.mostrarUtente(); //FALTAM COISAS
    }
    
    return a;
  }

  protected void pagarMulta(){}

  protected void registarObra(Obra obra){
    _obras.add(obra);
  }

  protected String mostrarObra(int obraID){
    return _obras.get(obraID).mostrarObra();
  }

  protected String mostrarObras(){
    String a="";
    for (Obra obra:_obras)
      a+=obra.mostrarObra();
    return a;
  }

  protected void efetuaPesquisa(){}

  protected void verificaUtentes(){
    for(Utente i : _utentes)
      i.verificaUtente();
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
    try (FileReader reader = new FileReader(filename);
      BufferedReader br = new BufferedReader(reader)){
      
      String line=br.readLine();

      while ( line!= null) {
        String[] parts=line.split(":");
        if (parts[0].equals("USER"))
          registarUtente(parts[1], parts[2]);
        else if (parts[0].equals("BOOK"))
          registarObra(new Livro(_nObras++,parts[1],parts[2],Integer.parseInt(parts[3]),
          parts[4],parts[5],Integer.parseInt(parts[6])));
        line = br.readLine();
      }
      reader.close();

    } catch (IOException e) {
      System.err.format("IOException: %s%n", e);
    }
    // FIXME implement method
  }
}

