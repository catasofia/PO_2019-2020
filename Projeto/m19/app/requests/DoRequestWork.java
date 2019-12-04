package m19.app.requests;

import m19.core.LibraryManager;
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
  public final void execute() throws DialogException {
    _form.parse();
    try{
      int day = _receiver.requestWork(_idUser.value(), _idWork.value());
      _display.popup(Message.workReturnDay(_idWork.value(), day));
    }catch(Exception e) {System.out.println("x");} 
  }

}
