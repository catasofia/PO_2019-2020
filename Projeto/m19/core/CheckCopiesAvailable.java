package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckCopiesAvailable implements Rule{

	public void check(User user, Work work) throws RulesFailedException{
		if(!work.areCopiesAvailable()){
			throw new RulesFailedException(3);
		}
	}
}
