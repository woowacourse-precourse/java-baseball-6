package baseball.service;

import baseball.domain.Game;
import baseball.factory.GameFactory;
import baseball.util.generator.RandomNumberGenerator;
import baseball.util.matcher.NumbersMatcher;
import baseball.util.validator.InputValidator;

import java.util.List;

public class GameServiceImpl implements GameService {
    public GameServiceImpl(
            RandomNumberGenerator randomNumberGenerator,
            NumbersMatcher numbersMatcher,
            InputValidator inputValidator,
            GameFactory gameFactory
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.numbersMatcher = numbersMatcher;
        this.inputValidator = inputValidator;
        this.gameFactory = gameFactory;
    }

    private final RandomNumberGenerator randomNumberGenerator;
    private final NumbersMatcher numbersMatcher;
    private final InputValidator inputValidator;
    private final GameFactory gameFactory;

    private final int GAME_NUMBER_DIGITS = 3;
    private final int GAME_MIN_NUMBER = 1;
    private final int GAME_MAX_NUMBER = 9;

    private final int MENU_NUMBER_DIGITS = 1;
    private final int MENU_MIN_NUMBER = 1;
    private final int MENU_MAX_NUMBER = 2;

    @Override
    public Game getGame() {
        return gameFactory.getGameInstance();
    }

    @Override
    public void init(Game game) {
        game.setTargetNumberList(
                randomNumberGenerator.pickUniqueRandomNumber(GAME_NUMBER_DIGITS, GAME_MIN_NUMBER, GAME_MAX_NUMBER)
        );
    }

    @Override
    public void inputMenuValidate(String input) {
        if ( !inputValidator.validate(input, MENU_NUMBER_DIGITS, MENU_MIN_NUMBER, MENU_MAX_NUMBER) )
            throw new IllegalArgumentException("유효한 메뉴 번호가 아닙니다. 애플리케이션을 종료합니다.");
    }

    @Override
    public void playerNumbersValidate(String input) {
        if ( !inputValidator.validate(input, GAME_NUMBER_DIGITS, GAME_MIN_NUMBER, GAME_MAX_NUMBER, true) )
            throw new IllegalArgumentException("유효한 예상 숫자가 아닙니다. 애플리케이션을 종료합니다.");
    }

    @Override
    public String numbersMatch(List<Integer> targetNumbers, String inputNumbers) {
        return numbersMatcher.matches(targetNumbers, inputNumbers);
    }
}
