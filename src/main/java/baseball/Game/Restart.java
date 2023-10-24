package baseball.Game;

import baseball.Exception.Exception;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Restart {
    public static String restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Choice choice;
        String restart = Console.readLine();

        choice = Arrays.stream(Choice.values())
                .filter(c -> c.getChoice().equals(restart))
                .findFirst()
                .orElse(null);

        Exception.validateChoice(choice);

        return choice.getChoice();

    }
}
