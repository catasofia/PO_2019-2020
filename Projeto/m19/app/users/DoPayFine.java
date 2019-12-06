package m19.app.users;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.UserIsActiveException;
import m19.core.LibraryManager;
import m19.core.exception.NoSuchUserIdException;
import m19.core.exception.UserActiveException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Form;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.5. Settle a fine.
 */
public class DoPayFine extends Command<LibraryManager> {
  private Input<Integer> _id;
  /**
   * @param receiver
   */
  public DoPayFine(LibraryManager receiver) {
    super(Label.PAY_FINE, receiver);
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try{
      Form form = new Form();
      Input <Boolean> option = form.addBooleanInput("");
      form.parse();
      if (option.value()){_receiver.doPayFine(_id.value());}
      
    } catch (NoSuchUserIdException e){
      throw new NoSuchUserException(e.getId());
    } catch(UserActiveException e){
      throw new UserIsActiveException(e.getId());
    }
  }
}
