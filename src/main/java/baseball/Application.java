package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {
    public List<Integer> comNumbers = new ArrayList<>();

    public void choiceComNumbers() {
        while (comNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumbers.contains(randomNumber)) {
                comNumbers.add(randomNumber);
            }
        }
    }
}

class Game extends Computer {

    public void startGame() {
        choiceComNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");

        int ball = 0;
        int strike = 0;

        while (strike != 3) {
            ball = 0;
            strike = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String myNumbers = Console.readLine();

            for (int i = 0; i <= 2; i++) {
                int compare = comNumbers.indexOf(myNumbers.charAt(i) - '0');

                if (compare == -1) {
                    // 일치하는 숫자 없음
                } else if (compare == i) {
                    ++strike;
                } else {
                    ++ball;
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.print("낫싱");
            }
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
    }
}

class ReGame {
    public int restart() {
        int replay = Integer.parseInt(Console.readLine());
        if (replay == 1) {
            return 0;
        } else if (replay == 2) {
            return 1;
        } else {
            return -1;  // 예외처리
        }
    }
}

public class Application {
    public static void main(String[] args) {
        int restart = 0;

        while (restart == 0) {
            Game game = new Game();
            ReGame reGame = new ReGame();

            game.startGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restart = reGame.restart();
        }
    }
}