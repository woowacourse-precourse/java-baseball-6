package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandler();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            Player player = new Player();
            Computer computer = new Computer();

            List<Integer> pNumber = player.playerNumber();
            List<Integer> cNumber = computer.computerNumber();

            errorHandler.checkPlayerNumber(pNumber);
            Game game = new Game();

            game.setGame(pNumber, cNumber);

            while(true){
                if(game.play()) break;
                pNumber = player.playerNumber();
                errorHandler.checkPlayerNumber(pNumber);
                game.setGame(pNumber, cNumber);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reGame = Console.readLine();
            errorHandler.checkReGame(reGame);

            if(reGame.equals("2")) break;
        }
    }
}