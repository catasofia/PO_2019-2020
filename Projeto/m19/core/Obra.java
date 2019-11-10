public class Obra{
  private int _exemplares;
  private String _titulo;
  private int _preco;
  private Categoria _categoria;

  public Obra(int exemplares, String titulo, int preco, Categoria categoria){
    _exemplares=exemplares;
    _titulo=titulo;
    _preco=preco;
    _categoria=categoria;
  }

  public String obterTitulo(){
    return _titulo;
  }

  public int obterExemplares(){
    return _exemplares;
  }

  public int obterPreco(){
    return _preco;
  }

  public boolean existemExemplares(){
    return _exemplares != 0;
  }
  
  public void alteraExemplares(int nExemplares){
    _exemplares = nExemplares;
  }

  public boolean verificaDisponibilidade(){return true;}

  public void pesquisaTermo(String termo){}

}