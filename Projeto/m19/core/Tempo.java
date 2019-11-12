package m19.core;


public class Tempo{
	private int _dia;

	public Tempo(){
		_dia = 0;
	}

	protected int obterDia(){
		return _dia;
	}

	protected void alteraDia(int nvDia){
		if (nvDia > 0 && _dia >= 0)
			_dia += nvDia;
	}

}