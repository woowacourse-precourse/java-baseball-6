package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Player {
    private final DataValidator dataValidator;

    public Player() {
        this.dataValidator = new DataValidator();
    }

    public ArrayList<Integer> getPlayerAnswer() {
        String[] stringValue  = Console.readLine().split("");
        ArrayList<Integer> playerAnswer = new ArrayList<>();
        for(String s : stringValue){
            playerAnswer.add(Integer.parseInt(s));
        }
        dataValidator.playerAnswerValidation(playerAnswer);
        return playerAnswer;
    }


    public int getContinueDecision() {
        int continueDecision = Integer.parseInt(Console.readLine());
        dataValidator.continueDecisionValidate(continueDecision);
        return continueDecision;
    }
}
