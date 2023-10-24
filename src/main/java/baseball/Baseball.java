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


    /*
     * 한 숫자가 만들어 지고 맞출 때 까지 계속 입력을 받는 메소드
     * 한 숫자에 대한 게임이 끝나면 종료가 된다.
     * 1 리턴: main에서 1임을 확인하고 새로운 랜덤한 수로 게임 진행
     * 2 리턴: main에서 2임을 확인하고 종료
     * */
    int startGame() {
        /* 컴퓨터가 생성한 랜덤한 수 */
        String com = makeRandomNum();

        // 테스트를 위한 코드
        if (IS_TEST) {
            System.out.println("answer: " + com);
        }

        int how = -1;
        // 게임 시작
        while (true) {
            how = repeatInput(com);
            if (how == 1 || how == 2) {
                return how;
            }
        }
    }

    /*
     * 숫자를 입력할 때마다 1. strike, ball 초기화
     *                   2. 입력 받음
     *                   3. 예외 처리
     *                   4. strike, ball 계산
     *                   5. 게임을 새로 시작할지 종료할지
     *
     * @param com 컴퓨터가 생성한 퀴즈 정답
     * @return 1: (3스트라이크)게임을 새로 시작합니다, 2: (3스트라이크)게임을 종료합니다
     *         3: 게임 계속 진행*/
    int repeatInput(String com) {
        // strike, ball 초기화
        clear();
        // 입력
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();

        // 입력 예외 처리
        inputException(num);
        // 연속된 숫자는 다시 입력하도록
        if (checkRepeat(num)) {
            System.out.println("연속된 숫자가 입력되었습니다.");
            return 3;
        }

        // strike, ball 계산
        countStrikeAndBall(num, com);

        // 3스트라이크인지 아닌지 확인
        if (checkResult()) {
            // 3 스트라이크라면 이 조건문에 들어와서 1, 2 선택하게 됨
            int end = restartException();
            // 게임을 새로 시작하거나 종료하게 된다면 리턴
            if (end == 1 || end == 2) {
                return end;
            }
        }
        // 3스트라이크가 아니라면 게임 계속 진행
        return 3;

        // 1, 2, 3으로 리턴
        // 1: 다른 숫자로 게임 시작
        // 2: 게임 끝
        // 3: 숫자를 입력하세요
    }


    /*
     * 1-9까지 서로 다른 수로 이루어진 3자리의 수 생성
     */
    public static String makeRandomNum() {
        String com = "";
        // to method
        while (com.length() < 3) {
            int r = Randoms.pickNumberInRange(1, 9);
            String sr = Integer.toString(r);
            if (!com.contains(sr)) {     // 문자열에 sr이 없다면 추가
                com = com + sr;
            }
        }
        return com;
    }


    /* strike와 ball을 count 하는 함수
     * */
    void countStrikeAndBall(String com, String gamer) {
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

    /*
     * strike, ball 결과 따라 결과를 출력하는 메소드
     * 3스트라이크일 때는 true가 리턴되어 새로 시작할지 종료할지 묻도록 함*/
    boolean checkResult() {
        if (strike == 3) {
            print3Strike();
            return true;

        } else if (strike == 0 && ball == 0) {
            printNothing();
        } else if (strike == 0) {
            printBall();
        } else if (ball == 0) {
            printStrike();
        } else {
            printBallAndStrike();
        }
        return false;
    }


    /*
     * 입력에 대한 IllegalArgumentException 예외 처리 진행
     * 1. 0이 들어 올 경우
     * 2. 3자리 수가 아닌 경우
     * 3. 숫자가 아닌 경우(공백도 포함)
     * */
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
            // parseInt Throws: NumberFormatException - if the string does not contain a parsable integer.
            // https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#parseInt(java.lang.String)
            parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }


    /*
     * 1과 2를 입력받아 예외 처리 진행, 예외가 발생하지 않는다면 입력받은 값 리턴
     * */
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


    /*
     * 111, 222 같은 연속된 숫자가 입력되었는지 확인
     * 연속된 숫자라면 true, 연속된 숫자가 아니라면 false
     * */
    boolean checkRepeat(String num) {
        for (int i = 0; i < 3; i++) {
            int count = 0;
            char ch = num.charAt(i);
            for (int j = 0; j < 3; j++) {
                if (num.charAt(j) == ch) {
                    count++;
                }
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }


    void print3Strike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void printNothing() {
        System.out.println("낫싱");
    }

    void printBall() {
        System.out.println(ball + "볼");
    }

    void printStrike() {
        System.out.println(strike + "스트라이크");
    }

    void printBallAndStrike() {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}

