package m19.core;

import m19.core.exception.RulesFailedException;
import java.io.Serializable;

interface Rule extends Serializable {
	static final long serialVersionUID = 201901101348L;
	
	public void check(User user, Work work) throws RulesFailedException;
}

class CheckRequestTwice implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if(user.hasActiveRequest(work)){ 
			throw new RulesFailedException(1); 
		}
	}
}

class CheckUserIsSuspended implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if (!user.getSituationActive()) {
			throw new RulesFailedException(2);
		}
	}
}

class CheckCopiesAvailable implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if (!work.areCopiesAvailable()) {
			throw new RulesFailedException(3);
		}
	}
}

class CheckNumberRequests implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if (user.getMaxNumber() == user.getNumberRequests()) {
			throw new RulesFailedException(4);
		}
	}
}

class CheckWorkCategory implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if (work.getCategory() == Category.REFERENCE) {
			throw new RulesFailedException(5);
		}
	}
}

class CheckWorkPrice implements Rule {

	public void check(User user, Work work) throws RulesFailedException {
		if (user.getClassification() != "CUMPRIDOR") {
			if (work.getPrice() > 25)
				throw new RulesFailedException(6);
		}
	}
}
