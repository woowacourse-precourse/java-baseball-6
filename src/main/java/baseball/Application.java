package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        boolean run = false;
        String gameStarter = "0";

        while(!run) {
            NewGame newGame = new NewGame();
            newGame.newGamePlay();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            while (!Objects.equals(gameStarter, "2")) {
               gameStarter = readLine();
                if (Objects.equals(gameStarter, "1")) {
                    break;
                } else if (Objects.equals(gameStarter, "2")) {
                    run = true;
                    break;
                } else{
                    System.out.println("잘못 입력하셨습니다. " +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }
        }
    }
}
