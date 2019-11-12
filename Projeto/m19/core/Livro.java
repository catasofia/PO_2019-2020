package m19.core;

public class Livro extends Obra{
  private String _autor;
  private String _iSBN;

  public Livro(int id, int exemplares, String titulo, int preco, 
    Categoria cat, String autor, String iSBN){
      super(id,exemplares, titulo, preco, cat);
      _autor = autor;
      _iSBN = iSBN;
  }

  public String obterAutor(){
    return _autor;
  }
  public String obterISBN(){
    return _iSBN;
  }
}