public class Tempo{
    private int _dia;

    public Tempo(){
        _dia = 0;
    }

    public int obterDia(){
        return _dia;
    }

    public void alteraDia(int nvDia){
        if (nvDia > 0 && _dia>0){
            _dia += nvDia;
        }
    }
}