package baseball.ProcessGame;

import static baseball.Message.BaseBallGameMsg.BALL;
import static baseball.Message.BaseBallGameMsg.NOTHING;
import static baseball.Message.BaseBallGameMsg.PROMPT_PLAY_GAME;
import static baseball.Message.BaseBallGameMsg.STRIKE;
import static baseball.Message.BaseBallGameMsg.THREE_STRIKE;

import baseball.Config.DiContainer;
import baseball.EndGame.EndProcess;
import baseball.Input.InputAnswer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BaseBallGameImpl implements BaseBallGame {

    private static final InputAnswer inputAnswer = DiContainer.getInputAnswer();
    private static final EndProcess endProcess = DiContainer.getEndProcess();
    private List<Integer> computerNumber;

    private static BaseBallGameImpl singleton;

    private BaseBallGameImpl() {
    }

    public static BaseBallGameImpl getInstance() {
        if (singleton == null) {
            singleton = new BaseBallGameImpl();
        }
        return singleton;
    }

    @Override
    public void initGame() {
        computerNumber = makeRandomNumber();
        playGame();
    }

    @Override
    public void playGame() {
        Boolean keepGoing = true;
        while (keepGoing) {
            System.out.print(PROMPT_PLAY_GAME.getMsg());
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
            System.out.println(NOTHING.getMsg());
        } else if (strike == 3) {
            System.out.println("3" + STRIKE.getMsg());
            System.out.println(THREE_STRIKE.getMsg());
            return Boolean.FALSE;
        } else {
            if (ball > 0) {
                System.out.print(ball + BALL.getMsg());
            }
            if (strike > 0) {
                System.out.print(strike + STRIKE.getMsg());
            }
            System.out.println();
        }
        return Boolean.TRUE;
    }
}
