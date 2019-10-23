public class Notificacao{
    private String _tipo;
    private String _mensagem;

    public Notificacao(String tipo, String mensagem){
        _tipo = tipo;
        _mensagem = mensagem;
    }

    public String obterTipo(){
        return _tipo;
    }

    public String obterMensagem(){
        return _mensagem;
    }
}
