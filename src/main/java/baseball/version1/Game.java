package baseball.version1;

import static baseball.version1.Constants.BALL_NUMBER;
import static baseball.version1.Constants.CONTINUE_NUMBER;
import static baseball.version1.Constants.STRIKE_NUMBER;
import static baseball.version1.Constants.THREE_STRIKE;

import java.util.ArrayList;

public class Game {

    private final Player player;
    private final Computer computer;
    private Score score;
    private final GameProcessor gameProcessor;


    public Game() {
        this.player = new Player();
        this.computer = new Computer();
        this.gameProcessor = new GameProcessor();
    }

    public void run() {
        int continueDecision = CONTINUE_NUMBER;
        while (continueDecision == CONTINUE_NUMBER) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            ArrayList<Integer> computerAnswer = settingNewGame();
            start(computerAnswer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueDecision = player.getContinueDecision();
        }
    }

    private ArrayList<Integer> settingNewGame() {
        return computer.getComputerAnswer();
    }

    void start(ArrayList<Integer> computerAnswer) {
        score = new Score();
        while (score.getStrike() != THREE_STRIKE) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> playerAnswer = player.getPlayerAnswer();
            int[] result = gameProcessor.getCompareTwoAnswerResult(playerAnswer, computerAnswer);
            score.setBall(result[BALL_NUMBER]);
            score.setStrike(result[STRIKE_NUMBER]);
            gameProcessor.printScore(score);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
