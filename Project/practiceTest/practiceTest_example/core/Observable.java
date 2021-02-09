package m19.core;

public interface Observable {
	public void register(User observer);

	public void unregister(User observer);

	public void notifyObserversDeliver(String message);

	public void notifyObserversRequest(String message);
}
