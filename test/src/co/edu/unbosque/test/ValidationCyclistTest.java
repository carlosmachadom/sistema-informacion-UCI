package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.*;

import co.edu.unbosque.helper.ValidationsCyclist;
import junit.framework.TestCase;

public class ValidationCyclistTest {

	String name, name2, name3;
	Double accelerationUphill, accelerationUpHill2;
	int speed, speed2;
	int degree, degree2;

	@Before
	public void setupName() {
		name = "Jaume Suarez";
		name2 = "Jáume, suarez";
		name3 = "1jaume223..2";
	}

	@Before
	public void setupSpeed() {
		speed = 12;
		speed2 = -12;
	}
	
	@Before
	public void setUpDegree() {
		degree = 15;
		degree2 = 400;
	}
	
	@Before
	public void setupSpeedUphill() {
		accelerationUphill = 15.2;
		accelerationUpHill2 = -30.2;
	}

	@Test
	public void testValidateNameTrue() {

		assertTrue("El nombre está bien escrito", ValidationsCyclist.verifyName(name));

	}

	@Test
	public void testValidateNameFalse() {

		assertFalse("Hay un error con el nombre", ValidationsCyclist.verifyName(name2));

	}

	@Test
	public void testValidateNameNumbers() {

		assertFalse("Hay un error con el nombre", ValidationsCyclist.verifyName(name3));
	}

	@Test
	public void testVerifySpeedTrue() {
		assertTrue("La velocidad es correcta", ValidationsCyclist.verifySpeedMax(speed));
	}

	@Test
	public void testVerifySpeedLessThanZero() {
		assertFalse("La velocidad es correcta", ValidationsCyclist.verifySpeedMax(speed2));
	}
	
	@Test
	public void testVerifyClimingDegreeTrue() {
		assertTrue("Los grados son correctos", ValidationsCyclist.verifyClimbingGrade(degree));
	}
	
	@Test
	public void testVerifyClimingDegreeOver360() {
		assertFalse("Los grados no deben ser mayores a 360", ValidationsCyclist.verifyClimbingGrade(degree2));
	}
	
	@Test
	public void testVerifyClimingDegreeNegative() {
		assertFalse("Los grados no deben ser negativos", ValidationsCyclist.verifyClimbingGrade(-degree));
	}
	
	@Test
	public void testVerifyAccelerationUphillTrue() {
		assertTrue("La velocidad es correcta", ValidationsCyclist.verifyAccelerationUphill(accelerationUphill));
	}
	@Test
	public void testVerifyAccelerationUphillLessThanZero() {
		assertFalse("La velocidad es correcta", ValidationsCyclist.verifyAccelerationUphill(accelerationUpHill2));
	}
	
	

}
