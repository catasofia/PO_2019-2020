package m19.app.main;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;
import pt.tecnico.po.ui.DialogException;

import java.io.FileNotFoundException;
import java.io.IOException;

import m19.core.Library;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {

  private Input<String> _file1;  //nome que recebe do utilizador
  private String _file2;         
  
  
  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    _file1 = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
    if(_receiver.getFileName() != null)
      _file2 = _receiver.getFileName();
    else
      _form.parse();

    try{
      if(_receiver.getFileName() != null){
        _receiver.save();
      }
      else{
        _receiver.saveAs(_file1.value());
      }      
    }catch (MissingFileAssociationException e){
      System.out.println("Guardar Ficheiro: Nome de ficheiro ilegivel.");
    }catch (IOException e){
      e.printStackTrace();}
  }
}
