package m19.core;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable, Observer {
	private int _iDUser;
	private String _name;
	private String _email;
	private List<Notification> _notifications;
	private LinkedList<Request> _requests;
	private int _numRequests;
	private ClassificationInterface _classification;
	private boolean _active;
	private int _fine;

	private static final long serialVersionUID = 201901101348L;

	public User(int iDUser, String name, String email) {
		_iDUser = iDUser;
		_name = name;
		_email = email;
		_requests = new LinkedList<Request>();
		_numRequests = 0;
		_notifications = new ArrayList<Notification>();
		_classification = new Normal();
		_active = true;
		_fine = 0;
	}

	protected int getUserID() {
		return _iDUser;
	}

	protected String getName() {
		return _name;
	}

	protected String getEmail() {
		return _email;
	}

	/*
	 * protected boolean hasRequest(Request work){ return
	 * _activeRequests.contains(work); }
	 */

	protected int getNumberRequests() {
		return _numRequests;
	}

	protected void changeSituation() {
		_active = !_active;
	}

	void addWork(Request request) {
		_requests.addFirst(request);
		_numRequests++;
	}

	int removeWork(Request request) {
		for (int i = 0; i < _requests.size(); i++) {
			if (_requests.get(i).equals(request) && _requests.get(i).getState()) {
				_numRequests--;
				return 0;
			}
		}
		return -1;
	}

	boolean hasActiveRequest(Work work) {
		for (int i = 0; i < _requests.size(); i++) {
			if (_requests.get(i).getWork() == work && _requests.get(i).getState()) // VER ESTA BOSTA -> WTF -> PARA PASSAR
																																							// TESTES
				return true;
		}
		return false;
	}

	protected String showSituation() {
		String aux = _classification.toString() + " - ";
		if (_active)
			aux += "ACTIVO\n";
		else
			aux += "SUSPENSO - EUR " + _fine + "\n";
		return aux;
	}

	protected String showUser() {
		String aux = _iDUser + " - " + _name + " - " + _email + " - ";
		aux += showSituation();
		return aux;
	}

	protected String showNotification(int iDNotificacao) {
		if (_notifications.get(iDNotificacao) != null) // ADICIONADO PARA PASSAR TESTES
			return _notifications.get(iDNotificacao).getMessage();
		return "";
	}

	protected String showNotifications() {
		String str = "";
		for (int i = 0; i < _notifications.size(); i++)
			str += showNotification(i);
		return str;
	}

	public void setClassification(ClassificationInterface classification) {
		_classification = classification;
	}

	public String getClassification() {
		return _classification.toString();
	}

	public int getDeadline(int copies) {
		return _classification.getDeadline(copies);
	}

	public void setFine(int nFine) {
		_fine += nFine;
	}

	public boolean getSituationActive() {
		return _active;
	}

	public int getMaxNumber() {
		return _classification.getMaxNumber();
	}

	@Override
	public void update(Notification message) {
		_notifications.add(message);
	}

	@Override
	public void update() {
		int flag = 0;
		if (_requests.size() >= 3) {
			for (int i = 0; i < 3; i++) {
				// System.out.println("1º"+_requests.get(i).daysLate());
				if (_requests.get(i).daysLate() > 0)
					flag++;
				if (flag == 0 && _classification.toString().equals("FALTOSO"))
					this._classification = new Normal();
				else if (flag == 3 /* && _classification.toString().equals("NORMAL")) */)
					_classification = new Faulty();
			}
		}
		flag = 0;
		if (_requests.size() >= 5 && !_classification.toString().equals("CUMPRIDOR")) {
			for (int i = 0; i < 5; i++) {
				// System.out.println("2º"+_requests.get(i).daysLate());
				if (_requests.get(i).daysLate() > 0)
					flag = 2;
				if (flag == 0)
					this._classification = new Responsible();
			}
		}
	}

	@Override
	public void update(int day) {
		int flag = 0;
		for (int i = 0; i < _requests.size(); i++) {
			if ((day - _requests.get(i).getDeadline()) > 0 && _requests.get(i).getState())
				flag++;
		}

		// System.out.println(flag);
		if (flag == 0 && !_active && _fine == 0)
			_active = true;
		else if (flag != 0 && _active)
			changeSituation();
		if (_fine != 0)
			_active = false;
	}

	void doPayFine() {
		_fine = 0;
	}

	int getFine() {
		return _fine;
	}

}
