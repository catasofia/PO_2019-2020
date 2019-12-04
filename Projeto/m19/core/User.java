package m19.core;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


public class User implements Serializable, Observer{
	private int _iDUser;
	private String _name;
	private String _email;
	private Situation _situation;
	private List<Notification> _notifications;
	private List<String> _messages;
	private Set<Request> _requests;

	private static final long serialVersionUID = 201901101348L;

	public User(int iDUser, String name, String email){
		_iDUser=iDUser;
		_name = name;
		_email = email;
		_situation = new Situation();
		_requests = new HashSet<Request>();
		_messages = new ArrayList<String>();
	}

	protected int getUserID(){
		return _iDUser;
	}

	protected String getName(){
		return _name;
	}
	
	protected String getEmail(){
		return _email;
	}

	protected Situation getSituation(){
		return _situation;
	}

	protected String showUser(){
		String aux = _iDUser + " - " + _name + " - " + _email + " - ";
		aux += _situation.showSituation();
		return aux;
	}

	protected void showNotification(int iDNotificacao){
		System.out.println(_notifications.get(iDNotificacao).getMessage());
	}
	
	protected void showNotifications(){
		for(Notification i: _notifications)
			showNotification(i.getID());
	}

	@Override
	public void update(String message){
		_messages.add(message);
	}

	/*protected void addNotification(String tipo, String mensagem){
			_notifications.add(new Notification(tipo, mensagem));
	}*/
}
