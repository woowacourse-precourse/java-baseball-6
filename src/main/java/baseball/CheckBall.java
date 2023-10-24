package baseball;

import java.util.List;
public class CheckBall {

    private static final boolean CONTINUE = true;
    private static final boolean STOP = false;

    /**
     * 숫자 야구 결과를 평가하고 출력합니다.
     *
     * @param resultBall 사용자가 입력한 숫자 리스트
     * @param rightBall 컴퓨터가 생성한 숫자 리스트
     * @return 게임을 계속할지 여부 (CONTINUE: 계속, STOP: 졸료)
     */

    protected static boolean giveBallResult(List<Integer> resultBall, List<Integer> rightBall){

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < rightBall.size(); i++) {
            if (rightBall.get(i).equals(resultBall.get(i))) {
                strike++;
            }
            if (rightBall.contains(resultBall.get(i))) {
                ball++;
            }
        }

        ball -= strike;

        if (strike == 3) {
            System.out.println("3스트라이크");
            return STOP;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return CONTINUE;
        }

        if (ball != 0) {
            System.out.format("%d볼 ", ball);
        }

        if (strike != 0) {
            System.out.format("%d스트라이크", strike);
        }

        System.out.println();
        return CONTINUE;
    }
}
