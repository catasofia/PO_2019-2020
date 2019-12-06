package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckRequestTwice implements Rule{

	public void check(User user, Work work) throws RulesFailedException{
		if(user.hasRequest(work)){
			throw new RulesFailedException(1);
		}
	}
}
