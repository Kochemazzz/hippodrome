import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

public class MainTest {



	@Test
	@Timeout(22)
	public void shouldBeNormalTimeOut() throws Exception {
		Main.main(null);
		System.out.println("MAIN TEST DONE");
	}
}
