package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckUserIsSuspended implements Rule{
	
	public void check(User user, Work work) throws RulesFailedException{  
		if (!user.getSituationActive()){
			throw new RulesFailedException(2);
		}
	}
}
