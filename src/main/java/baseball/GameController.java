package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 :";
    private static final String ENDGAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    private Computer computer;
    private Game game;

    Boolean isWin = false;
    int targetCount = 3;

    public GameController() {
        computer = new Computer();
    }

    public void startGame() {
        System.out.println(START_MSG);
        // 컴퓨터 랜덤 숫자 생성
        List<Integer> randomNumbers = computer.generateRandomNumbers(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        System.out.println("randomNumbers = " + randomNumbers);
        // user input 받기

        do {
            String userInput = readUserInput(INPUT_MSG);
            System.out.println("userInput = " + userInput);
            List<Integer> userInputNumbers = parseStringNumbers(userInput);

            System.out.println(userInputNumbers);

            if (userInputNumbers.size() != COUNT) {
                System.out.println("입력한 숫자의 개수가 " + COUNT + "개가 아닙니다. 다시 입력하세요.");
                continue;
            }

            Game game = computer.computeResult(userInputNumbers);

            if (game.isWin()) {
                isWin = true;
            }

            System.out.println("game.isWin() = " + game.isWin());
            System.out.println("game result = " + game.getResultString());

        } while (isWin == false);
    }

    public void endGame() {
        System.out.println(ENDGAME_MSG);

        if (getInputNum() == 1) {
            startGame();
        }
    }

    public static String readUserInput(String prompt) {
        System.out.println(INPUT_MSG);
        return Console.readLine();
    }

    private int getInputNum() {
        int inputNum = Integer.parseInt(Console.readLine());

        return inputNum;
    }

    public static List<Integer> parseStringNumbers(String userInput) {

        List<Integer> userInputNumbers = new ArrayList<>();
        for (char digit : userInput.toCharArray()) {
            if (Character.isDigit(digit)) {
                userInputNumbers.add(Integer.parseInt(String.valueOf(digit)));
            } else {
                // 숫자가 아닌 문자를 입력했을 때 예외 처리 로직 추가
                // 유효하지않은 입력에 대한 처리,에러메시지 출력
            }
        }
        return userInputNumbers;
    }
}
