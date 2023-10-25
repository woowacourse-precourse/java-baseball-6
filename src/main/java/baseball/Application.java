package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static Computer computer;
    static Player player;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        computer = new Computer();
        player = new Player();
        start();

    }

    private static void start() {
        while (!computer.getResult(player.getNumber(computer.DIGIT))) {
            continue;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restart();
    }

    private static void restart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int num = Integer.parseInt(readLine());
            if (num == 1) {
                if (computer.reset())
                    start();
            }
        } catch (IllegalArgumentException e) {
        }
    }

}