package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final static int numberLength = 3;
    /* 게임 시작 */
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Answer answer = new Answer(numberLength);
        String message;
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            checkInputValue(userAnswer, numberLength);
            int[] result = answer.getStatusArray(userAnswer);
            Status status = new Status(result);
            message = status.toString();
            System.out.println(message);
            if (status.isCorrect()) {
                System.out.println(message);
                break;
            }
        }
        menu();
        Console.close();
    }
    /* 입력 값 정상여부 확인 */
    private static void checkInputValue (String userAnswer, int numberLength) {
        if (userAnswer.length() != numberLength)
            throw new IllegalArgumentException();
    }
    /* 게임 종료 후 메뉴 선택 1 - 재시작, 2 - 종료 */
    private static void menu () {
        String menuSelect = Console.readLine();
        while (!menuSelect.equals("2")) {
            if (menuSelect.equals("1")) {
                startGame();
                return;
            }
            menuSelect = Console.readLine();
        }
        System.out.println(numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
