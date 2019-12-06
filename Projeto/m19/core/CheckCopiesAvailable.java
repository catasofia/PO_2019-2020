package m19.core;
import m19.core.exception.RulesFailedException;

public class CheckCopiesAvailable extends Rule{
	
	public CheckCopiesAvailable(int idUser, int idWork, User user){
		super(idUser, idWork, user);
	}

	public void check(){
		
	}
}
