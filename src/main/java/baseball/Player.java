package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> playerNumber = new ArrayList<>();

    public boolean inputNumber() {
        // 만약 playerNumber가 비어있지 않으면 비워준다.
        if (!playerNumber.isEmpty()) {
            resetPlayerNumber();
        }

        System.out.print("숫자를 입력해주세요 : ");
        try {
            validateInputNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void resetPlayerNumber() {
        playerNumber.clear();
    }

    public static boolean gamePlayOrNot() throws IllegalArgumentException {
        try {
            String selectNumber = Console.readLine();
            if (selectNumber.equals("1")) {
                return true;
            } else if (selectNumber.equals("2")) {
                return false;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean validateInputNumber(String inputNumber) throws IllegalArgumentException {
        // 입력 문자열 값을 숫자로 변경
        int inputNumberToInteger = Integer.parseInt(inputNumber);

        // 각 자리 수를 playerNumber에 저장
        playerNumber.add(inputNumberToInteger / 100);
        playerNumber.add(inputNumberToInteger / 10 % 10);
        playerNumber.add(inputNumberToInteger % 10);

        // 조건에 맞지 않으면 예외 발생
        if (inputNumber.length() != 3 || playerNumber.contains(0) ||
                playerNumber.get(0) == playerNumber.get(1) || playerNumber.get(1) == playerNumber.get(2) ||
                playerNumber.get(0) == playerNumber.get(2)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }
        return true;
    }
}
