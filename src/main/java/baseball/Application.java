package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int strike, ball;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        // 정답 숫자 랜덤으로 생성하기
        makeRandomNum(computer);

        while (true) {
            // 숫자 입력받기
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = Console.readLine();
            validateInput(inputStr);

            // 스트라이크와 볼의 갯수 확인하기
            strike = getStrike(computer, inputStr);
            ball = getBall(computer, inputStr);

            // 힌트 출력하기
            boolean isCorrected = printHint(strike, ball);
            if (!isCorrected) {
                continue;
            }

            // 게임 재시작 여부 선택하기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            validRestartInput(restart);

            int restartInt = Integer.parseInt(restart);
            if (restartInt == 1) {  // 게임 재시작
                makeRandomNum(computer);
            } else {  // 게임 종료
                break;
            }
        }
    }

    /**
     * 입력한 문자열이 유효한지(1 또는 2) 판단하고,
     * 잘못된 값 입력 시 `IllegalArgumentException` 발생시킨다.
     *
     * @param input 게임 재시작 여부에 대해 입력받은 문자열
     */
    private static void validRestartInput(String input) {
        if (!(input.length() == 1 && (input.charAt(0) == '1' || input.charAt(0) == '2'))) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    /**
     * 주어진 스트라이크의 갯수와 볼의 갯수로 힌트를 출력하고,
     * 성공 여부를 true 혹은 false 로 반환한다.
     *
     * @param strike 스트라이크의 갯수
     * @param ball   볼의 갯수
     * @return 정답을 맞췄으면 true, 아니면 false
     */
    private static boolean printHint(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if ((ball != 0) && (strike != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {   // ball != 0 && strike == 0
            System.out.println(ball + "볼 ");
        } else if (strike != 0) {  // ball == 0 strike != 0
            System.out.println(strike + "스트라이크");
        } else {    // ball == 0 strike == 0
            System.out.println("낫싱");
        }
        return false;
    }

    /**
     * 입력한 문자열(3자리 숫자)과 정답 숫자를 비교하여 스트라이크가 있는지 확인하고,
     * 스트라이크의 갯수를 반환한다.
     *
     * @param answer 정답 숫자가 들어있는 리스트
     * @param input  입력한 문자열(3자리 숫자)
     * @return 스트라이크의 갯수
     */
    private static int getStrike(List<Integer> answer, String input) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (answer.get(i) == num) {   // 스트라이크 확인
                strike++;
            }
        }
        return strike;
    }

    /**
     * 입력한 문자열(3자리 숫자)과 정답 숫자를 비교하여 볼이 있는지 확인하고,
     * 볼의 갯수를 반환한다.
     *
     * @param answer 정답 숫자가 들어있는 리스트
     * @param input  입력한 문자열(3자리 숫자)
     * @return 볼의 갯수
     */
    private static int getBall(List<Integer> answer, String input) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (answer.get(i) != num && answer.contains((num))) {
                ball++;
            }
        }
        return ball;
    }

    /**
     * 서로 다른 랜덤 숫자 3개를 선택하여 list에 저장한다.
     *
     * @param list 랜덤 숫자를 저장할 리스트
     */
    private static void makeRandomNum(List<Integer> list) {
        list.clear();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
    }

    /**
     * 주어진 문자가 숫자인지 판별한다.
     *
     * @param value 문자
     * @return 숫자이면 true, 숫자가 아니면 false.
     */
    private static boolean isInt(char value) {
        try {
            Integer.parseInt(String.valueOf(value));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * 입력한 문자열이 유효한지(서로 다른 숫자 3자리) 판단하고,
     * 잘못된 값 입력 시 `IllegalArgumentException` 발생시킨다.
     *
     * @param inputValue 입력받은 문자열
     */
    private static void validateInput(String inputValue) {
        if (inputValue.length() != 3) {
            throw new IllegalArgumentException("3자리 수로 입력해야 합니다.");
        }
        if (!isNum(inputValue)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        if (!isDifferent(inputValue)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 주어진 문자열이 서로 다른 숫자(1~9)로 이루어졌는지 판별한다.
     *
     * @param str 문자열
     * @return 서로 다른 숫자로 이루어졌으면 true, 아니면 false.
     */
    private static boolean isDifferent(String str) {
        boolean[] isUsed = new boolean[9];
        if (!isNum(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (isUsed[num - 1]) {
                return false;
            }
            isUsed[num - 1] = true;

        }
        return true;
    }

    /**
     * 주어진 문자열이 1~9의 숫자로 이루어졌는지 판별한다.
     *
     * @param str 문자열
     * @return 1~9의 숫자로 이루어졌으면 true, 아니면 false.
     */
    private static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isInt(str.charAt(i))) return false;
            if (str.charAt(i) == '0') return false;
        }
        return true;
    }
}
