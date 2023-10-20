/*
 * 잘못된 값이 입력되었을 때
 *
 * 0을 입력해도 종료하나? 일단 예외로 하고 종료시킴. 테스트 해볼 때 0을 어떻게 처리할지 체크하기
 * */

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

class Baseball {
    private int strike;
    private int ball;
//    private boolean isFinish = false;

    /* 새로운 입력이 반복 될 때마다 strike와 ball을 초기화 하는 함수*/
    void clear() {
        strike = 0;
        ball = 0;
    }

    /* strike와 ball을 count 하는 함수 */
    void count(String com, String gamer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamer.charAt(i) == com.charAt(j)) {
                    if (i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }

    }

    /* strike, ball 결과 따라 결과를 출력하고 또 실행 할 건지 T/F를 리턴하는 함수 */
    boolean check() {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");

        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;

    }

    void inputException(String num) {
        try {
            //0이 들어올 경우
            if (num.contains("0")) {
                throw new Exception();
            }
            // 3자리 수가 아닌 경우
            if (num.length() != 3) {
                throw new Exception();
            }

            // 숫자가 아닌 경우
            int canInt = parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");

        }
    }


}


public class Application {

    private static final boolean IS_TEST = true;        // 정답 출력 여부 설정, 제출 시에는 false
    static int end = 1;


    public static String makeRandomNum() {
        String com = "";
        // to method
        while (com.length() < 3) {
            int r = Randoms.pickNumberInRange(1, 9);
            String sr = Integer.toString(r);
            if (!com.contains(sr)) {     //리스트에 포함되지 않는다면 추가하고 실행
                com = com + sr;
            }
        }
        return com;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isFinish = false;
        // 게임 진행
        while (end == 1) {

            // 한 게임당 초기화
            String com = makeRandomNum();
            isFinish = false;
            Baseball b = new Baseball();

            if (IS_TEST) {
                System.out.println("answer: " + com);
            }
            // 게임 시작
            // while (게임 진행되는 동안)
            while (!isFinish) {
                b.clear();
                // 입력
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();
                b.inputException(num);

                b.count(num, com);

                // 종료할 지 말지
                boolean ischeck = b.check();

                if (ischeck) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String s_end = Console.readLine();
                    // TODO: 잘못된 값 입력됬는지 확인!
                    try {
                        // 정수로 입력되지 않았을 때
                        end = parseInt(s_end);

                        // 1과 2가 아닐 때
                        if (!(end == 1 || end == 2)) {
                            throw new Exception();
                        }

                    } catch (Exception e) {
                        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                    }

                    isFinish = true;
                    // 계속
                }

            }

        }

    }
}
