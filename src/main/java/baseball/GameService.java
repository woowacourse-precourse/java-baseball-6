package baseball;

import baseball.model.Game;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    //TODO
    // - setGame() 게임에 대한 기본 정보를 세팅하는 메소드
    // - startGame() 게임을 시작시키는 메소드
    // - stopGame() 게임을 종료시키는 메소드
    // - retryGame() 게임을 재시작하는 메소드

    private final int NUM_SIZE = 3;
    private final int NUM_START = 1;
    private final int NUM_END = 9;

    private Game game;
    private User user = new User();
    private List<Integer> computer = new ArrayList<>();
    public void setGame(){
        game = new Game(NUM_SIZE,NUM_START,NUM_END);
        computer = game.getComputer();
    }

    public void startGame(){
        setGame();

        //숫자, 자리 둘다 맞으면 strike, 숫자만 맞으면 ball
        int strikeCount = 0, ballCount = 0;


    }

    public void stopGame(){

    }

    public void retryGame(){

    }

}
