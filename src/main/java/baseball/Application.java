package baseball;

import baseball.game.Game;
import baseball.game.NumberBaseballGameImpl;
import baseball.gameMachine.GameMachine;
import baseball.gameMachine.GameMachineImpl;
import baseball.user.User;
import baseball.user.UserImpl;


public class Application {
    public static void main(String[] args) {
//        System.out.println("숫자 야구 게임을 시작합니다.");
//
//        List<Integer> computerNumList;
//        List<Integer> userNumList;
//        int[] resultArray;
//
//        do {
//            computerNumList = generateComputerNumber();
//            do {
//                userNumList = receiveUserNumber();
//                resultArray = compare(userNumList, computerNumList);
//                printResult(resultArray);
//
//            } while (!checkResult(resultArray));
//
//        } while (askForRegame());

        User user = new UserImpl();
        Game game = new NumberBaseballGameImpl();
        GameMachine gameMachine = new GameMachineImpl(user, game);
        gameMachine.runGame();


    }




}


