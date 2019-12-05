package m19.core;

public abstract class Rule{
	private int _idUser;
	private int _idWork;

	public Rule(int idUser, int idWork){
		_idUser = idUser;
		_idWork = idWork;
	}

	public int getIdUser(){
		return _idUser;
	}

	public int getIdWork(){
		return _idWork;
	}
	public abstract void check();
}

