package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final static String RESTART_GAME = "1";
    private final static String STOP_GAME = "2";
    private final static String START_GAME_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private final static String RESTART_OR_STOP_QUESTION_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private OneGame oneGame;

    public void startBaseballGame(){
        System.out.println(START_GAME_SENTENCE);

        do{
            oneGame = new OneGame();
            oneGame.oneBaseballGame();
        }while(doRestartGame());

    }

    private boolean doRestartGame() throws IllegalArgumentException {

        System.out.println(RESTART_OR_STOP_QUESTION_SENTENCE);
        return restartUserInput();
    }

    private boolean restartUserInput() throws IllegalArgumentException {
        String userInput = Console.readLine();
        if (!validateUserInput(userInput)){
            throw new IllegalArgumentException();
        }
        return userInput.equals(RESTART_GAME);
    }

    private boolean validateUserInput(String userInput){
        return userInput.equals(RESTART_GAME) || userInput.equals(STOP_GAME);
    }
}
