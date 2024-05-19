package co.edu.unbosque.servicios;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.unbosque.helper.ValidationsUser;

/**
 * Clase EnvioCorreos se encarga de manejar el envío de correos electrónicos
 * mediante el uso del protocolo SMTP de Gmail.
 */
public class EnvioCorreos {

	private final String CORREO = "ucisystemmail@gmail.com";
	private final String CONTRASENA = "bfto kfoe lrgo zhtp";
	private String emailTo;
	private String subject;
	private String content;

	private Properties mProperties;
	private Session mSession;
	private MimeMessage mCorreo;

    /**
     * Constructor que inicializa las propiedades para la configuración del correo.
     */
	public EnvioCorreos() {
		mProperties = new Properties();
	}

	/**
     * Crea un correo electrónico con los detalles proporcionados.
     *
     * @param emailTo  Dirección de correo del destinatario.
     * @param subject  Asunto del correo.
     * @param content  Contenido del correo.
     * @return boolean indicando si el correo fue creado exitosamente.
     */
	public boolean createEmail(String emailTo, String subject, String content) {
		boolean flag = false;
		this.emailTo = emailTo;
		this.subject = subject;
		this.content = content;

		//TODO RETORNAR SI EL CORREO NO ES VALIDADO
		
		// protocolo de trasnferencia
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", CORREO);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSession = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSession);
			mCorreo.setFrom(new InternetAddress(CORREO));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "UTF-8", "html");
			flag = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
    /**
     * Envía el correo electrónico previamente creado.
     *
     * @return boolean indicando si el correo fue enviado exitosamente.
     */
	public boolean sendEmail() {
		boolean flag = false;
		try {
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(CORREO, CONTRASENA);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
			flag = true;
		} catch (NoSuchProviderException ex) {
			ex.printStackTrace();
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}
