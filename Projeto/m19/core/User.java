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
	private List<Notification> _notifications;
	//private List<String> _messages;
	//private Set<Request> _activeRequests;
	public Set<Work> _activeRequests;
	public List<Boolean> _lastReturns;
	private ClassificationInterface _classification;
	private boolean _active;
	private int _fine;

	private static final long serialVersionUID = 201901101348L;

	public User(int iDUser, String name, String email){
		_iDUser=iDUser;
		_name = name;
		_email = email;
		_activeRequests = new HashSet<Work>();
		//_activeRequests = new HashSet<Request>();
		//_messages = new ArrayList<String>();
		_notifications = new ArrayList<Notification>();
		_classification = new Normal();
		_lastReturns = new ArrayList<>();
		_lastReturns.add(true);
		_lastReturns.add(true);
		_lastReturns.add(true);
		_lastReturns.add(false);
		_lastReturns.add(false);
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

	protected boolean hasRequest(Work work){
		return _activeRequests.contains(work);
	}

	protected int getNumberRequests(){
		return _activeRequests.size();
	}

	protected void changeSituation(){
		_active = !(_active);
	}

	protected String showSituation(){
		String aux=_classification.toString() + " - ";
		if (_active) aux += "ACTIVO\n";
		else aux += "SUSPENSO - EUR - " + _fine + "\n";
		return aux;
}

	protected String showUser(){
		update();
		String aux = _iDUser + " - " + _name + " - " + _email + " - ";
		aux += showSituation();
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

	public String getClassification(){
		return _classification.toString();
	}

	public int getDeadline(int copies){
		return _classification.getDeadline(copies);
	}
	
	public void setFine(int nFine){
		_fine+=nFine;
	}

	public boolean getSituationActive(){
		return _active;
	}

	public int getMaxNumber(){
		return _classification.getMaxNumber();
	}

	@Override
	public void update(Notification message){
		_notifications.add(message);
	}

	@Override
	public void update(){
		/* if (_lastReturns.get(0)==_lastReturns.get(1)==_lastReturns.get(2)==_lastReturns.get(3)==_lastReturns.get(4)==true) _classification = new Responsible();
		else if(_lastReturns.get(0)==_lastReturns.get(1)==_lastReturns.get(2)==true){
			if (_classification.toString() == "Faltoso") _classification = new Normal();}
		else if (_lastReturns.get(0)==_lastReturns.get(1)==_lastReturns.get(2)==false)
			_classification = new Faulty(); */

	}

	public void doPayFine(){
		_fine = 0;
		//_active = true;
	}

	int getFine(){
		return _fine;
	}


}
