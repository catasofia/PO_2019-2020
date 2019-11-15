package m19.app.users;

import m19.core.LibraryManager;
import m19.core.exception.UserRegistFailedException;
import m19.app.exception.UserRegistrationFailedException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {

  private Input<String> _nome;
  private Input<String> _email;

  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);
    _nome = _form.addStringInput(Message.requestUserName());
    _email = _form.addStringInput(Message.requestUserEMail());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    /*if (!_nome.value().isEmpty() && !_email.value().isEmpty()){ 
      _receiver.registarUtente(_nome.value(),_email.value());
      _display.addLine(Message.userRegistrationSuccessful(_receiver.nextUtente()-1));
      _display.display();
    }
    else throw new UserRegistrationFailedException(_nome.value(), _email.value());*/

    try{
      _receiver.registerUser(_nome.value(), _email.value());
      _display.popup(Message.userRegistrationSuccessful(_receiver.getNextUtente() - 1));
    } catch (UserRegistFailedException e){
      throw new UserRegistrationFailedException(e.getName(), e.getEmail());
    }
  
  }
}
