package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {

    public void play() {
        do {
            List<Integer> computerNumbers = NumberGenerator.generateDefaultSizeComputerNumber();
            List<Integer> userInputNumbers;

            do {
                String userInput = Console.readLine();
                userInputNumbers = Parser.parse(userInput);
            } while (calculateGameResult(computerNumbers, userInputNumbers));
        } while (isContinue());
    }

    private boolean calculateGameResult(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        // TODO : 게임 결과 계산
        return false;
    }

    private boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if(!(userInput.equals("1") || userInput.equals("2"))) {
            throw new IllegalArgumentException();
        }

        if(userInput.equals("1")) {
            return true;
        }

        return false;
    }
}
