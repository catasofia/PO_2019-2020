package m19.core;
public class DVD extends Work{
  private String _realizador;
  private String _numeroIGAC;

  public DVD(int id,String titulo, String realizador, int preco, 
  Category cat, String numeroIGAC,int exemplares){
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
    return super.getID()+" - "+super.getCopiesAvailable()+" de "+
    super.getCopies()+" - DVD - "+super.getTitle()+" - "+super.getPrice()+
    " - "+super.getCategory().toString()+" - "+_realizador+" - "+_numeroIGAC+"\n";
  }
}