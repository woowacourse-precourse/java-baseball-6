package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Validation validation = new Validation();
        String restart;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            game.play();

            restart = readLine();
            validation.isOkRestart(restart);

        } while (Integer.parseInt(restart) != 2);
    }
}
