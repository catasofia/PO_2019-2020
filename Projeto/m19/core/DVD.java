public class DVD extends Obra{
  private String _realizador;
  private String _numeroIGAC;

  public DVD(int exemplares, String titulo, int preco, 
    Categoria cat, String realizador, String numeroIGAC){
      super(exemplares, titulo, preco, cat);
      _realizador=realizador;
      _numeroIGAC=numeroIGAC;
  }

  public String obterRealizador(){
    return _realizador;
  }
  public String obterNumeroIGAC(){
    return _numeroIGAC;
  }
}