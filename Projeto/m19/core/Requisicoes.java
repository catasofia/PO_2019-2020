package m19.core;
public class Requisicoes{
  private int _dataRequisicao;
  private int _dataDevolucao;
  private Utente _utente;
  private Obra _obra;

  public Requisicoes(Utente utente, Obra obra, int dia){
    _utente = utente;
    _obra = obra;
    _dataRequisicao = dia;
  }

  public boolean verificaSituacao(Utente utente){
    //_utente.obterPontuacao().obterSituacao();
    return true;
  }
  
  public boolean verificaDisponiblidade(Obra obra){
    return _obra.verificaDisponibilidade();
  }
  
  //+verificaNObras(utente: Utente) : boolean+verificaCategoria(obra: Obra) : boolean+verificaPreco(utente: Utente, obra: Obra) : boolean+requisitarObra(utente: Utente, obra: Obra) : void+devolverObra(utente: Utente, obra: Obra) : void+obterDataDevolucao(utente: Utente, obra: Obra) : in

}