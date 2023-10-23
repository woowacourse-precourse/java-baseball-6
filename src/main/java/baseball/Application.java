package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    //
//    private static List<Integer> computerNumbers;
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAMEOVER_MESSAGE = "게임 종료";
    private static final int EXIT_CODE = 2;
    private static final int ALL_STRIKE = 3;

    public static int input() {
        String line = Console.readLine();
        if (line == null || line.length() != 1 || !Character.isDigit(line.charAt(0)) || line.charAt(0) > '2') {
            throw new IllegalArgumentException();
        }
        return Character.getNumericValue(line.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println(STARTING_MESSAGE);

        GameNumber computerNumber = new GameNumber();
        GameNumber userInput;
        while (true) {
//            System.out.println(computerNumber.getBoard());
            System.out.println(INPUT_MESSAGE);
            userInput = new GameNumber(Console.readLine());

            int strikes = computerNumber.countAndPrintGameScore(userInput);
            if (strikes != ALL_STRIKE) {
                System.out.println(GAMEOVER_MESSAGE);
                continue;
            }

            if (input() == EXIT_CODE) {
                return;
            }

            computerNumber = new GameNumber();
        }
    }
}