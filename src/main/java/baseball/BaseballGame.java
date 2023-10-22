package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private final static String RESTART_GAME = "1";
    private final static String STOP_GAME = "2";
    private final static int NUMBER_LENGTH = 3;
    private final static String START_GAME_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private final static String CORRECT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String RESTART_OR_STOP_QUESTION_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void startBaseballGame(){
        System.out.println(START_GAME_SENTENCE);

        do{
            startOneGame();
        }while(restartGame());

    }


    private void startOneGame(){
        int strikeNum;

        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        //System.out.println(computerNumber.toString());

        do{
            List<Integer> playerNumber = new PlayerNumber().getPlayerNumber();
            CountResult countResult = new CountResult(computerNumber, playerNumber);
            System.out.println(countResult.makeHintString());
            strikeNum = countResult.getStrikeCount();

        } while(strikeNum != NUMBER_LENGTH);
        System.out.println(CORRECT_ANSWER_SENTENCE);
    }

    private boolean restartGame() throws IllegalArgumentException {

        System.out.println(RESTART_OR_STOP_QUESTION_SENTENCE);

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
