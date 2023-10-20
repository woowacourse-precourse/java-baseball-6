package baseball.Game;

import baseball.Input.InputAnswer;
import baseball.Input.InputAnswerImpl;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameImpl implements BaseBallGame {

    private static InputAnswer inputAnswer = new InputAnswerImpl();
    private List<Integer> computerNumber;

    @Override
    public void initGame() {
        computerNumber = makeRandomNumber();
        playGame();
    }

    @Override
    public void playGame() {
        while (true){
            List<Integer> userAnswer = inputAnswer.inputAnswer();
            Integer strike = countStrike(userAnswer);
            Integer ball = countBall(userAnswer);
            if (strike == 0 && ball ==0)
                System.out.println("낫싱");
            else if (strike == 3) {
                //TODO : 재시작 혹은 게임 종료
                break;
            } else
                printResult(strike, ball);
        }
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
    public Integer countStrike(List<Integer> answer) {
        return null;
    }

    @Override
    public Integer countBall(List<Integer> answer) {
        return null;
    }


    @Override
    public void printResult(Integer strike, Integer ball) {

    }
}
