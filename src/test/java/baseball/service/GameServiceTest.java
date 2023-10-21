package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import baseball.dto.GameResult;

class GameServiceTest {
	private final GameService gameService;

	public GameServiceTest() {
		gameService = new GameService();
	}

	void setTargetNumber() {
		try {
			Field targetNumberField = GameService.class.getDeclaredField("targetNumber");
			targetNumberField.setAccessible(true);
			targetNumberField.set(gameService, "123");
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	GameResult getResult(String input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = gameService.getClass().getDeclaredMethod("getResult", String.class);
		method.setAccessible(true);
		return (GameResult)method.invoke(gameService, input);
	}

	@Test
	void 결과값_0_0테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		setTargetNumber();
		GameResult result = getResult("456");
		assertEquals(0, result.ballCount());
		assertEquals(0, result.strikeCount());
	}

	@Test
	void 결과값_0_1테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		setTargetNumber();
		GameResult result = getResult("156");
		assertEquals(0, result.ballCount());
		assertEquals(1, result.strikeCount());
	}

	@Test
	void 결과값_1_0테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		setTargetNumber();
		GameResult result = getResult("451");
		assertEquals(1, result.ballCount());
		assertEquals(0, result.strikeCount());
	}

	@Test
	void 결과값_1_1테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		setTargetNumber();
		GameResult result = getResult("134");
		assertEquals(1, result.ballCount());
		assertEquals(1, result.strikeCount());
	}

	@Test
	void 결과값_정답테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		setTargetNumber();
		GameResult result = getResult("123");
		assertEquals(0, result.ballCount());
		assertEquals(3, result.strikeCount());
	}
}
