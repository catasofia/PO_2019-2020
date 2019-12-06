package m19.core;
import m19.core.exception.RulesFailedException;


public abstract class Rule{
	private int _idUser;
	private int _idWork;
	private User _user;
	

	public Rule(int idUser, int idWork, User user){
		_idUser = idUser;
		_idWork = idWork;
		_user = user;
	}

	public int getIdUser(){
		return _idUser;
	}

	public int getIdWork(){
		return _idWork;
	}

	public User getUser(){
		return _user;
	}
	public abstract void check()/*  throws RulesFailedException */;
}

