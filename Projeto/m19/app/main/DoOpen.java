package m19.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

import m19.app.exception.*;
import m19.core.LibraryManager;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  private Input<String> _file;  // FUI EU QUE PUS
  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    _file = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
      _form.parse();
      _receiver.load(_file.value());    
      
    } catch (FileNotFoundException fnfe){
      throw new FileOpenFailedException(_file.value());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }
}
