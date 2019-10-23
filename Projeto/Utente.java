public class Utente{
    private int _iDUtente;
    private String _nome;
    private String _email;
    private Pontuacao _pontuacao;
    private Notificacao _notificacoes;
    private Requisicoes _requisicoes;

    public Utente(int iDUtente, String nome, String email){
        _nome = nome;
        _email = email;
        _pontuacao = new Pontuacao();

    }

    public int obterIDUtente(){
        return _iDUtente;
    }

    public Strign obterNome(){
        return _nome;
    }
    
    public String obterEmail(){
        return _email;
    }

    public void mostrarUtente(){
        System.out.println(_iDUtente + " - " + _nome + " - " + _email) //FALTAM COISAS
    }
}