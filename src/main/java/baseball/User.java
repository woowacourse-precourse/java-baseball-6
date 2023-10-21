package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> numbers;
    private boolean gameStatus;

    public User() {
        this.gameStatus = true;
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void getNumbersFromUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumbersFromUser(input);
        this.numbers = convertStringToIntList(input);
    }

    public void validateNumbersFromUser(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
                2)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertStringToIntList(String input) {
        List<Integer> numberList = new ArrayList<>();
        String[] split = input.split("");
        for (String number : split) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
        if (input.equals("2")) {
            return false;
        }
        return true;
    }
}
