package baseball;

import java.util.List;

/**
 * 숫자 야구 게임
 */
public class Baseball {

    private static String TEXT_BALL = "볼";
    private static String TEXT_STRIKE = "스트라이크";
    private static String TEXT_NOTHING = "낫싱";

    /**
     * 컴퓨터가 제시한 숫자
     */
    private final List<Integer> computer;
    /**
     * 유저가 제시한 숫자
     */
    private final List<Integer> user;
    private int ball = 0;
    private int strike = 0;

    /**
     * 게임에 필요한 정보를 입력받는다.
     *
     * @param computer computer가 제시한 숫자를 받는다.
     * @param user     user가 제시한 숫자를 받는다.
     */
    public Baseball(List<Integer> computer, List<Integer> user) {
        this.computer = computer;
        this.user = user;
    }

    /**
     * 게임을 진행한다.
     *
     * @return 정답: true, 오답: false
     */
    public boolean play() {
        for (int i = 0; i < 3; i++) {
            int search = computer.indexOf(user.get(i));
            if (search == i) {
                strike++;
            } else if (search != -1) {
                ball++;
            }
        }

        commentPrint(ball, strike);
        return strike == 3;
    }

    /**
     * 게임 결과를 출력한다.
     *
     * @param ball 카운트 된 ball의 수
     * @param strike 카운트 된 strike의 수
     */
    private static void commentPrint(int ball, int strike) {
        if (ball == 0 && strike == 0) { // 하나도 맞추지 못한 경우
            System.out.print(TEXT_NOTHING);
        } else if (ball > 0) { // 볼이 있는 경우
            System.out.print(ball + TEXT_BALL);
            if (strike > 0) { // 볼과 함께 맞춘 것도 있는 경우
                System.out.print(" " + strike + TEXT_STRIKE);
            }
        } else if (strike > 0) { // 볼은 없고 맞추기만 한 경우
            System.out.print(strike + TEXT_STRIKE);
        }

        System.out.println();
    }
}
