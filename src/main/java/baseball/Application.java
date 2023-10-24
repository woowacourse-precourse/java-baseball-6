package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int status = 1;
        while (status == 1) {

            String computer = makeRandomNums();

            boolean correct = false;
            while (!correct) {
                String user = enterNums();
                correct = check(computer, user);
                if (correct) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Integer.parseInt(Console.readLine());
        }
    }

    private static String makeRandomNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }

    private static String enterNums() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // 숫자 자릿수가 3이 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 범위 밖의 숫자나 문자를 입력한 경우
        if (!(input.replaceAll("[1-9]+", "").equals(""))) {
            throw new IllegalArgumentException();
        }

        //중복된 수를 입력한 경우
        List<Integer> dup_check = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(input.substring(i, i + 1));
            if (dup_check.contains(num)) {
                throw new IllegalArgumentException();
            }
            dup_check.add(num);
        }

        return input;
    }

    private static boolean check(String computer, String user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.charAt(i) == computer.charAt(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }

        return strike == 3;
    }
}
