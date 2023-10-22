package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        StartCreate startCreate = new StartCreate();

        CheckFinal checkFinal = new CheckFinal();

        StartGame startGame = new StartGame();

        boolean check = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (check){

            List<Integer> computer = startCreate.computerCreate();
            String result = "";
            String repo = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

            while (!result.equals(repo)){
                result = checkFinal.checkAll(computer, startGame.PlayerNumber());
                System.out.println(result);
            }
            check = startGame.isGameStart();
        }

    }
}
