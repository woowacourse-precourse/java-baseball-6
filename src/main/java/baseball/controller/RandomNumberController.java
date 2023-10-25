package baseball.controller;

import baseball.domain.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberController {
    private static final int GAME_NUMBER_LENGTH = 3;
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;


    public GameNumber generateGameNumber(){
        GameNumber gameNumber = new GameNumber();

        while(gameNumber.size() < GAME_NUMBER_LENGTH){
            int randomNumber = generateRandomNumber();
            gameNumber.add(randomNumber);
        }
        return gameNumber;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
    }

}
