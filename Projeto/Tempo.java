
public Tempo{
    private int _dia;

    public Tempo(){}

    public int obterDia(){
        return _dia;
    }

    public void alteraDia(int nvDia){
        if (nvDia > 0){
            _dia += nvDia;
        }
    }
}