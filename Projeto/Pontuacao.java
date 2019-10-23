public Pontuacao{
    private boolean _situacao;
    private int _multa;
    private enum<Classificacoes> _classificacao;

    public Pontuacao(){
        _situacao = true;
        _classificacao = NORMAL;
        _multa = 0;
    }

    public boolean obterSituacao(){
        return _situacao;
    }

    public Classificacoes obterClassificacao(){
        return _classificacao;
    }

    public int obterMulta(){
        return _multa;
    }

    public void alteraSituacao(){
        if (_situacao)
            _situacao = false;
        _situacao = true;
    }

    public void alteraClassificacao(Classificacoes nvClassif){

    }

    public void alteraMulta(int valor){
        _multa = valor;
        //multa += valor;
    }

    //public void desejaPagar(){

    //}

    //public void pagarMulta(){

    //}
}
