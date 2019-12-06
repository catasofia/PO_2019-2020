package m19.core;
import java.io.Serializable;

public class Responsible implements Serializable, ClassificationInterface{
	private static final long serialVersionUID = 201901101348L;
	public int getDeadline(int copies){
		if (copies == 1) return 8;
		else if (copies <= 5) return 15;
		else return 30;
	}
}