import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;


public class HippodromeTest {
	@Test
	public void nullNameException() {
		IllegalArgumentException illegalArgumentExceptionNull = Assert.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
		Assert.assertEquals("Horses cannot be null.",illegalArgumentExceptionNull.getMessage());
		IllegalArgumentException illegalArgumentExceptionEmpty = Assert.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
		Assert.assertEquals("Horses cannot be empty.",illegalArgumentExceptionEmpty.getMessage());
	}

	@Test
	public void shouldBeSubsequence() {
		List<Horse> horses = new ArrayList<>(30);
		Horse winner = new Horse("horse",0,0);
		for (int i = 0; i < 30; i++) {
			Horse horse = new Horse("horse " + i,Math.random()*10 +i,  Math.random()*100+ i);
			horses.add(horse);
			Double distance = horse.getDistance();
			if (distance > winner.getDistance()) {
				winner = horse;
			}
		}
		Hippodrome hippodrome = new Hippodrome(horses);
		Assert.assertEquals(horses,hippodrome.getHorses());
		Assert.assertEquals(winner,hippodrome.getWinner());
	}

}
