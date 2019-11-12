package m19.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

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

  protected void mostrarUtente(int id){
    _utentes.get(id).mostrarUtente(); //FALTAM COISAS
  }

  protected void mostrarUtentes(){
    List<String> lst = new ArrayList<>();
    Collections.sort(_utentes, new Comparator<Utente>() {
        @Override
        public int compare(Utente o1, Utente o2) {
            return Integer.parseInt(o1.obterNome()) - Integer.parseInt(o2.obterNome());
        }
      });
    for (Utente utente:_utentes)
      utente.mostrarUtente(); //FALTAM COISAS
  }

  protected void mostrarNotificacao(int iDNotificacao){
    //Não necessario
  }

  protected void pagarMulta(){}

  /*protected void registarObra(int exemplares, String titulo, int preco, Categoria categoria){
    _obras.add(new Obra(_nObras++,titulo))
  }*/

  protected void mostrarObra(int obraID){
    _obras.get(obraID).mostrarObra();
  }

  protected void mostrarObras(){
    for (Obra obra:_obras)
      obra.mostrarObra(); //FALTAM COISAS
  }

  protected void efetuaPesquisa(){}

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
    // FIXME implement method
  }

}
