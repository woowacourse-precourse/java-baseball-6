package baseball;

import baseball.computer.NumberBaseballGameComputerPlayer;
import baseball.numbergenerator.NumberGenerator;
import baseball.user.UserIo;

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

        GuessedNumbers guessedNumbers = createGuessedNumbers();
    }

    private GuessedNumbers createGuessedNumbers() {
        userIo.print("숫자를 입력해주세요 : ");
        return new GuessedNumbers(userIo.readNumbers(), gameRules);
    }
}
