package baseball;

import java.util.List;

public class OneGame {
    private final static int NUMBER_LENGTH = 3;
    private final static String CORRECT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public void oneBaseballGame(){
        int strikeNum;

        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        System.out.println(computerNumber.toString());

        do{
            List<Integer> playerNumber = new PlayerNumber().getPlayerNumber();
            CountResult countResult = new CountResult(computerNumber, playerNumber);
            System.out.println(countResult.makeHintString());
            strikeNum = countResult.getStrikeCount();

        } while(strikeNum != NUMBER_LENGTH);
        System.out.println(CORRECT_ANSWER_SENTENCE);
    }
}
