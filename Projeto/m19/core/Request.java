package m19.core;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;;

public class Request implements Serializable{
  private int _deadline;
  private User _user;
  private Work _work;
  private static final long serialVersionUID = 201901101348L;

  public Request(User user, Work work, int date){
    _user = user;
    _work = work;
    _deadline = makeDeadline(date);
    _work.decreaseCopies(1);
  }

  User getUser(){
    return _user;
  }
  Work getWork(){
    return _work;
  }
  int getDeadline(){
    return _deadline;
  }

  int makeDeadline(int day){
    int copies = _work.getCopiesAvailable();
    return day += _user.getDeadline(copies);
  }


  public boolean verifySituation(User user){
    //_user.obterPontuacao().obterSituacao();
    return true;
  }
  
  public boolean areCopiesAvailable(Work work){
    return _work.areCopiesAvailable();
  }
  
  //+verificaNObras(user: Utente) : boolean+verificaCategoria(work: Obra) : boolean+verificaPreco(user: Utente, work: Obra) : boolean+requisitarObra(user: Utente, work: Obra) : void+devolverObra(user: Utente, work: Obra) : void+obterDataDevolucao(user: Utente, work: Obra) : in

}