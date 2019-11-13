package m19.core;
public class Pontuacao{
    private boolean _situacao;
    private int _multa;
    private Classificacoes _classificacao;

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
        if (_situacao==true) aux+="ACTIVO";
        else aux+= "SUSPENSO - EUR - "+_multa+"\n";
        return aux;
    }

    //protected void desejaPagar(){}

    //protected void pagarMulta(){}
}
