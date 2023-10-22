package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import utility.Check;
public class BaseballController {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> player = new ArrayList<>();
    static boolean RUNNING = true;
    public static void game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        getRandomNumber(computer);
        getPlayerNumber();
    }
    public static void getRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void getPlayerNumber() {
        for (int i = 0; i < 3; i++) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = readLine();
            if(Check.checkUserInput(input)) {
                player.add(Integer.valueOf(input.substring(i, i + 1)));
            }
        }
    }

}
