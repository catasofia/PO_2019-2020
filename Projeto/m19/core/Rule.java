package m19.core;
import m19.core.exception.RulesFailedException;
import java.io.Serializable;


public interface Rule extends Serializable{
  static final long serialVersionUID = 201901101348L;
/* 	private User _user;
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
	} */
	public void check(User user, Work work) throws RulesFailedException;
}

