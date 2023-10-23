package baseball;

import static baseball.GameConstants.COUNT;
import static baseball.GameConstants.ENDGAME_MSG;
import static baseball.GameConstants.END_INCLUSIVE;
import static baseball.GameConstants.INPUT_MSG;
import static baseball.GameConstants.START_INCLUSIVE;
import static baseball.GameConstants.START_MSG;

import baseball.domain.Computer;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Computer computer;
    Boolean isWin = false;
    final int REPLAY = 1;

    public GameController() {
        computer = new Computer();
    }

    public void run() throws IllegalArgumentException {
        startGame();
        endGame();
    }

    public void startGame() throws IllegalArgumentException {
        System.out.println(START_MSG);
        // 컴퓨터 랜덤 숫자 생성
        List<Integer> randomNumbers = computer.generateRandomNumbers(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        //List<Integer> randomNumbers = pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        System.out.println("randomNumbers !!!!!!!!!!!!!!!!!!!!!!!= " + randomNumbers);
        //computer.setSecretNumbers(randomNumbers);
        System.out.println("###randomNumbers = " + randomNumbers);
        // user input 받기

        do {
            String userInput = readUserInput(INPUT_MSG);
            System.out.println(userInput);
            List<Integer> userInputNumbers = parseStringNumbers(userInput);

            if (userInputNumbers.size() != COUNT) {
                throw new IllegalArgumentException();
            }

            Game game = computer.computeResult(userInputNumbers);

            if (game.isWin()) {
                isWin = true;
            }
            System.out.println(game.getResultString());

        } while (isWin == false);

    }

    public void endGame() {
        System.out.print(ENDGAME_MSG);
        if (getInputNum() == REPLAY) {
            isWin = false;
            startGame();
            endGame();
        }

    }

    public static String readUserInput(String prompt) {
        System.out.print(INPUT_MSG);
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
