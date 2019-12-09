package m19.core;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable, Observer {
	private int _userId;
	private String _name;
	private String _email;
	private boolean _active;
	private Classification _classification;
	private int _fine;
	private int _activeRequests;
	private Map<Integer, Request> _requests;
	private List<Notification> _notifications;

	private static final long serialVersionUID = 201901101348L;

	public User(int userId, String name, String email) {
		_userId = userId;
		_name = name;
		_email = email;
		_active = true;
		_classification = new Normal();
		_fine = 0;
		_activeRequests = 0;
		_requests = new HashMap<Integer, Request>();
		_notifications = new ArrayList<Notification>();
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
		return _activeRequests;
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
	
	boolean getSituationActive() {
		return _active;
	}

	int getMaxNumber() {
		return _classification.getMaxNumber();
	}

	void changeSituation() {
		_active = !_active;
	}

	void addWork(Request request) {
		_requests.put(_requests.size(), request);
		_activeRequests++;
	}

	void removeWork() {
		_activeRequests--;
	}

	boolean hasActiveRequest(Work work) {
		for (Request request : _requests.values()) {
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

	void setClassification(Classification classification) {
		_classification = classification;
	}

	void setFine(int nFine) {
		_fine += nFine;
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
		int flag = 0, last = _requests.size() - 1;

		if (last >= 2) {
			for (int i = last; i > last - 3; i--) {
				if (_requests.get(i).daysLate() > 0)
					flag++;
			}

			if (flag < 3)
				_classification = new Normal();
			else if (flag == 3)
				_classification = new Faulty();
		}

		if (last >= 4 && flag == 0) {
			for (int i = last; i > last - 5; i--) {
				if (_requests.get(i).daysLate() > 0)
					flag = 2;
			}
			if (flag == 0)
				_classification = new Responsible();
		}
	}

	@Override
	public void update(int day) {
		int flag = 0;
		for (Request request : _requests.values()) {
			if (day > request.getDeadline() && request.getState())
				flag++;
		}
		if ((flag == 0 && !_active && _fine == 0) || (flag != 0 && _active) || (_fine != 0 && _active))
			changeSituation();
	}
}
