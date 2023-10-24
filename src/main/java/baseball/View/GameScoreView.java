package baseball.View;

import java.util.List;

public class GameScoreView {
    private static final String OUTPUT_COMPLETE_THREE_STRIKE_SCORE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OUTPUT_NEXT_GAME_SETUP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int STRIKE_COUNT_INDEX = 0;
    private static final int BALL_COUNT_INDEX = 1;

    public void completeThreeStrikeScore() { //3스트라이크 완성
        System.out.println("3스트라이크");
        System.out.println(OUTPUT_COMPLETE_THREE_STRIKE_SCORE);
        System.out.println(OUTPUT_NEXT_GAME_SETUP);
    }

    public void incompleteThreeStrikeScore(List<Integer> incompleteThreeStrikeScore) { //3스트라이크 미완성
        int countStrike = incompleteThreeStrikeScore.get(STRIKE_COUNT_INDEX);
        int countBall = incompleteThreeStrikeScore.get(BALL_COUNT_INDEX);

        if (countStrike == 0 && countBall == 0) {
            System.out.println("낫싱");
        }
        if (countStrike != 0 && countBall == 0) {
            System.out.println(countStrike + "스트라이크");
        }
        if (countStrike == 0 && countBall != 0) {
            System.out.println(countBall + "볼");
        }
        if (countStrike != 0 && countBall != 0) {
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        }
    }
}
