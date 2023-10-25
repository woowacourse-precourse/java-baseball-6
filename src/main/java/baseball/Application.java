package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void process() {
        Referee referee = new Referee();
        int stop = 0;

        while (stop == 0) {
            System.out.print("숫자를 입력해주세요: ");
            Player player = new Player();

            if (player.Exception(player) == true) {
                referee.randomNumber();
                referee.judgment(player);
                referee.judgmentPrint();
                stop = referee.judgmentStop();
            } else {
                System.out.println("숫자는 3자리여야 합니다.");
                return;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restartNumber = 1;

        while (restartNumber == 1) {
            Application.process();

            restartNumber = Integer.parseInt(Console.readLine());

            if (restartNumber != 1 && restartNumber != 2) {
                System.out.println("1또는 2만 입력하세요.");
                return;
            }
        }
    }
}





