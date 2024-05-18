package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.servicios.EnvioCorreos;

public class EnvioCorreosTest {

	EnvioCorreos mailController;
	String mailTo, subject, content;

	@Before
	public void setUp() {
		mailController = new EnvioCorreos();
		mailTo = "mguerram@unbosque.edu.co";
		subject = "Aquí está tu correo madafaka gonorrea";
		content = "Aquí tienes el correo de confirmación de tu cuenta para competir";
		mailController.createEmail(mailTo, subject, content);
	}
	
	@Before
	public void setUp2() {
		EnvioCorreos m = new EnvioCorreos();
		String to, sub, content;
		to = "mguerram@unbosque.edu.co";
		sub = "Test evio";
		content = "El test ha sido exitoso";
		m.createEmail(to, sub, content);
	}

	@Test
	public void testCrearMailTest() {
		 assertTrue("Se creó el mail", mailController.createEmail(mailTo, subject,
		 content));
	}

	@Test
	public void testEnviarCorreo() {
		assertTrue("Se envió el mail", mailController.sendEmail());
	}

}
