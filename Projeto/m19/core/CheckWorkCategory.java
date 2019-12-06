package m19.core;
import m19.core.Category;
import m19.core.exception.RulesFailedException;

public class CheckWorkCategory implements Rule{

	public void check(User user, Work work) throws RulesFailedException{
	if(work.getCategory() == Category.REFERENCE){
		throw new RulesFailedException(5);
		}
	}
}

