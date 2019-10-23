

public class Notificacao{
    private String _tipo;
    private String _mensagem;

    public Notificacao(String tipo, String mensagem){
        _tipo = tipo;
        _mensagem = mensagem;
    }

    public obterTipo(){
        return _tipo;
    }

    public obterMensagem(){
        return _mensagem;
    }
}
