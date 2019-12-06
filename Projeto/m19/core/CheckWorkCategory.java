package m19.core;
import m19.core.Category;
import m19.core.exception.RulesFailedException;

public class CheckWorkCategory extends Rule{
	
	public CheckWorkCategory(User user, Work work){
		super(user, work);
	}

	public void check(){
	if(super.getWork().getCategory() == Category.REFERENCE){
		throw new RulesFailedException(5);
		}
	}
}

