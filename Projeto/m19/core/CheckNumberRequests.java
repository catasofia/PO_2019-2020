package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckNumberRequests implements Rule{

	public void check(User user, Work work) throws RulesFailedException{
		if(user.getMaxNumber() == user.getNumberRequests()){
			throw new RulesFailedException(4);
		}
	}
}
