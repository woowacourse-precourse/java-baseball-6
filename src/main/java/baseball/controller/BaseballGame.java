package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.CountScore;
import baseball.model.PlayerNumber;
import baseball.util.Validator;

import java.util.List;

public class BaseballGame {
    private final PlayerNumber playerPart = new PlayerNumber();
    private final ComputerNumber computerPart = new ComputerNumber();
    private final CountScore messagePart = new CountScore();
    private final Validator validator = new Validator();
    private List<Integer> computerNums;

//시작 메시지 출력
    public BaseballGame() {
        messagePart.printStart();
    }

// 3자리 수 생성
    public void startGame() {
        int gameControlNum = 1;
        computerNums = computerPart.generateNumber();

        while (gameControlNum == 1) {
            messagePart.printInput();
            String userInput = playerPart.getPlayerInput();
            List<Integer> userNumbers = validator.validateInputNum(userInput);

            ResultCount result = compareNumber(computerNums, userNumbers);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            messagePart.printResult(ball, strike);

            gameControlNum = checkStrikeCount(strike);
        }
    }

    private ResultCount compareNumber(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
                continue;
            }
            if (computerNums.contains(userNumber)) {
                ball++;
            }
        }
        return new ResultCount(ball, strike);
    }

    private static class ResultCount {
        int ballCount, strikeCount;

        public ResultCount(int ballCount, int strikeCount) {  // 볼과 스트라이크 개수 정의
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    private int checkStrikeCount(int strike) {
        int restartInput = 1;

        if (strike == 3) {
            messagePart.printSuccess(); //성공 메시지 출력
            restartInput = Integer.parseInt(playerPart.getPlayerInput());
            validator.restartValidation(restartInput);

            checkRestartNumber(restartInput);
        }
        return restartInput;
    }

    private void checkRestartNumber(int gameControlInput) {
        if (gameControlInput == 1) {
            computerNums = computerPart.generateNumber(); //3자리 숫자 다시 만들기
        }
    }
}
