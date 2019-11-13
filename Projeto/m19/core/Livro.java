package m19.core;

public class Livro extends Obra{
  private String _autor;
  private String _iSBN;

  public Livro(int id, String titulo, String autor, int preco, 
    Categoria cat, String iSBN,int exemplares){
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
  protected String mostrarObra(){
    return super.obterID()+" - "+super.obterExemlaresDisponiveis()+" de "+super.obterExemplares()+" - Livro - "+
    super.obterTitulo()+" - "+super.obterPreco()+" - "+super.obterCategoria()+" - "+
    _autor+" - "+_iSBN;
  }
}