package m19.core;

public interface ObservableInterface {
	public void register(User observer);

	public void unregister(User observer);

	public void notifyObservers(String message);
}
