package m19.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Observer;

public class Notification implements Serializable, ObservableInterface{
	private int _iD;
	private String _type;
	private String _message;
	private List<User> _observers;

	private static final long serialVersionUID = 201901101348L;

	public Notification(String type, String message){
		_type = type;
		_message = message;
		_observers = new ArrayList<User>();
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

	public void register(User observer){
		_observers.add(observer);
	}

	public void unregister(User observer){
		_observers.remove(observer);
	}

	public void notifyObservers(){
		for(User observer: _observers){
			observer.update(_message);
		}
	}

}
