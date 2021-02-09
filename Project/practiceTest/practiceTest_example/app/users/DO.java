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
public class DO extends Command<LibraryManager> {
  private Input<String> _id;

  /**
   * @param receiver
   */
  public DO(LibraryManager receiver) {
    super("Localizador Utente", receiver);
    _id = _form.addStringInput("Termo:");
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    _display.popup(_receiver.pesquisaUser(_id.value()));
  }
}
