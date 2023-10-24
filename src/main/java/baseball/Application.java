package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int ball = 0;
        int strike = 0;
        String restart = "1";

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 임의 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 게임 진행
        while (restart.equals("1")) {
            // 사용자 입력
            String input = Console.readLine();

            List<Integer> user = parseInput(input);

            // 게임 진행
            for (int i = 0; i < computer.size(); i++) {
                for (int j = 0; j < user.size(); j++) {
                    if (computer.get(i) == user.get(i)) {
                        strike++;
                    } else if (computer.get(i) == user.get(j + 1)) {
                        ball++;
                    } else if (computer.get(i) == user.get(j + 2)) {
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하러면 2를 입력하세요.");
                restart = Console.readLine();
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    public static List<Integer> parseInput (String input) throws IllegalArgumentException {
        int inputNum = Integer.parseInt(input);
        int inputNum1 = inputNum / 100;
        int inputNum2 = inputNum % 100 / 10;
        int inputNum3 = inputNum % 10;
        List<Integer> user = new ArrayList<>(Arrays.asList(inputNum1, inputNum2, inputNum3));

        if (user.get(0) == user.get(1) || user.get(1) == user.get(2) || user.get(2) == user.get(0) || inputNum1 > 9) {
            throw new IllegalArgumentException();
        } else {
            return user;
        }
    }
}