package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckWorkCategory extends Rule{
	
	public CheckWorkCategory(int idUser, int idWork, User user){
		super(idUser, idWork, user);
	}

	public void check(){
	/* 	if(super.getUser().hasRequest(super.getIdWork())){
			throw new RulesFailedException(super.getIdUser(), super.getIdWork(), 1);
			}
	} */
	}
}
