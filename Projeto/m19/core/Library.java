package m19.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.Serializable;

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
    // FIXME implement method
  }

}
