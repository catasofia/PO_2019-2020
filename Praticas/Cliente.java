
public class Cliente{
  private String _nome;
  private Loja _loja;

  public Cliente(String nome){
    _nome = nome;
    _loja = null; 
    //Como temos um associaLoja, não sei se ele assume uma nova loja ou se temos de associar a uma loja
  }

  public String obterNome(){
    return _nome;
  }

  public void verCatalogo(){
    System.out.println("Catalogo!");
  }

  public void reclama(){
    if (_loja!=null) _loja.registaReclamacao();
  }

  public void associaLoja(Loja nvLoja){
    _loja = nvLoja;
  }

  public void compraProduto(double valor){
    if (_loja!=null) _loja.registarVenda(valor);
  }

  //Nao me recordo mas acho que teria

}