package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.util.Parser;
import baseball.util.RandomUtils;
import baseball.view.BaseballPrint;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class BaseballService {
    int size;
    Game game;
    User user = new User();
    BaseballPrint baseballPrint = new BaseballPrint();
    Parser parser = new Parser();

    public void setGame(int size, int start, int end){
        this.size = size;
        game = new Game(RandomUtils.setRandomNumber(size, start, end));
    }

    public void playGame(){
        baseballPrint.printStartMent();
        int strike = 0;
        while(strike != 3){
            play();
            baseballPrint.printResult(game.getStrikeCnt(), game.getBallCnt());
            strike = game.getStrikeCnt();
        }
    }

    private void play(){
        game.initGameCnt();
        user.setUserNumList(inputUserNumber());
        checkBallAndStrike(user.getUserNumList(), game.getGameNums());
    }

    private int[] inputUserNumber() throws IllegalArgumentException{
        baseballPrint.requestInput();
        String input = Console.readLine();
        return parser.parserUserInput(input, size);
    }

    private void checkBallAndStrike(int[] user, int[] computer){
        int ball = 0, strike = 0;
        int[] cnt = new int[size];
        for(int i = 0; i < size; i++){
            if(user[i] == computer[i]) cnt[i]++;
            for(int j = 0; j < size; j++){
                if(user[i] == computer[j]) cnt[i]++;
            }
        }
        for(int i : cnt){
            if(i == 2) strike++;
            else if(i == 1) ball++;
        }
        game.setStrikeCnt(strike);
        game.setBallCnt(ball);
    }
}
