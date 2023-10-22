package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {

            System.out.println("숫자 야구 게임을 시작합니다.");
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            int pick = Integer.parseInt(choice);
            if (pick == 1) {
                continue;
            } else if (pick == 2) {
                break;
            } else {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }

    public static void playGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            char[] player = input.toCharArray();
            int strike = 0, ball = 0;
            String nothing = "낫싱";
            for (int i = 0; i < 3; i++) {
                int playerNum = Character.getNumericValue(player[i]);
                if (computer.get(i) == playerNum) {
                    strike++;
                } else if (computer.contains(playerNum)) {
                    ball++;
                }
            }
            if (strike == 3 && ball == 0) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike != 0 || ball != 0) {
                System.out.println(ball + "볼" + " "+strike + "스트라이크, ");
            } else {
                System.out.println(nothing);
            }
            //숫자 야구 게임 test를 위해 임시 사용중인 코드.
            System.out.println(computer);
        }
    }
}

