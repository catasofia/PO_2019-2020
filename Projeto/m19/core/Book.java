package m19.core;

public class Book extends Work{
  private String _autor;
  private String _iSBN;

  public Book(int id, String titulo, String autor, int preco, 
    Category cat, String iSBN,int exemplares){
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
    return super.getID()+" - "+super.getCopiesAvailable()+" de "+
    super.getCopies()+" - Livro - "+super.getTitle()+" - "+super.getPrice()+
    " - "+super.getCategory().toString()+" - "+_autor+" - "+_iSBN+"\n";
  }
}