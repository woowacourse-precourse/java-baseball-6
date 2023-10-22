package baseball.game;

import java.util.List;

public class GameRule {
    private boolean endGame;

    /**
     * 게임이 끝나는지 안 끝나는지 및 로직 실행
     * @param attempt 사용자가 입력한 숫자 3개
     * @param target 컴퓨터가 생성한 숫자 3개
     * @return 게임이 끝났으면 true, 아니라면 false 반환
     */
    public boolean gameLogic(List<Integer> attempt, List<Integer> target) {
        int ball = 0;
        int strike = 0;

        // ball과 strike 계산
        for (int i = 0; i < attempt.size(); i++) {
            if (attempt.get(i).equals(target.get(i))) {
                strike++;
            } else if (target.contains(attempt.get(i))) {
                ball++;
            }
        }
        // 결과 로직 호출
        gameResult(ball, strike);

        return endGame;
    }

    /**
     * 결과 로직 및 출력 호출
     * @param ball
     * @param strike
     */
    private void gameResult(int ball, int strike) {
        // 3 strike 라면
        if (strike == 3) {
            printAllStrike();
            endGame = true;
            return;
        }

        endGame = false;

        // 아무것도 맞히지 못했을 경우
        if (ball == 0 && strike == 0) {
            printNothing();
            return;
        }

        // 그 외의 결과
        printProceeding(ball, strike);
    }

    /**
     * 3 스트라이크 출력
     */
    private void printAllStrike() {
        System.out.println("3스트라이크");
    }

    /**
     * 낫싱 출력
     */
    private void printNothing() {
        System.out.println("낫싱");
    }

    /**
     * ?볼 ?스트라이크 출력
     */
    private void printProceeding(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }
}
