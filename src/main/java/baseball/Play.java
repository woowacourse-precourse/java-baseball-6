package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Play {

    public void game(String input) {

        List<Integer> computer = new Computer().anotherNumber();
        int value = 0;
        while (value != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> player = change(input);

            value = compare(player, computer);
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public List<Integer> change(String input) {

        List<Integer> inputNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            inputNumber.add(number);
        }
        return inputNumber;
    }

    public boolean inputCheck(String input) {
        List<Character> inputNumber = new ArrayList<>();
        for (int i = 0; i < inputNumber.size(); i++) {
            char wordNumber = input.charAt(i);
            if (!inputNumber.contains(wordNumber)) {
                inputNumber.add(wordNumber);
            }
        }
        try {
            if (input.length() != 3 || !numberCheck(input)) {
                throw new IllegalArgumentException();
            } else if (inputNumber.size() != input.length()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean numberCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public int newGameCheck() {
        try {
            String input = Console.readLine();
            if (input.length() != 1) {
                throw new IllegalArgumentException();
            }
            int newgame = Integer.parseInt(input);
            if (newgame == 1) {
                return 1;
            } else if (newgame == 2) {
                return 0;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return 2;
        }
    }

    public int compare(List<Integer> player, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < player.size(); i++) {
            int now = player.get(i);
            if (answer.get(i) == now) {
                strike++;
            } else if (answer.contains(now)) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return strike;
    }
}
