package view;

import static constants.GameConstant.BALL;
import static constants.GameConstant.NOTHING;
import static constants.GameConstant.STRIKE;

import constants.MessageType;
import java.util.List;

public class BaseballGameView {

    public String getGameMessage(MessageType messageType){
        String message= "";
        switch (messageType){
            case GAME_START -> message = MessageType.GAME_START.getMessage();
            case INPUT_NUMBER -> message = MessageType.INPUT_NUMBER.getMessage();
            case GAME_END -> message = MessageType.GAME_END.getMessage();
        }
        return message;
    }

    public String printBaseBallCalculation(List<String> baseBallScoreList){
        if(baseBallScoreList.size() == 0){
            return NOTHING;
        }

        String baseBallResult = "";
        int ballCount = 0;
        int strikeCount = 0;
        for(String score : baseBallScoreList){
            switch (score){
                case BALL -> ballCount++;
                case STRIKE -> strikeCount++;
            }
        }

        if(ballCount != 0){
            baseBallResult = new StringBuilder().append(ballCount).append(BALL).toString();
        }
        if(strikeCount != 0){
            baseBallResult += new StringBuilder().append(strikeCount).append(STRIKE).toString();
        }
        if(ballCount != 0 && strikeCount != 0){
            baseBallResult = new StringBuffer(baseBallResult).insert(2," ").toString();
        }

        return baseBallResult;
    }

    public void print(String message){
        System.out.println(message);
    }

}
