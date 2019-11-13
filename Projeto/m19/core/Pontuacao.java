package m19.core;

import java.io.Serializable;

public class Pontuacao implements Serializable{
    private boolean _situacao;
    private int _multa;
    private Classificacoes _classificacao;

    private static final long serialVersionUID = 201901101348L;

    public Pontuacao(){
        _situacao = true;
        _classificacao = Classificacoes.NORMAL;
        _multa = 0;
    }

    protected boolean obterSituacao(){
        return _situacao;
    }

    protected Classificacoes obterClassificacao(){
        return _classificacao;
    }

    protected int obterMulta(){
        return _multa;
    }

    protected void alteraSituacao(){
        if (_situacao)
            _situacao = false;
        else 
            _situacao = true;
    }

    //protected void alteraClassificacao(Classificacoes nvClassif){}

    protected void alteraMulta(int valor){
        _multa = valor;
    }

    protected String mostrarPontuacao(){
        String aux=_classificacao + " - ";
        if (_situacao==true) aux+="ACTIVO\n";
        else aux+= "SUSPENSO - EUR - "+_multa+"\n";
        return aux;
    }

    //protected void desejaPagar(){}

    //protected void pagarMulta(){}
}
