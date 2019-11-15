package m19.app.main;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;
import pt.tecnico.po.ui.DialogException;

import java.io.FileNotFoundException;
import java.io.IOException;

import m19.core.Library;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {
  
  // FIXME define input fields
  private Input<String> _file1;  //nome que recebe do utilizador
  private String _file2;         //
  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    // FIXME initialize input fields
    _file1 = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
    // FIXME implement command
    if(_receiver.getFileName() != null)
      _file2 = _receiver.getFileName();    //ficheiro já existe e guardo na variavel fil2
    else
      _form.parse();

    try{
      if(_receiver.getFileName() != null){
        _receiver.save();       //guarda com nome antigo porque ja existe
      }
      else{
        _receiver.saveAs(_file1.value());  //guarda com o novo nome recebido do utilizador;
      }      
    }catch (MissingFileAssociationException e){
      System.out.println("x");//throw new MissingFileAssociationException();
    }catch (IOException e){
      e.printStackTrace();}
    }
}
