package m19.core;

import java.io.Serializable;

public class Date implements Serializable{
	private int _day;
	private static final long serialVersionUID = 201901101348L;

	public Date(){
		_day = 0;
	}

	protected int getDate(){
		return _day;
	}

	protected void changeDate(int nDay){
		if (nDay > 0 && _day >= 0) _day += nDay;
	}

}