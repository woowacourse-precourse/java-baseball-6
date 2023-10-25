package baseball.domain;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public UserNumbers getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        ArrayList<Integer> userNumbersList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            userNumbersList.add(Character.getNumericValue(c));
        }
        return new UserNumbers(userNumbersList);
    }
    public void play() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            Computer inputComputer = new Computer();
            boolean answerNumber = false;
            while (!answerNumber) {
                UserNumbers user = getUserInput();
                NumberCompare numberCompare = new NumberCompare(inputComputer);
                System.out.println(numberCompare.getResult(user));
                if (numberCompare.getResult(user).startsWith("3스트라이크")) {
                    answerNumber = true;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if (!rePlay()) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
    private static boolean rePlay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equalsIgnoreCase("1");
    }
}
