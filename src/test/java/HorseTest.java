import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
public class HorseTest {
	@Test
	public void nullNameException() {
		Assert.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 2));
	}
	@Test
	public void nullNameMessage() {
		try {
			new Horse(null, 2, 3);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Name cannot be null.", e.getMessage());
		}
	}
	@ParameterizedTest
	@NullSource
	// six numbers
	public void parameterNameIsNullException(String names) {
		IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Horse(names, 1, 2));
		Assert.assertEquals("Name cannot be null.", e.getMessage());
	}
	@Test
	public void blankNameMessage() {
		try {
			new Horse(" ", 2, 3);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Name cannot be blank.", e.getMessage());
		}
	}
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "\n", "\t",})
	// six numbers
	public void parameterNameIsBlankException(String names) {
		IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Horse(names, 1, 2));
		Assert.assertEquals("Name cannot be blank.", e.getMessage());
	}
	@Test
	public void speedIsNotNegative() {
		IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Horse("Ivan", -1, 2));
		Assert.assertEquals("Speed cannot be negative.", e.getMessage());
	}
	@Test
	public void distanceIsNotNegative() {
		IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Horse("Ivan", 1, -2));
		Assert.assertEquals("Distance cannot be negative.", e.getMessage());
	}
	@Test
	public void shouldBeString() throws NoSuchFieldException, IllegalAccessException {
		Horse horse = new Horse("Ivan", 1, 2);
		String testName = "Ivan";
		Field name = (Horse.class.getDeclaredField("name"));
		name.setAccessible(true);
		String nameGet = (String) name.get(horse);
		name.setAccessible(false);
		Assert.assertEquals(testName, nameGet);
	}
	@Test
	public void shouldBeDouble() throws NoSuchFieldException, IllegalAccessException {
		Horse horse = new Horse("Ivan", 1, 2);
		double testSpeed = 1;
		Field speed = Horse.class.getDeclaredField("speed");
		speed.setAccessible(true);
		double speedGet = (double) speed.get(horse);
		Assert.assertEquals(testSpeed,speedGet,0.0000001);
	}
	@Test
	public void shouldBeDoubleAndZero() throws NoSuchFieldException, IllegalAccessException {
		Horse horse = new Horse("Ivan", 1, 1);
		double testDistance = 1;
		Field distance = Horse.class.getDeclaredField("distance");
		distance.setAccessible(true);
		double distanceGet = (double) distance.get(horse);
		Assert.assertEquals(testDistance,distanceGet,0.0000001);

		Horse zeroHorse = new Horse("Ivan",1);
		double zero = 0;
		double distanceGetZero = (double) distance.get(zeroHorse);
		Assert.assertEquals(zero,distanceGetZero,0.0000001);

	}
}