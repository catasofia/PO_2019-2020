package m19.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import m19.core.LibraryManager;
import m19.app.exception.FileOpenFailedException;
import java.io.IOException;
import java.io.FileNotFoundException;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  // FIXME define input fields if needed
  private Input<String> _file;  // FUI EU QUE PUS
  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    _file = _form.addStringInput(Message.openFile());
    // FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
      _form.parse();    //FUI EU QUE PUS
      _receiver.setFileName(_file.value());        //FUI EU QUE PUS
      _receiver.open(_file.value());    //FUI EU QUE PUS

      /*List<String> lista = _receiver.readAllNotification();
      for(String s: lista){
        _display.addLine(s);
      }
      _display.display();*/
      // FIXME implement command
    } catch (FileNotFoundException fnfe) {
      throw new FileOpenFailedException(fnfe /* fill with the missing file name*/);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
