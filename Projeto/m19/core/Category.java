package m19.core;

public enum Category{
  REFERENCE("Referência"),
  FICTION("Ficção"),
  SCITECH("Técnica e Científica");

  private final String _category;

  private Category(String category) {
    _category = category;
  }

  @Override
  public String toString() {
      return _category;
  }
}
