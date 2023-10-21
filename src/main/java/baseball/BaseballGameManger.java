package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class BaseballGameManger {

    public int menuChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int menu = Integer.parseInt(Console.readLine());
        if (menu != 1 && menu != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return menu;
    }

    public void playBaseballGame() {
        Computer computer = new Computer();
        User user = new User();
        List<Integer> computerNumbers = computer.generateRandomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameOver = false;
        while (!gameOver) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            try {
                List<Integer> userNumber = user.changeStringToIntegerList(userInput);
                Map<String,Integer> gameResult = user.checkGuess(computerNumbers, userNumber);
                gameOver = computer.printHint(gameResult);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 서로 다른 3자리 숫자를 입력하세요.");
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
