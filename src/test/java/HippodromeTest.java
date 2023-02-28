import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;
public class HippodromeTest {
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
	@ValueSource(strings = {"\t", "", " ", "\n"})
		// six numbers
	void parameterNameIsNullException(String names) {
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
	void parameterNameIsBlankException(String names) {
		IllegalArgumentException e = Assert.assertThrows(IllegalArgumentException.class, () -> new Horse(names, 1, 2));
		Assert.assertEquals("Name cannot be blank.", e.getMessage());
	}
}