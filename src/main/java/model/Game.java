package model;

import static constants.GameConstant.BALL;
import static constants.GameConstant.STRIKE;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public boolean isUserNumber(String number){
        final String ONLY_NUMBER_REGEX = "[0-9]+";
        number = number.trim();
        if(!number.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자 외 다른 문자가 포함되어 있습니다.");
        }
        if(number.length() != 3){
            throw new IllegalArgumentException("3 자리 숫자만 가능합니다.");
        }
        return true;
    }

    public List<String> createBaseballScoreList(String computerNumber, String userNumber){
        List<String> baseballScoreList = new ArrayList<>();
        for(int i=0; i < userNumber.length(); i++){
            char userChar = userNumber.charAt(i);

            if(computerNumber.contains(userChar + "")){
                String scoreResult = BALL;
                if(userChar == computerNumber.charAt(i)){
                    scoreResult = STRIKE;
                }
                baseballScoreList.add(scoreResult);
            }
        }
        return baseballScoreList;
    }


}
