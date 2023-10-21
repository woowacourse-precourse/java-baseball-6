package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.transform.stream.StreamSource;
import java.util.List;

public class BaseBallGame {

    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    public static final int OUT_INDEX = 2;

    private static final String GAME_START_MESSAGE = "숫자야구 게임을 시작합니다";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTING_MESSAGE = "낫싱";
    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";
    private static final String END_MESSAGE = "게임 종료";

    private static boolean isGameOver = false;

    private Player player1;
    private Player player2;

    private BaseBallGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        startGame();
    }

    public static BaseBallGame getNewGame(Player player1, Player player2) {
        System.out.println(GAME_START_MESSAGE);
        return new BaseBallGame(player1, player2);
    }

    private void startGame() {

        while (true) {
            System.out.println(INPUT_NUMBER_MESSAGE);
            List<Integer> answer1 = player1.createHumansNumberList();
//            List<Integer> answer2 = player2.createAnswer();

//            player1.compareAnswers(answer2);
            printResult(player2.compareAnswers(answer1));

            if (isGameOver) {
                System.out.println(END_MESSAGE);
                break;
            }

        }
    }

    private void printResult(List<Integer> resultList) {
        if (resultList.get(OUT_INDEX) == 3) {
            System.out.println(NOTING_MESSAGE);
            return;
        }
        if (resultList.get(STRIKE_INDEX) == 3) {
            System.out.println("3스트라이크");
            System.out.println(ALL_STRIKE_MESSAGE);
            isGameOver = true;
            return;
        }
        System.out.println(getResultMessage(resultList));
    }

    private String getResultMessage(List<Integer> resultList){
        StringBuilder sb = new StringBuilder();
        int strike = resultList.get(STRIKE_INDEX);
        int ball = resultList.get(BALL_INDEX);
        sb.append(ball==0?"":ball+"볼 ");
        sb.append(strike==0?"":strike+"스트라이크");
        return sb.toString();
    }


    @Override
    public String toString() {
        return
                player1.playerType.name() + ": " + player1 + "\n" +
                        player2.playerType.name() + ": " + player2
                ;
    }
}
