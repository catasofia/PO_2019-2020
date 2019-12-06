package m19.core;

import java.io.Serializable;

class Normal implements Serializable, ClassificationInterface{
	private static final long serialVersionUID = 201901101348L;

	@Override
	public String toString(){
		return "NORMAL";
	}

	public int getDeadline(int copies){
		if (copies == 1) return 3;
		else if (copies <= 5) return 8;
		else return 15;
	}
}

class Faulty implements Serializable, ClassificationInterface{
	private static final long serialVersionUID = 201901101348L;

	@Override
	public String toString(){
		return "FALTOSO";
	}

	public int getDeadline(int copies){ return 2; }
}

class Responsible implements Serializable, ClassificationInterface{
	private static final long serialVersionUID = 201901101348L;

	@Override
	public String toString(){
		return "CUMPRIDOR";
	}

	public int getDeadline(int copies){
		if (copies == 1) return 8;
		else if (copies <= 5) return 15;
		else return 30;
	}
}
