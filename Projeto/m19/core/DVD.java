package m19.core;
public class DVD extends Obra{
  private String _realizador;
  private String _numeroIGAC;

  public DVD(int id,String titulo, String realizador, int preco, 
  Categoria cat, String numeroIGAC,int exemplares){
      super(id,exemplares, titulo, preco, cat);
      _realizador=realizador;
      _numeroIGAC=numeroIGAC;
  }

  public String obterRealizador(){
    return _realizador;
  }
  public String obterNumeroIGAC(){
    return _numeroIGAC;
  }
  protected String mostrarObra(){
    return super.obterID()+" - "+super.obterExemlaresDisponiveis()+" de "+
    super.obterExemplares()+" - DVD - "+super.obterTitulo()+" - "+super.obterPreco()+
    " - "+super.obterCategoria().getCategoria()+" - "+_realizador+" - "+_numeroIGAC+"\n";
  }
}