package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public static void playGame() {
        List<Integer> computerNumbers = Computer.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerNumbers;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumbers = Console.readLine();
            GameManager.validPlayerNumbers(playerNumbers);
        } while (GameManager.compareNumbers(computerNumbers, playerNumbers));
    }
}