package m19.core;
import m19.core.exception.RulesFailedException;


public abstract class Rule{
	private User _user;
	private Work _work;
	

	public Rule(User user, Work work){
		_user = user;
		_work = work;
	}

	public User getUser(){
		return _user;
	}

	public Work getWork(){
		return _work;
	}
	public abstract void check() throws RulesFailedException;
}

