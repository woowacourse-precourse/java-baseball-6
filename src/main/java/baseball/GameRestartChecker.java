package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameRestartChecker {
    public static String askPlayer(List<Integer> randomNumber) {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        randomNumber= RandomNumberMaker.makeRandomNumber();
        System.out.println(randomNumber);
        return answer;
    }
}
