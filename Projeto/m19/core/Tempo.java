package m19.core;

import java.io.Serializable;

public class Tempo implements Serializable{
	private int _dia;

	private static final long serialVersionUID = 201901101348L;

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