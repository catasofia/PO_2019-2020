public class Utente{
    private int _iDUtente;
    private String _nome;
    private String _email;
    private Pontuacao _pontuacao;
    private Notificacao[] _notificacoes;
    //private Requisicoes _requisicoes;

    public Utente(int iDUtente, String nome, String email){
        _iDUtente=iDUtente;
        _nome = nome;
        _email = email;
        _pontuacao = new Pontuacao();
        _notificacoes = new Notificacao[10];

    }

    public int obterIDUtente(){
        return _iDUtente;
    }

    public String obterNome(){
        return _nome;
    }
    
    public String obterEmail(){
        return _email;
    }

    public void mostrarUtente(){
        System.out.println(_iDUtente + " - " + _nome + " - " + _email); //FALTAM COISAS
    }

    public void mostrarNotificacao(int iDNotificacao){
        System.out.println(_notificacoes[iDNotificacao].obterMensagem());
    }
    /*
    public void mostrarNotificacoes(){
        for(int i=0;i<10;i++)
            mostrarNotificacao(i);
    }*/
}