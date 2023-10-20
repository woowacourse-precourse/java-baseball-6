package baseball.ProcessGame;

import baseball.EndGame.EndProcess;
import baseball.EndGame.EndProcessImpl;
import baseball.Input.InputAnswer;
import baseball.Input.InputAnswerImpl;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BaseBallGameImpl implements BaseBallGame {

    private static final InputAnswer inputAnswer = new InputAnswerImpl();
    private static final EndProcess endProcess = new EndProcessImpl();
    private List<Integer> computerNumber;

    @Override
    public void initGame() {
        computerNumber = makeRandomNumber();
        playGame();
    }

    @Override
    public void playGame() {
        Boolean keepGoing = true;
        while (keepGoing) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userAnswer = inputAnswer.inputAnswer();
            Integer strike = countStrike(userAnswer);
            Integer ball = countBall(userAnswer);
            keepGoing = gameResult(strike, ball);
        }
        endProcess.userChoice();
    }

    @Override
    public List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public Integer countStrike(List<Integer> userAnswer) {
        Integer cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userAnswer.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public Integer countBall(List<Integer> userAnswer) {
        Integer cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userAnswer.get(i)) && !computerNumber.get(i).equals(userAnswer.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }


    @Override
    public Boolean gameResult(Integer strike, Integer ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return Boolean.FALSE;
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼" + " ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
        return Boolean.TRUE;
    }
}
