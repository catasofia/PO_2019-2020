package m19.core;

public interface Observer {
	public void update(Notification message);

	public void update();

	public void update(int day);
}
