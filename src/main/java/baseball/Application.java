package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String go = "1";
    public static String again = "1";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (go.equals("1")) {
            String computerNumber = inputComputerNumber();
            again = "1";
            while (again.equals("1") && go.equals("1")) {
                String myNumber = inputMyNumber();
                checkResult(myNumber, computerNumber);
            }
        }
    }

    private static String inputComputerNumber() {
        String randomValues = new String();
        while (randomValues.length() < 3) {
            String randomvalue = String.valueOf(Randoms.pickNumberInRange(0, 9));
            if (!randomValues.contains(randomvalue)) {
                randomValues += randomvalue;
            }
        }
        System.out.println(randomValues);
        return randomValues;
    }

    private static String inputMyNumber() {
        String userValues = Console.readLine();
        if (!isValidNumber(userValues)) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
        System.out.println("숫자를 입력해 주세요 : " + userValues);
        return userValues;
    }

    private static boolean isValidNumber(String number) {
        return number.matches("\\d{3}");
    }

    private static void checkResult(String computerNumber, String myNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            char myChar = myNumber.charAt(i);
            if (computerNumber.charAt(i) == myChar) {
                strike++;
            } else if (computerNumber.contains(String.valueOf(myChar))) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
                if (!input.equals("1") && !input.equals("2")) {
                    throw new IllegalArgumentException("1 또는 2를 입력하세요.");
                }
                go = input;
                again = "2";
            } else {
                System.out.println(strike + "스트라이크");
            }
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}

