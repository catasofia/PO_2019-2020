package m19.core;
public enum Categoria{
  REFERENCE("Referência"),
  FICTION("Ficção"),
  SCITECH("Técnica e Científica");

  private final String _cat;
  private Categoria(String value) {
      _cat = value;
  }

  protected String getCategoria() {
      return _cat;
  }
}