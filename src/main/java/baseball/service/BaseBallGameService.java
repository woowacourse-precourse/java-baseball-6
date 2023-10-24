package baseball.service;

import baseball.model.BallStrike;
import baseball.model.BaseballCount;
import baseball.model.Computer;
import baseball.model.User;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGameService {

    BaseballCount baseballCount = new BaseballCount();

    public void start() {
        BallStrike ballStrike = new BallStrike();

        Computer randomNumbers = Computer.createRandomNumbers();
        List<Integer> randomNumbersList = randomNumbers.getRandomNumbers();
        Validator.validateListSize(randomNumbersList);
        Validator.validateDuplicateList(randomNumbersList);


        while(ballStrike.getStrikeCount() < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputNumbers = readLine();
            Validator.validateInput(userInputNumbers);
            Validator.validateInputDuplication(userInputNumbers);
            User user = User.readInputNumbers(userInputNumbers);
            List<Integer> inputNumberList = user.getInputNumberList();
            playBaseBall(randomNumbersList, inputNumberList, ballStrike);
            printResult(ballStrike);
        }

    }

    public void playBaseBall(List<Integer> computerNumberList, List<Integer> UserNumberList, BallStrike ballStrike) {
        int strike = baseballCount.countStrike(computerNumberList, UserNumberList);
        int ball = baseballCount.countBall(computerNumberList, UserNumberList);
        ballStrike.setBallStrike(ball, strike);
    }

    public void printResult(BallStrike ballStrike) {
        baseballCount.printCountResult(ballStrike.getBallCount(), ballStrike.getStrikeCount());
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInputNumber = readLine();
        Validator.validateRestartInput(restartInputNumber);
        if(restartInputNumber.equals("1")) {
            return true;
        }
        return false;
    }


    private String readLine() {
        return Console.readLine();
    }

}
