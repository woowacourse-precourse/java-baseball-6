package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        boolean restart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart) {

            BaseBallGame baseBallGame = new BaseBallGame();
            boolean isGameOver = false;

            do {

                System.out.print("숫자를 입력해주세요 : ");

                String input = Console.readLine();
                String[] userNumberStr = input.split("");
                int[] userNumberInt = stringToInt(userNumberStr);

                baseBallGame.checkEnableUserNumber(userNumberInt);
                isGameOver = baseBallGame.isGameOver();

                if (isGameOver) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restartInput = Console.readLine();
                    restart = restartInput.equals("1") ? true : false;
                }

            } while (!isGameOver);
        }

    }

    private static int[] stringToInt(String[] numbersStr) {
        try {
            int[] numbersInt = Stream.of(numbersStr).mapToInt(Integer::parseInt).toArray();
            return numbersInt;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 외의 문자가 입력되었습니다.");
        }
    }

}
