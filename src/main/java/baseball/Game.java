package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Computer computer = new Computer();
    private UserInterface userInterface = new UserInterface();

    private List<Integer> userInputNumbers = new ArrayList<>();
    private int bulls = 0;
    private int cows = 0;

    public void game() {
        while(bulls != 3) {
            userInterface.pleaseEnterNumber();
            inputNumbers();
            if(userInputNumbers.size() == 3) {
                judgmentStrikeOrBall();
            }
        }
        userInterface.gameEndMessage();
        userInterface.restartOrShutdownMessage();
    }
    public void judgmentStrikeOrBall() {
        bulls = computer.strikeCheck(userInputNumbers);
        cows = computer.ballCheck(userInputNumbers) - bulls;
        if(cows > 0) { // 볼 출력
            userInterface.BallMessage(cows);
        }
        if(bulls > 0) { // 스트라이크 출력
            userInterface.strikeMessage(bulls);
        }
        if(cows == 0 && bulls == 0) { // 낫싱 출력
            userInterface.nothing();
        }
        System.out.println();
    }
    public void inputNumbers() throws IllegalArgumentException{ // 숫자3개 입력
        userInputNumbers.clear();

        String input = Console.readLine(); // console => 이름 바꾸기
        for (int i = 0; i < input.length(); i++) {
            userInputNumbers.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        if(userInputNumbers.size() > 3) {
            throw new IllegalArgumentException();
        }
    }
}
