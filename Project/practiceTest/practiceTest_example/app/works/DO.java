package m19.app.works;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.3.3. Perform search according to miscellaneous criteria.
 */
public class DO extends Command<LibraryManager> {

  private Input<Integer> _term;
  /**
   * @param m
   */
  public DO(LibraryManager m) {
    super("Localizador de Requisicoes", m);
    _term = _form.addIntegerInput(Message.requestSearchTerm());
  }

  
  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _display.popup(_receiver.performSearchRequest(_term.value()));
  }
  
}
 
       