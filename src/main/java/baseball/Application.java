package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        boolean restart = true;
        while (restart) {
            Game game = new Game();
            game.play();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart = restart();
        }

    }

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart = Integer.parseInt(Console.readLine());

        return restart == 1;
    }
}
