package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.2.4. Show all users.
 */
public class ObtemValor extends Command<LibraryManager> {
  /**
   * @param receiver
   */
  public ObtemValor(LibraryManager receiver) {
    super("Obtem Utente com maior valor", receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _display.popup(_receiver.obtemValor());
  }
}
