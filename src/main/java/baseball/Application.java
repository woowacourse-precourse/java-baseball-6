package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int strike;
    static int ball;
    static int num_cnt = 3;
    static int[] number_com = new int[num_cnt];
    static int[] number_user = new int[num_cnt];
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        getRandomNum();

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String user_input = Console.readLine();
            System.out.println(user_input);
            checkCorrectInput(user_input);
            getIntegerArr(user_input);
            getAnswerStrikeBall();
            if (strike == 3) {
                checkReGame();
            }
        } while(strike < 3);
    }

    private static void getRandomNum() {
        for (int i = 0; i < num_cnt; i++) {
            number_com[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    private static void checkCorrectInput(String str) {
        checkingInputLength(str);

        for (int i = 0; i < str.length(); i++) {
            checkingInputZero(str, i);
            checkingInputContained(str, i);
        }
    }

    private static void checkingInputLength(String str) {
        if (str.length() != num_cnt) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkingInputZero(String str, int i) {
        if (str.charAt(i) == '0') {
            throw new IllegalArgumentException();
        }
    }

    private static void checkingInputContained(String str, int i) {
        if (sameNumberContatinedInput(str, str.charAt(i))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean sameNumberContatinedInput(String str, char num) {
        if (sameNumberCounter(str, num) > 1) {
            return true;
        }
        return false;
    }

    private static int sameNumberCounter(String str, char num) {
        int cnt = 0;

        for (char value : str.toCharArray()) {
            if (value == num) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void getIntegerArr(String str) {
        for (int i = 0; i < str.length(); i++) {
            number_user[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private static void getAnswerStrikeBall() {
        ball = 0;
        strike = 0;
        for (int i = 0; i < num_cnt; i++) {
            if (checkingArrayContainedCom(number_user[i])) {
                checkBallStrike(i);
            }
        }

        resultPrint();
    }

    private static boolean checkingArrayContainedCom(int num) {
        for (int value : number_com) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private static void checkBallStrike(int cnt) {
        for (int i = 0; i < num_cnt; i++) {
            counter_strike_ball(cnt, i);
        }
    }

    private static void counter_strike_ball(int cnt, int i) {
        if (number_user[cnt] == number_com[i] && cnt == i) {
            strikeCounter();
        } else if (number_user[cnt] == number_com[i] && cnt != i) {
            ballCounter();
        }
    }

    private static void strikeCounter() {
        strike++;
    }

    private static void ballCounter() {
        ball++;
    }

    private static void resultPrint() {
        String result = "";

        if (ball != 0) {
            result += ball + "볼";
        }

        if (strike != 0) {
            if (ball != 0) {
                result += " ";
            }
            result += strike + "스트라이크";
        }

        if (result.equals("")) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    private static void checkReGame() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String result = Console.readLine();
        int value = Integer.parseInt(result);

        reGameInputResult(value);
    }

    private static void reGameInputResult(int value) {
        if (value == 1) {
            strike = 0;
            getRandomNum();
            //System.out.println(result);
        } else if (value == 2) {
            System.out.println("게임 종료");
        } else {
            throw new IllegalArgumentException();
        }
    }
}