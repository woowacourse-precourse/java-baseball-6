package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            playGame();
        } while (restartGame());
    }

    private static void playGame() {
        List<Integer> computerNumbers = Computer.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerNumbers;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumbers = Console.readLine();
            GameManager.validPlayerNumbers(playerNumbers);
        } while (GameManager.compareNumbers(computerNumbers, playerNumbers));
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerDecision = Console.readLine();
        if (playerDecision.equals("1")) {
            return true;
        }
        if (playerDecision.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력은 1 또는 2이어야 합니다.");
    }
}