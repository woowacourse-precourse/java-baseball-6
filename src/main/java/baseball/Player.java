package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Player {
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = "";

        try {
            playerNumber = validateInputNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return playerNumber;
    }

    public static boolean gamePlayOrNot() throws IllegalArgumentException {
        String selectNumber = Console.readLine();

        if (selectNumber.equals("1")) {
            return true;
        } else if (selectNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }
    }

    public String validateInputNumber(String inputNumber) throws IllegalArgumentException {
        // 각 자리를 비교하기 위한 String 배열
        String[] playerNumberSplit = inputNumber.split("");
        // 조건에 맞지 않으면 예외 발생
        if (playerNumberSplit.length != 3 || Arrays.asList(playerNumberSplit).contains("0") ||
                playerNumberSplit[0].equals(playerNumberSplit[1]) || playerNumberSplit[1].equals(playerNumberSplit[2]) ||
                playerNumberSplit[0].equals(playerNumberSplit[2])) {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }

        return inputNumber;
    }
}
