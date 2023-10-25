package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;

public class GameController{
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    GameController() {
        System.out.println(START_MESSAGE);
    }

    public void newGameStart() {
        Game game = new Game();

        while (true) {
            List<Integer> userInputList = getUserInput();
            GameResult result = game.getResult(userInputList);
            System.out.println(result);

            if (result.gameOver()) {
                System.out.println(END_MESSAGE);
                break;
            }
        }
    }

    public List<Integer> getUserInput(){
        System.out.print(INPUT_MESSAGE);

        String userInput = readLine();
        ValidInputChecker.checkUserInput(userInput);
        List<Integer> userInputList = new ArrayList<>();

        for(char c : userInput.toCharArray()){
            userInputList.add(c - '0');
        }

        return userInputList;
    }

    public int getRestartInput(){
        System.out.println(RESTART_MESSAGE);

        int userInput = Integer.parseInt(readLine());
        if(userInput != 1 && userInput != 2){
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return userInput;
    }

    public boolean gameEnd() {
        if(getRestartInput() == 2){
            return true;
        }
        return false;
    }



}
