package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void process() {
        Referee referee = new Referee();
        List<Integer> computerNumbers = referee.randomNumber();
        int stop = referee.judgmentStop();

        while (stop == 0) {
            System.out.print("숫자를 입력해주세요: ");
            Player player = new Player();
            Arrays.toString(referee.judgment(player));
            referee.judgmentPrint();
            stop = referee.judgmentStop();
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int restartNumber = 1;
        while (restartNumber == 1) {
            Application.process();
            restartNumber = Integer.parseInt(Console.readLine());
        }
        Console.close();

    }

}
