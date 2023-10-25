package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    Game() {
        System.out.println(START_MESSAGE);
    }

    public void start() {
        Computer computer = new Computer();
        //List<Integer> computerNum = computer.generate();
        while (true) {
            System.out.print(INPUT_MESSAGE);
            String playerNum = readLine();
            Input.check(playerNum);

            List<Integer> playerNumList = new ArrayList<>();
            for (char c : playerNum.toCharArray()) {
                playerNumList.add(c - '0');
            }
            System.out.println(playerNumList);

            Rule rule = computer.getResult(playerNumList);
            System.out.println(rule);

            if (rule.isAllStrike()) {
                System.out.println(END_MESSAGE);
                break;
            }
        }
    }
    public int restart() {
        System.out.println(RESTART_MESSAGE);

        String input = readLine();

        return Integer.parseInt(input);
    }


}
