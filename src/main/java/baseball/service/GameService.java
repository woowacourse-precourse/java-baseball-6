package baseball.service;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final int NUMBER_DIGIT = 3;
    private static final String nothing = "낫싱";
    private static final String ballMessage = "볼";
    private static final String strikeMessage = "스트라이크";
    private static final String threeStrikeMessage = "3스트라이크";
    private static final String gameEndMessage = "2";
    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();
    private ComputerNumber computerNumber = new ComputerNumber();
    private PlayerNumber playerNumber = new PlayerNumber();


    public boolean playGame() {
        boolean stopFlag = false;
        output.gameStart();
        computerNumber.setNumber(createRandomNumbers());
        while (!stopFlag) {
            if (guessComputerNumbers()) {
                stopFlag = true;
            }
        }
        return true;
    }

    private boolean guessComputerNumbers() {
        String playerInput = input.getPlayerNumber();
        playerNumber.setNumber(validator.proceedValidation(playerInput));
        String hint = createHint();
        output.printHint(hint);
        if (hint.equals(threeStrikeMessage)) {
            output.gameEnd();
            String restartOrEnd = input.getRestartOrEnd();
            if (restartOrEnd.equals(gameEndMessage)) {
                return true;
            }
            output.gameStart();
            computerNumber.setNumber(createRandomNumbers());
            return false;
        }
        return false;
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // hint 체크
    public String createHint() {
        List<Integer> computerNumbers = computerNumber.getNumber();
        List<Integer> playerNumbers = playerNumber.getNumber();
        int countStrike = countStrike(computerNumbers, playerNumbers);
        int countBall = countBall(computerNumbers, playerNumbers);
        String result = "";
        if (countBall != 0) {
            result += countBall;
            result += ballMessage + " ";
        }
        if (countStrike != 0) {
            result += countStrike;
            result += strikeMessage;
        }
        if (result.isBlank()) {
            return nothing;
        }
        return result;
    }

    private int countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            Integer nowPlayerNumber = playerNumbers.get(i);
            for (int j = 0; j < NUMBER_DIGIT; j++) {
                if (i == j)
                    continue;
                Integer nowComputerNumber = computerNumbers.get(j);
                if (nowPlayerNumber.equals(nowComputerNumber)) {
                    count++;
                }
            }
        }
        return count;
    }
}
