package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        boolean regame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(regame) {
            Computer computer = new Computer();
            Player player = new Player();
            Game game = new Game();
            Restart restart = new Restart();

            List<Integer> answer = computer.computerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = game.getResult(answer, player.playerNumber());
                System.out.println(result);
            }

            regame = restart.restart();
        }

    }
}
