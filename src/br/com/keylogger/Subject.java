package br.com.keylogger;

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void removeObserver(int index);
	public void notifyObserver();
}
