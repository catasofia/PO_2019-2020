package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckWorkPrice extends Rule{
	
	public void check(User user, Work work){
		if(super.getUser().getClassification() != "CUMPRIDOR"){
            if(super.getWork().getPrice() > 25)
			    throw new RulesFailedException(6);
		}
	}
}
