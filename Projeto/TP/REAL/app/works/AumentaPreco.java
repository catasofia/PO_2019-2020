package m19.app.works;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.3.3. Perform search according to miscellaneous criteria.
 */
public class AumentaPreco extends Command<LibraryManager> {

  private Input<String> _term;
  /**
   * @param m
   */
  public AumentaPreco(LibraryManager m) {
    super("Aumenta Preço", m);
    _term = _form.addStringInput(Message.requestSearchTerm());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _display.popup(_receiver.aumetapreco(_term.value()));
  }
  
}
