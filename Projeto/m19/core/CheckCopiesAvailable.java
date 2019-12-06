package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckCopiesAvailable extends Rule{
	
	public CheckCopiesAvailable(User user, Work work){
		super(user, work);
	}

	public void check(){
		if(!super.getWork().areCopiesAvailable()){
			throw new RulesFailedException(3);
		}
	}
}
