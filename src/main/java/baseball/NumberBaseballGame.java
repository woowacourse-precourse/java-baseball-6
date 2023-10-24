package baseball;

import baseball.io.UserIo;
import baseball.numbergenerator.NumberGenerator;
import baseball.numbers.GuessedNumbers;
import baseball.numbers.NumberBaseballGameComputerPlayer;

public class NumberBaseballGame {

    private final BaseballGameRules gameRules;
    private final NumberGenerator numberGenerator;
    private final UserIo userIo;

    public NumberBaseballGame(BaseballGameRules gameRules, NumberGenerator numberGenerator, UserIo userIo) {
        this.gameRules = gameRules;
        this.numberGenerator = numberGenerator;
        this.userIo = userIo;
    }

    public void run() {
        NumberBaseballGameComputerPlayer computerPlayer =
                new NumberBaseballGameComputerPlayer(numberGenerator.generateUniqueNumbers(), gameRules);
        boolean isGameRunning = true;

        while (isGameRunning) {
            NumberBaseballGameResult result = playInning(computerPlayer);

            userIo.print(result.toString() + "\n");
            if (result.isAllStrike()) {
                isGameRunning = false;
            }
        }

        userIo.print(computerPlayer.getNumbersSize() + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private NumberBaseballGameResult playInning(NumberBaseballGameComputerPlayer computerPlayer) {
        GuessedNumbers guessedNumbers = createGuessedNumbers();
        return computerPlayer.compareWith(guessedNumbers);
    }

    private GuessedNumbers createGuessedNumbers() {
        userIo.print("숫자를 입력해주세요 : ");
        return new GuessedNumbers(userIo.readNumbers(), gameRules);
    }
}
