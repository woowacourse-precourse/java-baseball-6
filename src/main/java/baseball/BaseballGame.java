package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private static void newGame() {
        Computer computer = initAnswer();
        List<Integer> result;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            Player player = new Player(
                    List.of(input.charAt(0) - '0',
                            input.charAt(1) - '0',
                            input.charAt(2) - '0'));

            result = player.compareToAnswer(computer);
            int ball = result.get(0);
            int strike = result.get(1);

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                String ballInfo = ball != 0 ? (ball + "볼") : "";
                String strikeInfo = strike != 0 ? (strike + "스트라이크") : "";
                String info = (ball != 0 && strike != 0) ? (ballInfo + " " + strikeInfo) : (ballInfo + strikeInfo);
                System.out.println(info);
            }

        } while (result.get(1) != 3);
    }

    private static Computer initAnswer() {
        return new Computer();
    }
}