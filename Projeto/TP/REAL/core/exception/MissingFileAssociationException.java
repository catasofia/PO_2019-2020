package m19.core.exception;
/** 
 * Represents the error case when an application is not associated yet with a file.
 */
public class MissingFileAssociationException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;
  public MissingFileAssociationException(){
    super("Erro:Não foi possivel associar/guardar o ficheiro!");
  }
  public MissingFileAssociationException(Exception e){
    super(e);
  }
  public MissingFileAssociationException(Throwable e){
    super(e);
  }
  
}
