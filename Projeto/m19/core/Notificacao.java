package m19.core;

import java.io.Serializable;

public class Notificacao implements Serializable{
    private int _id;
    private String _tipo;
    private String _mensagem;

    private static final long serialVersionUID = 201901101348L;
    
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

    public int obterID(){
        return _id;
    }
    
}
