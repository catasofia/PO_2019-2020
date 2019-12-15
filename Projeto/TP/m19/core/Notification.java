package m19.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Observer;

public class Notification implements Serializable {

	private static final long serialVersionUID = 201901101348L;
	private String _type;
	private String _message;

	public Notification(String type, String message) {
		_type = type;
		_message = message;
	}

	String getType() {
		return _type;
	}

	String getMessage() {
		return _message;
	}

	@Override
	public String toString() {
		return _type + _message;
	}
}
