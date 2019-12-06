package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckUserIsSuspended extends Rule{
	
	public CheckUserIsSuspended(User user, Work work){
		super(user, work);
	}

	public void check(){  
		if (!super.getUser().getSituationActive()){
			throw new RulesFailedException(2);
		}
	}
}
