package m19.core;

import java.net.ProtocolException;

import java.io.*;

import m19.app.exception.*;
import m19.core.exception.*;

/**
 * The façade class.
 */
public class LibraryManager implements Serializable{
  private static final long serialVersionUID = 201901101348L;
  private Library _library = new Library();
  private String _file;


  public String getFileName(){
    return _file;
  }

  public void setFileName(String file){
    _file = file;
  }
  
  public int getDate(){
    return _library.getDate();
  }

  public void changeDate(int tempo){
    _library.changeDate(tempo);
  }

  public int getNextUser(){
    return _library.getNextUser();
  }

  public void registerUser(String nome, String email) throws UserRegistFailedException{
    _library.registerUser(nome, email);
  }

  public String showUser(int id) throws NoSuchUserIdException{
    return _library.showUser(id);
  }

  public String showUsers(){
    return _library.showUsers();
  }

  public String displayWork(int obraID) throws NoSuchWorkIdException{
    return _library.displayWork(obraID);
  }

  public String displayWorks(){
    return _library.displayWorks();
  }
  
  public String performSearch(String term){
    return _library.performSearch(term);
  }
  
  
  /* public void requestWork(int userId, int workId){
    _library.requestWork(userId, workId);
  } */
    /**
     * Serialize the persistent state of this application.
     * 
     * @throws MissingFileAssociationException if the name of the file to store the persistent
     *         state has not been set yet.
     * @throws IOException if some error happen during the serialization of the persistent state
     
     */
  public void save() throws MissingFileAssociationException, IOException {
    try{
      saveAs(_file);
    } catch (MissingFileAssociationException e ) {
      throw new MissingFileAssociationException();
    } catch (IOException e) {
      e.printStackTrace(); 
    }
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
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    if (filename == null){
      throw new MissingFileAssociationException();
    }
    try(ObjectOutputStream save = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
      _file=filename;
      save.writeObject(_library);     //escreve no objeto
      
    } catch (FileNotFoundException e) {
      throw new MissingFileAssociationException(e);
    } catch (IOException e) {
      e.printStackTrace(); }
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
    try(ObjectInputStream newFile = new ObjectInputStream(new FileInputStream(filename))){
      Library newLibrary = (Library)newFile.readObject();
      _library = newLibrary;
      _file = filename;

    } catch (FileNotFoundException e){
      throw new FileNotFoundException();
    } catch (ClassNotFoundException | IOException e){
      e.printStackTrace();
    }
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param datafile the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String datafile) throws ImportFileException{
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException | UserRegistFailedException e) {
      throw new ImportFileException(e);
    }
  }


  public int requestWork(int userId, int workId){
    return _library.requestWork(userId, workId);
  }

  public int returnWork(int userId, int workId){
    return _library.returnWork(userId, workId);
  }

}
