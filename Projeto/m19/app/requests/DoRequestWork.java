package m19.app.requests;

import m19.core.LibraryManager;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.NoSuchUserIdException;
import m19.core.exception.NoSuchWorkIdException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.4.1. Request work.
 */
public class DoRequestWork extends Command<LibraryManager> {

  private Input<Integer> _idUser;
  private Input<Integer> _idWork;

  /**
   * @param receiver
   */
  public DoRequestWork(LibraryManager receiver) {
    super(Label.REQUEST_WORK, receiver);
    _idUser = _form.addIntegerInput(Message.requestUserId());
    _idWork = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException{
    _form.parse();
    try{
      int day = _receiver.requestWork(_idUser.value(), _idWork.value());
      if(day == -1){
        _display.popup(Message.requestReturnNotificationPreference());
        //se a resposta for sim, adicionar ao observer, se for não CAGA nisso
      }
      _display.popup(Message.workReturnDay(_idWork.value(), day));
    }catch(NoSuchUserIdException e){
      throw new NoSuchUserException(e.getId());
    }catch(NoSuchWorkIdException e){
      throw new NoSuchWorkException(e.getId());
    }
  }

}
