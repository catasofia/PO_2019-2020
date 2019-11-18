package m19.core;

import java.io.Serializable;

public class Notification implements Serializable{
	private int _iD;
	private String _type;
	private String _message;

	private static final long serialVersionUID = 201901101348L;
	
	public Notification(String type, String message){
		_type = type;
		_message = message;
	}

	public String getType(){
		return _type;
	}

	public String getMessage(){
		return _message;
	}

	public int getID(){
		return _iD;
	}
}
