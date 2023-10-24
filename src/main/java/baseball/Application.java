package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomNumber = RandomNumberMaker.makeRandomNumber();

        System.out.println(randomNumber);

        System.out.println("숫자 야구 게임을 시작합니다.");
        String exit = " ";
        while (exit != "2") {
            int playerNumber = getPlayerNumber();
            boolean result = NumberComparer.compareNumbers(playerNumber, randomNumber);
            if (result == true)
                exit = GameRestartChecker.askPlayer(randomNumber);
        }


    }

    public static int getPlayerNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }


}
