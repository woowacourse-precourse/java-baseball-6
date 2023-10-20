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
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> userAnswer = inputAnswer.inputAnswer();
        Integer strike = countStrike(userAnswer);
        Integer ball = countBall(userAnswer);
        gameResult(strike, ball);
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
            if (computerNumber.get(i).equals(userAnswer.get(i)))
                cnt++;
        }
        return cnt;
    }

    @Override
    public Integer countBall(List<Integer> userAnswer) {
        Integer cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userAnswer.get(i)) && !computerNumber.get(i).equals(userAnswer.get(i)))
                cnt++;
        }
        return cnt;
    }


    @Override
    public void gameResult(Integer strike, Integer ball) {
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            //TODO : 재시작 혹은 게임 종료
        } else{
            if (ball > 0) System.out.print(ball + "볼" + " ");
            if (strike > 0) System.out.println(strike + "스트라이크");
        }
        playGame();

    }
}
