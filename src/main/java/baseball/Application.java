package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static String getRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(computer.get(i));
        }
        return sb.toString();
    }

    public static int playBaseBallGame(String randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) throw new IllegalArgumentException();

        int strike = 0;
        int ball = 0;
        char[] inputs = input.toCharArray();
        char[] randomNumbers = randomNumber.toCharArray();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputs[i] == randomNumbers[j]) {
                    ball++;
                }
            }
            if (inputs[i] == randomNumbers[i]) {
                strike++;
                ball--;
            }
        }

        if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else {
            StringBuffer sb = new StringBuffer();
            if (ball != 0) sb.append(ball + "볼");
            if (ball != 0 && strike != 0) sb.append(" ");
            if (strike != 0) sb.append(strike + "스트라이크");
            System.out.println(sb.toString());
        }

        return strike;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            String randomNumber = getRandom();

            int strike = 0;
            while(strike != 3) {
                strike = playBaseBallGame(randomNumber);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int startKey = Integer.parseInt(Console.readLine());

            if (startKey == 1) continue;
            else if (startKey == 2) return;
            else throw new IllegalArgumentException();
        }
    }
}
