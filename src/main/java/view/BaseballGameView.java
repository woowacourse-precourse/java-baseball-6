package view;

import constants.MessageType;

public class BaseballGameView {

    public String printMessage(MessageType messageType){
        String message= "";
        switch (messageType){
            case GAME_START -> message = MessageType.GAME_START.getMessage();
            case INPUT_NUMBER -> message = MessageType.INPUT_NUMBER.getMessage();
            case STRIKE -> message = MessageType.STRIKE.getMessage();
            case GAME_END -> message = MessageType.GAME_END.getMessage();
        }
        return message;
    }

}
