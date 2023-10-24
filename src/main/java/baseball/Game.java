package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임이 진행되는 클래스로 유저에게 3개의 숫자를 입력받고, 스트라이크와 볼의 개수를 이용하여 메시지를 출력함
 */
public class Game {
    private Computer computer = new Computer();
    private UserInterface userInterface = new UserInterface();

    private List<Integer> userInputNumbers = new ArrayList<>();
    private int bulls = 0;
    private int cows = 0;

    public void game() {
        while (bulls != 3) {
            userInterface.pleaseEnterNumber();
            inputNumbers(); // 숫자 입력
            int inputMaxNum = 3;
            /* 입력된 숫자가 3개일 때만 결과 메시지 출력*/
            if (userInputNumbers.size() == inputMaxNum) {
                judgmentStrikeOrBall();
            }
        }
        userInterface.gameEndMessage();
        userInterface.restartOrShutdownMessage();
    }

    /**
     * computer클래스에서 반환받은 스트라이크, 볼의 개수를 사용하여 상황에 알맞은 메시지 출력
     */
    public void judgmentStrikeOrBall() {
        bulls = computer.strikeCheck(userInputNumbers);
        cows = computer.ballCheck(userInputNumbers) - bulls;
        if (cows > 0) { // 볼의 개수 출력
            userInterface.ballMessage(cows);
        }
        if (bulls > 0) { // 스트라이크의 개수 출력
            userInterface.strikeMessage(bulls);
        }
        if ((cows == 0) && (bulls == 0)) { // 낫싱 출력
            userInterface.nothingMessage();
        }
        System.out.println();
    }

    /**
     * 유저에게 숫자 3개 입력받음 입력받은 숫자가 3개를 초과할경우 예외처리
     */
    public void inputNumbers() throws IllegalArgumentException {
        userInputNumbers.clear();

        String userInput = Console.readLine();
        for (int i = 0; i < userInput.length(); i++) {
            userInputNumbers.add(Integer.parseInt(userInput.substring(i, i + 1)));
        }
        int inputLimit = 3; // 입력 한계
        if (userInputNumbers.size() > inputLimit) {
            throw new IllegalArgumentException();
        }
    }
}
