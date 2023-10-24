package baseball;

import baseball.util.ComputerUtil;
import baseball.util.MessageUtil;
import baseball.util.UserUtil;
import baseball.validation.InputValidation;
import java.util.List;

import static baseball.constant.NumberConst.*;

public class BaseballGame {

    private final UserUtil userUtil = new UserUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final InputValidation validator = new InputValidation();

    private final ComputerUtil computerUtil = new ComputerUtil();

    private List<Integer> computerNumbers;

    /**
     * 생성자 호출 시 게임 시작 전 메시지 출력
     */
    public BaseballGame() {
        messageUtil.printInitMessage();
    }

    /**
     * 게임 시작 메서드
     */
    public void start(){

        int gameControlNumber = RESTART_NUMBER;
        computerNumbers = computerUtil.generateRandomNumber();

        while (gameControlNumber == RESTART_NUMBER) {

            messageUtil.printInputMessage();
            String userInput = userUtil.getInputNumbers();
            List<Integer> userNums = validator.validateInputNum(userInput);
            ResultCount result = compareNumber(computerNumbers, userNums);
            int strike = result.strikeCount;
            int ball = result.ballCount;
            messageUtil.printResultMessage(strike, ball);
            gameControlNumber = checkStrikeCount(strike);
        }
    }

    /**
     * 컴퓨터의 랜덤 숫자들과 사용자가 입력한 숫자들과 비교연산
     */
    private ResultCount compareNumber(List<Integer> computerNums, List<Integer> userNums) {

        int ball = 0, strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }

            if (computerNums.contains(userNum)) {
                ball++;
            }
        }

        return new ResultCount(strike, ball);
    }

    /**
     * 스트라이크, 볼 개수 연산
     */
    private static class ResultCount {

        int strikeCount;
        int ballCount;

        public ResultCount(int strikeCount, int ballCount) {
            this.strikeCount = strikeCount;
            this.ballCount = ballCount;
        }
    }

    /**
     * 스트라이크 개수 체크
     */
    private int checkStrikeCount(int strike) {
        int gameControlInput = RESTART_NUMBER;

        if (strike == MAX_STRIKE) {
            messageUtil.printSuccessMessage();
            gameControlInput = Integer.parseInt(userUtil.getInputNumbers());
            validator.validateGameControlInput(gameControlInput);
            checkRestartNumAndMakeComputerNum(gameControlInput);
        }

        return gameControlInput;
    }

    /**
     * 컴퓨터 랜덤 숫자 생성
     */
    private void checkRestartNumAndMakeComputerNum(int gameControlInput) {
        if (gameControlInput == RESTART_NUMBER) {
            computerNumbers = computerUtil.generateRandomNumber();
        }
    }
}
