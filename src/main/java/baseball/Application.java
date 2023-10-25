package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


class User {
    public List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!checkNumCorrect(input)) {
            throw new IllegalArgumentException();
        }
        return convertInputToList(input);
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private static boolean checkNumCorrect(String strValue) {
        //길이가 3이 아닌 경우 여부
        if (strValue.length() != 3)
            return false;
        //같은 숫자 반복 여부
        else if (strValue.charAt(0) == strValue.charAt(1) || strValue.charAt(0) == strValue.charAt(2) || strValue.charAt(1) == strValue.charAt(2))
            return false;

        //정수가 아닌 다른 것이 입력된 경우 여부
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}

class Result {
    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameWon() {
        return strikes == 3;
    }


    public void printResult() {
        if (strikes == 0 && balls == 0)
            System.out.println("낫싱");
        else if (strikes == 3)
            System.out.println("3스트라이크");
        else if (balls == 0)
            System.out.println(strikes + "스트라이크");
        else if (strikes == 0)
            System.out.println(balls + "볼");
        else
            System.out.println(balls + "볼 " + strikes + "스트라이크");
    }
}

class BaseballGame {
    private final List<Integer> computerNumbers;

    private List<Integer> generateNumbers() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
        return digits;
    }

    public BaseballGame() {
        this.computerNumbers = generateNumbers();
    }

    public Result playTurn(User user) {
        List<Integer> userNumbers = user.inputNumbers();
        int strikes = 0;
        int balls = 0;

        for (int userIndex = 0; userIndex < 3; userIndex++) {
            for (int comIndex = 0; comIndex < 3; comIndex++) {
                if (userNumbers.get(userIndex).equals(computerNumbers.get(comIndex))) {
                    if (userIndex == comIndex)
                        strikes += 1;
                    else
                        balls += 1;
                }
            }
        }
        return new Result(strikes, balls);
    }
}

public class Application {
    public static void main(String[] args) {
        while (true) {
            BaseballGame game = new BaseballGame();
            User user = new User();

            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                Result result = game.playTurn(user);
                result.printResult();

                if (result.isGameWon()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("2")) {
                break;
            }
        }
    }
}

