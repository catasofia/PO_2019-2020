public class LibraryManager{
  private int _nUtentes;
  private int _nObras;
  private Utente[] _utentes;
  private Tempo _tempo;

  public LibraryManager(){
    _nUtentes = 0;
    _nObras = 0;
    _tempo = new Tempo();
    _utentes = new Utente[10];
  }

  public int mostrarData(){
    return _tempo.obterDia;
  }

  public void avançarData(int nvData){
    _tempo.alteraDia(nvData);
  }

  public void registarUtente(String nome, String email){
    _nUtentes++;
    _utentes[_nUtentes] = new Utente(nome,email);
  }

  public void mostrarUtente(int iDUtente){
    _utentes[iDUtente].mostrarUtente();
  }

  public void mostrarUtentes(){
    for (int i=0;i<=_nUtentes;i++)
      _utentes[i].mostrarUtente();
  }

  public void static main(String[] argv){
    mostrarData();
  }

}