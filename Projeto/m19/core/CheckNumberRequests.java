package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckNumberRequests extends Rule{
	
	public CheckNumberRequests(User user, Work work){
		super(user, work);
	}

	public void check(){
		if(super.getUser().getMaxNumber() == super.getUser().getNumberRequests()){
			throw new RulesFailedException(4);
		}
	}
}
