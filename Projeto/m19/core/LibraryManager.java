package m19.core;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.NotSerializableException;

import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;
import java.io.*;

import m19.app.exception.*;
import m19.core.exception.*;

// FIXME import other system types
// FIXME import other project (core) types

/**
 * The façade class.
 */
public class LibraryManager implements Serializable{
  private static final long serialVersionUID = 201901101348L;
  private Library _library = new Library();
  private String _file;


  // FIXME define methods

  public String getFileName(){
    return _file;
  }

  public void setFileName(String file){
    _file=file;
  }

  public void guardarComo(String filename) throws FileNotFoundException, IOException{
    if (filename == null){
      throw new FileNotFoundException();
    }
    _file = filename;

    try{
      ObjectOutputStream save = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_file))); //ver estas cenas definidas;
      save.writeObject(_library);     //escreve no objeto
      save.close();                   //fecha o objeto
    } catch (FileNotFoundException e ) {
      throw new FileNotFoundException(_file);
    } catch (IOException e) {
      e.printStackTrace(); }
  }

  public void open(String file) throws IOException, FileNotFoundException, ClassNotFoundException{
    ObjectInputStream novoFich = new ObjectInputStream(new FileInputStream(file));
    Library newLibrary = (Library)novoFich.readObject();
    novoFich.close();
    _library = newLibrary;
  }

  
  public int mostrarData(){
    return _library.mostrarData();
  }
  public void avançarData(int tempo){
    _library.avançarData(tempo);
  }

  public int totalUtentes(){
    return _library.totalUtentes();
  }

  public void registarUtente(String nome, String email){
    _library.registarUtente(nome, email);
  }

  public String mostrarUtente(int id) throws NoSuchUserIdException{
    return _library.mostrarUtente(id);
  }

  public String mostrarUtentes(){
    return _library.mostrarUtentes();
  }

  public void verificaUtentes(){
    _library.verificaUtentes();
  }

  public void pagarMulta(){}

  public String mostrarObra(int obraID) throws NoSuchWorkIdException{
    return _library.mostrarObra(obraID);
  }

  public String mostrarObras(){
    return _library.mostrarObras();
  }

  public void efetuaPesquisa(){}



  /**
   * Serialize the persistent state of this application.
   * 
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         state has not been set yet.
   * @throws IOException if some error happen during the serialization of the persistent state

   */
  public void save() throws MissingFileAssociationException, IOException {
    // FIXME implement method
  }

  /**
   * Serialize the persistent state of this application into the specified file.
   * 
   * @param filename the name of the target file
   *
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         is not a valid one.
   * @throws IOException if some error happen during the serialization of the persistent state
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    // FIXME implement method
  }

  /**
   * Recover the previously serialized persitent state of this application.
   * 
   * @param filename the name of the file containing the perssitente state to recover
   *
   * @throws IOException if there is a reading error while processing the file
   * @throws FileNotFoundException if the file does not exist
   * @throws ClassNotFoundException 
   */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    // FIXME implement method
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param datafile the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }
}
