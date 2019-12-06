package m19.app.requests;

import m19.core.LibraryManager;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.RuleFailedException;
import m19.core.exception.NoSuchUserIdException;
import m19.core.exception.NoSuchWorkIdException;
import m19.core.exception.RulesFailedException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

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
        Form form = new Form();
        Input <Boolean> option = form.addBooleanInput(Message.requestReturnNotificationPreference());
        form.parse();
        if (option.value()){_receiver.addUserInterested(_idUser.value(), _idWork.value()); }
      }
      else _display.popup(Message.workReturnDay(_idWork.value(), day));
    }catch(NoSuchUserIdException e){
      throw new NoSuchUserException(e.getId());
    }catch(NoSuchWorkIdException e){
      throw new NoSuchWorkException(e.getId());
    }catch(RulesFailedException e){
      throw new RuleFailedException(e.getUser(), e.getWork(), e.getRuleIndex());
    }
  }
}
