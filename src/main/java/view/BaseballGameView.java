package view;

import constants.MessageType;
import java.util.List;

public class BaseballGameView {

    public String printMessage(MessageType messageType){
        String message= "";
        switch (messageType){
            case GAME_START -> message = MessageType.GAME_START.getMessage();
            case INPUT_NUMBER -> message = MessageType.INPUT_NUMBER.getMessage();
            case GAME_END -> message = MessageType.GAME_END.getMessage();
        }
        return message;
    }

    public String printBaseBallCalculation(List<String> baseBallScoreList){
        String baseBallResult = "";

        return baseBallResult;
    }

    public void print(String message){
        System.out.println(message);
    }

}
