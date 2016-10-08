package br.com.keylogger;

public interface Subject {
	public void addOberser(Observer o);
	public void removeObserver(Observer o);
	public void removeObserver(int index);
	public void notifyObserver();
}
