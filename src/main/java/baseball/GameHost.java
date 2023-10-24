package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameHost {
    //게임 진행
    public static void startGame(List<Integer> randomNumber) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String exit = "";
        while (!exit.equals("2")) {
            int playerNumber = getPlayerNumber();
            boolean result = NumberComparer.compareNumbers(playerNumber, randomNumber);
            if (result == true) {
                exit = GameRestartChecker.askPlayer();
                randomNumber = RandomNumberMaker.makeRandomNumber();
                System.out.println(randomNumber);
            }
        }
    }
    //숫자 입력받기
    public static int getPlayerNumber() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());
        InputValidator.checkPlayerNumber(input);
        return input;
    }


}
