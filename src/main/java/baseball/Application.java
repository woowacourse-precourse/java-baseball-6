package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restart = "1";

        while (restart.equals("1")) {
            Game game = new Game();

            while (true) {
                Player player = new Player();
                System.out.print("숫자를 입력해주세요 : ");
                String[] input = Console.readLine().split("");
                for (String s : input) {
                    // 입력 받은 숫자를 플레이어 객체에 추가
                    player.addNumber(Integer.parseInt(s));
                }

                if (input.length != 3 || player.getInput().size() != 3) {
                    // 입력이 잘못된 경우 예외 발생
                    throw new IllegalArgumentException("서로 다른 3글자를 입력하세요.");
                }

                // 게임에서 플레이어 입력을 검사하고 결과를 반환
                int result = game.checkGuess(player);
                printResult(result);

                if (result == 30) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    restart = Console.readLine();
                    break;
                }
            }
        }
    }

    private static void printResult(int result) {
        int strike = result / 10;
        int ball = result % 10;

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
