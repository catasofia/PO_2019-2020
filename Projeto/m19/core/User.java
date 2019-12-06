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
	//private List<String> _messages;
	//private Set<Request> _requests;
	private Set<Integer> _requests;
	private ClassificationInterface _classification;
	private boolean _active;
	private int _fine;

	private static final long serialVersionUID = 201901101348L;

	public User(int iDUser, String name, String email){
		_iDUser=iDUser;
		_name = name;
		_email = email;
		_situation = new Situation();
		_requests = new HashSet<Integer>();
		//_requests = new HashSet<Request>();
		//_messages = new ArrayList<String>();
		_notifications = new ArrayList<Notification>();
		_classification = new Normal();
		_active = true;
		_fine = 0;
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

	protected boolean hasRequest(int workId){
		return _requests.contains(workId);
	}

	protected String showUser(){
		String aux = _iDUser + " - " + _name + " - " + _email + " - ";
		aux += _situation.showSituation();
		return aux;
	}

	protected String showNotification(int iDNotificacao){
		if (_notifications.get(iDNotificacao)!=null) //ADICIONADO PARA PASSAR TESTES
			return _notifications.get(iDNotificacao).getMessage();
		return "";
	}
	
	protected String showNotifications(){
		String str="";
		for (int i = 0; i<_notifications.size();i++)
			str+=showNotification(i);
		return str;
	}

	public void setClassification(ClassificationInterface classification){
		_classification = classification;
	}

	public ClassificationInterface getClassification(){
		return _classification;
	}

	public int getDeadline(int copies){
		return _classification.getDeadline(copies);
	}

	public boolean getSituationActive(){
		return _active;
	}

	@Override
	public void update(Notification message){
		_notifications.add(message);
	}

	@Override
	public void update(){
		//altera situação 
	}

	public void doPayFine(){
		_fine = 0;
	}

	/*protected void addNotification(String tipo, String mensagem){
			_notifications.add(new Notification(tipo, mensagem));
	}*/
}
