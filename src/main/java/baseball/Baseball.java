package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Application.IS_TEST;
import static java.lang.Integer.parseInt;

public class Baseball {
    private int strike;
    private int ball;

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
            print3Strike();
            return true;

        }
        else if (strike == 0 && ball == 0) {
            printNothing();
        }
        else if (strike == 0) {
            printBall();
        }
        else if (ball == 0) {
            printStrike();
        }
         else {
            printBallAndStrike();
        }
        return false;

    }

    void print3Strike(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void printNothing(){
        System.out.println("낫싱");
    }

    void printBall() {
        System.out.println(ball+"볼");
    }

    void printStrike() {
        System.out.println(strike+"스트라이크");
    }

    void printBallAndStrike(){
        System.out.println(ball+"볼 "+strike+"스트라이크");
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

    int restartException() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s_end = Console.readLine();
        try {
            // 정수로 입력되지 않았을 때
            int end = parseInt(s_end);

            // 1과 2가 아닐 때
            if (!(end == 1 || end == 2)) {
                throw new Exception();
            }

            return end;

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

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

    /* 111, 222 같은 연속된 숫자가 입력되었는지 확인*/
    boolean checkRepeat(String num){
        for(int i = 0; i<3; i++) {
            int count = 0;
            char ch = num.charAt(i);
            for (int j = 0; j<3;j++){
                if (num.charAt(j) == ch){
                    count ++;
                }
            }
            if (count > 1){
                return true;
            }
        }
        return false;
    }

    int reGame(String com) {
        // strike, ball 초기화
        clear();
        // 입력
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        inputException(num);
        if (checkRepeat(num)){
            System.out.println("연속된 숫자가 입력되었습니다.");
            return 3;
        }
        count(num, com);

        // 3스트라이크인지 아닌지 확인
        if (check()) {
            // 이 조건이 1, 2를 입력했을 때 들어옴
            int end = restartException();
            if (end == 1) {
                return 1;
            } else if (end == 2) {
                return 2;
            }
        }
        return 3;
        // 1, 2, 3으로 리턴
        // 1: 다른 숫자로 게임 시작
        // 2: 게임 끝
        // 3: 숫자를 입력하세요
    }


    int startGame(int end) {
        String com = makeRandomNum();

        if (IS_TEST) {
            System.out.println("answer: " + com);
        }
        // 게임 시작
        // while (게임 진행되는 동안)
        int how = -1;
        while (true) {
            how = reGame(com);
            if (how == 1){
                return 1;
            }
            else if (how == 2){
                return 2;
            }
        }
    }

}

