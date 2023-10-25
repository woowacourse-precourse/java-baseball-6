package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ballTest {

	@Test
	public void smaller_ball() {
		assertThrows(IllegalArgumentException.class, () -> new ball(-1));
	}

	@Test
	public void larger_ball() {
		assertThrows(IllegalArgumentException.class, () -> new ball(10));
	}

	@Test
	public void nomal_ball() {
		assertDoesNotThrow(() -> new ball(1));
		assertDoesNotThrow(() -> new ball(2));
		assertDoesNotThrow(() -> new ball(3));
		assertDoesNotThrow(() -> new ball(4));
		assertDoesNotThrow(() -> new ball(5));
		assertDoesNotThrow(() -> new ball(6));
		assertDoesNotThrow(() -> new ball(7));
		assertDoesNotThrow(() -> new ball(8));
		assertDoesNotThrow(() -> new ball(9));
	}
}
