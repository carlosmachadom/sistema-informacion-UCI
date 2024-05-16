package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.helper.ValidationsUser;

public class ValidationsUserTest {

	String mail, mail2, mail3, mail4, mail5;
	int exp, exp2;
	
	@Before
	public void setUpEmail() {
		mail = "correoelectronico@gmail.com";
		mail2 = "correoelectronico";
		mail3 = "@gmail.com";
		mail4 = "correoelectronico@gmail";
		mail5 = "estudiante@unbosque.edu.co";
	}
	@Before
	public void setUpExpererience() {
		exp = 15;
		exp = -16;
	}

	@Test
	public void testverifyEmail() {
		assertTrue("El correo es correcto",ValidationsUser.verifyEmail(mail));
		assertTrue("El correo es correcto",ValidationsUser.verifyEmail(mail5));
	}
	

	@Test
	public void testverifyEmailnoAT() {
		assertFalse("El correo es tiene problemas, no tiene arroba y dirección",ValidationsUser.verifyEmail(mail2));
	}
	
	@Test
	public void testverifyEmailnoOnlyAT() {
		assertFalse("El correo es tiene problemas, no tiene cuerpo",ValidationsUser.verifyEmail(mail3));
	}
	
	@Test
	public void testverifyEmailNoDotCom() {
		assertFalse("El correo es tiene problemas, no tiene '.com'",ValidationsUser.verifyEmail(mail4));
	}
	
	@Test
	public void testVerifyExperience() {
		assertTrue("La experiencia es correcta", ValidationsUser.verifyExperience(exp));
	}
	public void testVerifyExperienceNegative() {
		assertFalse("La experiencia es correcta", ValidationsUser.verifyExperience(exp2));
	}
}
