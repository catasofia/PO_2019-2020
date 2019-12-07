package m19.app.requests;

import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.DialogException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.WorkNotBorrowedByUserException;
import m19.core.LibraryManager;
import m19.core.exception.NoSuchUserIdException;
import m19.core.exception.NoSuchWorkIdException;

/**
 * 4.4.2. Return a work.
 */
public class DoReturnWork extends Command<LibraryManager> {
  private Input<Integer> _idUser;
  private Input<Integer> _idWork;

  /**
   * @param receiver
   */
  public DoReturnWork(LibraryManager receiver) {
    super(Label.RETURN_WORK, receiver);
    _idUser = _form.addIntegerInput(Message.requestUserId());
    _idWork = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      int rc = _receiver.returnWork(_idUser.value(), _idWork.value());
      if (rc == -1) throw new WorkNotBorrowedByUserException(_idWork.value(), _idUser.value());
      else if (rc > 0){
        _display.popup(Message.showFine(_idUser.value(), rc));
        Form form = new Form();
        Input <Boolean> option = form.addBooleanInput(Message.requestFinePaymentChoice());
        form.parse();
        if (option.value()){};

      }
    } catch (NoSuchUserIdException e){
      throw new NoSuchUserException(e.getId());
    } catch (NoSuchWorkIdException e){
      throw new NoSuchWorkException(e.getId());
    } 
  }
}
