package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckRequestTwice extends Rule{
	
	public CheckRequestTwice(User user, Work work){
		super(user, work);
	}

	public void check(){
		if(super.getUser().hasRequest(super.getWork())){
			throw new RulesFailedException(1);
		}
	}
}
