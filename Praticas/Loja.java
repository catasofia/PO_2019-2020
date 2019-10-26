public class Loja{
  private int _vendas;
  private int _reclamacoes;
  private double _valor;

  public Loja(){
      _vendas = 0;
      _reclamacoes = 0;
      _valor = 0;
  }

  public int obterVendas(){
      return _vendas;
  }
  
  public int obterReclamacoes(){
      return _reclamacoes;
  }
  
  public double obterValor(){
      return _valor;
  }

  public void registaReclamacao(){ _reclamacoes++; }

  public void registarVenda(double valor){
    if (valor>=0){
        _vendas++;
        _valor+=valor;
    }
    
  }

}