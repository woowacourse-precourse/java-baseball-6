package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {

    public void play() {
        do {
            List<Integer> computerNumbers = NumberGenerator.generateDefaultSizeComputerNumber();
            // TODO : 사용자 입력 받기

            // TODO : 입력으로 게임 진행

            // TODO : 결과 출력하기
        } while (isContinue());
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
