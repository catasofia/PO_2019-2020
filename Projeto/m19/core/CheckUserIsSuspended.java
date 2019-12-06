package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckUserIsSuspended extends Rule{
	
	public CheckUserIsSuspended(int idUser, int idWork, User user){
		super(idUser, idWork, user);
	}

	public void check(){  
		/* if (!super.getUser().getSituationActive()){
			throw new RulesFailedException(super.getIdUser(), super.getIdWork(), 2);
		} */
	}
}
