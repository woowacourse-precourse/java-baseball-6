package baseball;

import java.util.List;

public class OneGame {
    private final static int NUMBER_LENGTH = 3;
    private final static String CORRECT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private CountResult countResult;

    public OneGame() {
        this.computerNumber = new ComputerNumber().getComputerNumber();
    }


    public void oneBaseballGame(){

        //printComputerNumber();  //for test

        do{
            playerNumber = new PlayerNumber().getPlayerNumber();
            countResult = new CountResult(computerNumber, playerNumber);
            countResult.printHintString();
        } while(!isCorrectAnswer());

        System.out.println(CORRECT_ANSWER_SENTENCE);
    }


    private boolean isCorrectAnswer(){
        return countResult.getStrikeCount() == NUMBER_LENGTH;
    }
    private void printComputerNumber(){ //for test
        System.out.println(computerNumber.toString());
    }
}
