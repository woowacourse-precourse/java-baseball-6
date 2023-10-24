package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        User user;
        Game game;
        Computer computer = new Computer();
        Print.printString("숫자 야구 게임을 시작합니다.");
        while(true){
            Print.printString("숫자를 입력해주세요 : ");
            user = new User();
            game = new Game();
            game.countBallAndStrike(user.inputList, computer.inputList);
            game.printBallAndStrike();

            if(game.strike == 3){
                game.printGameOver();
                String gameRestartInput = game.gameRestartInput();
                if(gameRestartInput.equals("1")){
                    continue;
                }
                if(gameRestartInput.equals("2")){
                    break;
                }
            }
        }
    }
}
