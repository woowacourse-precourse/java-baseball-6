package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Play {

    List<Integer> computer;

    public void game(String input) {

        computer = new Computer().anotherNumber();
        int value = 0;
        while (value != 3) {

            List<Integer> player = numbers(input);
            if (player.size() == 0) {
                return;
            }

            value = compare(player, computer);
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");

        int newgame = new Input(input).newGameCheck();
        if (newgame == 1) {
            System.out.println(1);
            new Application();
        }
    }

    public List<Integer> numbers(String input) {

        List<Integer> inputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num < '0' || num > '9') {
                break;
            }
            int value = Integer.parseInt(String.valueOf(num));
            if (inputNumber.contains(value)) {
                break;
            }
            inputNumber.add(value);
        }
        if (!inputCheck(inputNumber)) {
            inputNumber.clear();
        }
        return inputNumber;
    }

    private boolean inputCheck(List<Integer> numbers) {
        try {
            if (numbers.size() == 3) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
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
                return 2;
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
