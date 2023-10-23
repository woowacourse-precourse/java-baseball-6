package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static List<Integer> randomNumMaker() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean isValidNumber(String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!input.matches("^[0-9]+$")) {
            return false;
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
                2)) {
            return false;
        }
        return true;
    }

    public static boolean isValidRestart(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (input.matches("^[1-2]")) {
            if (input.equals("1")) {
                return true;
            } else {
                return false;
            }
        }
        throw new IllegalArgumentException();
    }


    public static List<Integer> stringToList(String input) {
        char[] strChar = input.toCharArray();
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int n = Character.getNumericValue(strChar[i]);
            userNum.add(n);
        }
        return userNum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = randomNumMaker();
        boolean game = true;
        while (game) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!isValidNumber(input)) {
                throw new IllegalArgumentException();
            } else {
                List<Integer> userNum = stringToList(input);
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < userNum.size(); i++) {
                    if (userNum.get(i).equals(computerNum.get(i))) {
                        strike++;
                    } else if (computerNum.contains(userNum.get(i))) {
                        ball++;
                    }
                }
                if (strike == 3) {
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String again = Console.readLine();
                    if (isValidRestart(again)) {
                        computerNum = randomNumMaker();
                    } else {
                        game = false;
                    }

                } else if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                } else if (ball > 0 && strike > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                }
            }
        }

    }
}