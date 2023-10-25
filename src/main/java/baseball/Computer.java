package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Computer {
    public static LinkedHashSet<Integer> generatedNumbers() {
        return new LinkedHashSet<>(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }

    public static void printCongrats() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printPlayerInputRequest() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrikesAndBalls(Game game) {
        if (game.strikes == 0 && game.balls == 0) {
            System.out.println("낫싱\n");
            return;
        }
        if (game.strikes != 0 && game.balls != 0) {
            System.out.printf("%d볼, %d스트라이크\n", game.balls, game.strikes);
            return;
        }
        if (game.strikes == 0) {
            System.out.printf("%d볼\n", game.balls);
            return;
        }
        System.out.printf("%d스트라이크\n", game.strikes);
        game.endOfGame = true;
    }
}
