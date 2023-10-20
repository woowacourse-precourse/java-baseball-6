package baseball.util;

import java.util.List;

/**
 * 숫자 야구 게임
 */
public class Baseball {
    /**
     * 컴퓨터가 제시한 숫자
     */
    private final List<Integer> computer;
    /**
     * 유저가 제시한 숫자
     */
    private final List<Integer> user;
    private int bool = 0;
    private int strike = 3;

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
     * @return
     */
    public boolean play() {
        commentPrint(bool, strike);
        return strike == 3 ? true : false;
    }

    /**
     * 게임 결과를 출력한다.
     *
     * @param bool
     * @param strike
     */
    private static void commentPrint(int bool, int strike) {
        if (bool == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (bool > 0) {
            System.out.print(bool + "볼");
        }
        if (bool > 0 && strike > 0) {
            System.out.print(" " + strike + "스트라이크");
        }
        if (bool == 0 && strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println("");
    }
}
