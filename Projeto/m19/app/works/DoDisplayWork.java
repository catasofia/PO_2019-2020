package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import m19.core.exception.NoSuchWorkIdException;
// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _id;
  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    // FIXME initialize input fields
    _id = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    try{
      _form.parse();
      _display.popup(_receiver.displayWork(_id.value()));
    } catch (NoSuchWorkIdException e){
      throw new NoSuchWorkException(e.getId());
    }
  }
}
