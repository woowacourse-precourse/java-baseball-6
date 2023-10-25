package baseball.view;

import baseball.model.GameResultDto;

import static baseball.utility.Constants.GAME_START_MESSAGE;
import static baseball.utility.Constants.NUMBER_INPUT_PROMPT_MESSAGE;
import static baseball.utility.Constants.BALL;
import static baseball.utility.Constants.STRIKE;
import static baseball.utility.Constants.NOTHING;
import static baseball.utility.Constants.NUMBER_CORRECT_MESSAGE;


public class UserView {
    public UserView(){};
    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printNumberInputPrompt(){
        System.out.print(NUMBER_INPUT_PROMPT_MESSAGE);
    }

    public void printResultOfJudgement(GameResultDto gameResultDto){
        int strikeCount = gameResultDto.getStrikeCount();
        int ballCount = gameResultDto.getBallCount();

        if((strikeCount != 0) && (ballCount != 0)){
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        }
        else if((strikeCount == 3) && (ballCount == 0)){
            System.out.println(strikeCount + STRIKE);
            System.out.println(NUMBER_CORRECT_MESSAGE);
        }
        else if((strikeCount != 0) && (strikeCount != 3) && (ballCount == 0)){
            System.out.println(strikeCount + STRIKE);
        }
        else if((strikeCount == 0) && (ballCount != 0)){
            System.out.println(ballCount + BALL);
        }
        else if((strikeCount == 0) && (ballCount == 0)){
            System.out.println(NOTHING);
        }
    }
}
