package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player{

    public List<Integer> getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> playerNumbers = new ArrayList<>();
        String playerInput = Console.readLine();

        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("1~9 중, 세자리 숫자만 입력하세요.");
        }

        try {
            for (int i = 0; i < 3; i++) {
                playerNumbers.add(Character.getNumericValue(playerInput.charAt(i)));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9 중, 세자리 숫자만 입력하세요.");
        }

        return playerNumbers;
    }

    public int getPlayAgainChoice() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        return Integer.parseInt(Console.readLine());
    }
}
