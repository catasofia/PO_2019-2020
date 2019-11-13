package m19.core;
public enum Categoria{
  REFERENCE("Referência"),
  FICTION("Ficção"),
  SCITECH("Ciencia");
  //TECNICAS_E_CIENTIFICAS;
  private String _cate;

  private Categoria(String cate){
    _cate=cate;
  }

}