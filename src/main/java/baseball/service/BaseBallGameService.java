package baseball.service;

import baseball.model.BaseballCount;
import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGameService {
    private BaseballCount baseballCount = new BaseballCount();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer randomNumbers = Computer.createRandomNumbers();
        List<Integer> randomNumbersList = randomNumbers.getRandomNumbers();

        while(baseballCount.getStrikeCount() < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputNumbers = readLine();
            User user = User.readInputNumbers(userInputNumbers);
            List<Integer> inputNumberList = user.getInputNumberList();
            playBaseBall(randomNumbersList, inputNumberList);
        }

    }

    public void playBaseBall(List<Integer> computerNumberList, List<Integer> UserNumberList) {
        int strike = baseballCount.countStrike(computerNumberList, UserNumberList);
        int ball = baseballCount.countBall(computerNumberList, UserNumberList);
        baseballCount.printCountResult(ball, strike);
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInputNumber = readLine();
        return restartInputNumber.equals("1");
    }


    private String readLine() {
        return Console.readLine();
    }


}
