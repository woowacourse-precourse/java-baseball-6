package baseball.api;

import baseball.api.request.RequestChecker;

import static baseball.api.constants.MessageConstants.*;
import static baseball.api.constants.ResponseFormatConstants.*;


public class GameStarter {
    private String result;
    private int length;

    public GameStarter(String result, int length) {
        this.result = result;
        this.length = length;
    }

    public GameHelper run() throws IllegalArgumentException{
        while (true){
            //사용자 인풋 받기
            System.out.print(PLAY_MESSAGE);
            String input = RequestChecker.gameRequest();
            if(isResult(input,result)){
                System.out.println(COMPLETE_MESSAGE);
                System.out.println(END_MESSAGE);
                return new GameHelper();
            }
        }
    }

    private Boolean isResult(String input, String result){
        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<length; i++){
            if (input.charAt(i) == result.charAt(i)){
                strikeCount++;
            } else {
                String c = String.valueOf(input.charAt(i));
                boolean contains = result.contains(c);
                if (contains) {
                    ballCount++;
                }
            }
        }
        return isResult(strikeCount, ballCount);
    }
    private Boolean isResult(int strikeCount, int ballCount) {
        String message = "";

        if (strikeCount > 0 && ballCount > 0) {
            message = String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount);
        } else if (strikeCount > 0) {
            message = String.format(STRIKE_FORMAT, strikeCount);
        } else if (ballCount > 0) {
            message = String.format(BALL_FORMAT, ballCount);
        } else {
            message = EMPTY_FORMAT;
        }

        System.out.println(message);
        return strikeCount == length;
    }
}
