package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckWorkPrice implements Rule{
	
	public void check(User user, Work work){
		if(user.getClassification() != "CUMPRIDOR"){
            if(work.getPrice() > 25)
			    throw new RulesFailedException(6);
		}
	}
}
