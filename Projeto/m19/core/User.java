package m19.core;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable, Observer {
	private int _userId;
	private String _name;
	private String _email;
	private List<Notification> _notifications;
	private LinkedList<Request> _requests;
	private int _numRequests;
	private ClassificationInterface _classification;
	private boolean _active;
	private int _fine;

	private static final long serialVersionUID = 201901101348L;

	public User(int userId, String name, String email) {
		_userId = userId;
		_name = name;
		_email = email;
		_requests = new LinkedList<Request>();
		_numRequests = 0;
		_notifications = new ArrayList<Notification>();
		_classification = new Normal();
		_active = true;
		_fine = 0;
	}

	int getUserID() {
		return _userId;
	}

	String getName() {
		return _name;
	}

	String getEmail() {
		return _email;
	}

	int getNumberRequests() {
		return _numRequests;
	}

	void changeSituation() {
		_active = !_active;
	}

	void addWork(Request request) {
		_requests.addFirst(request);
		_numRequests++;
	}

	void removeWork(Request request) {
		_numRequests--;
	}

	boolean hasActiveRequest(Work work) {
		for (Request request : _requests) {
			if (request.getWork().equals(work) && request.getState())
				return true;
		}
		return false;
	}

	String showSituation() {
		String aux = _classification.toString() + " - ";
		if (_active)
			aux += "ACTIVO\n";
		else
			aux += "SUSPENSO - EUR " + _fine + "\n";
		return aux;
	}

	String showUser() {
		String aux = _userId + " - " + _name + " - " + _email + " - ";
		aux += showSituation();
		return aux;
	}

	String showNotification(int iDNotificacao) {
		if (_notifications.get(iDNotificacao) != null)
			return _notifications.get(iDNotificacao).toString();
		return "";
	}

	String showNotifications() {
		String str = "";
		for (int i = 0; i < _notifications.size(); i++)
			str += showNotification(i);
		return str;
	}

	void setClassification(ClassificationInterface classification) {
		_classification = classification;
	}

	String getClassification() {
		return _classification.toString();
	}

	int getFine() {
		return _fine;
	}

	int getDeadline(int copies) {
		return _classification.getDeadline(copies);
	}

	void setFine(int nFine) {
		_fine += nFine;
	}

	boolean getSituationActive() {
		return _active;
	}

	int getMaxNumber() {
		return _classification.getMaxNumber();
	}

	void doPayFine() {
		_fine = 0;
	}

	/* UPDATES */
	@Override
	public void update(Notification message) {
		_notifications.add(message);
	}

	@Override
	public void update() {
		int flag = 0;
		if (_requests.size() >= 3) {
			for (int i = 0; i < 3; i++) {
				if (_requests.get(i).daysLate() > 0)
					flag++;
			}
			if (flag == 0 && _classification.toString().equals("FALTOSO"))
				this._classification = new Normal();
			else if (flag == 3)
				_classification = new Faulty();
		}
		if (_requests.size() >= 5 && !_classification.toString().equals("CUMPRIDOR") && flag == 0) {
			for (int i = 0; i < 5; i++) {
				if (_requests.get(i).daysLate() > 0)
					flag = 2;
			}
			if (flag == 0)
				this._classification = new Responsible();
		}
	}

	@Override
	public void update(int day) {
		int flag = 0;
		for (Request request : _requests) {
			if ((day - request.getDeadline()) > 0 && request.getState())
				flag++;
		}
		if ((flag == 0 && !_active && _fine == 0) || (flag != 0 && _active) || (_fine != 0 && _active))
			changeSituation();
	}
}
