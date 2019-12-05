package m19.core;

import m19.app.exception.RuleFailedException;

public class CheckUserIsSuspended extends Rule{
    public CheckUserIsSuspended(int idUser, int idWork){
        super(idUser, idWork);
    }

    public void check(){
        
        /* if (!user.getSituationActive()){
            throw new RuleFailedException(super.getIdUser(), super.getIdWork(), 2);
        } */
    }
}
