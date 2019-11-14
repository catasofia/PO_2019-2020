package m19.core;

public enum Category{
  REFERENCE("Referência"),
  FICTION("Ficção"),
  SCITECH("Técnica e Científica");

  private final String _category;

  private Category(String value) {
    _category = value;
  }

  protected String getCategory() {
      return _category;
  }
}