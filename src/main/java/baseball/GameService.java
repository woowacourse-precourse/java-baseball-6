package baseball;

import baseball.model.Game;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    //TODO
    // - stopGame() 게임을 종료시키는 메소드
    // - retryGame() 게임을 재시작하는 메소드
    // - checkScore()
    //

    private final int NUM_SIZE = 3;
    private final int NUM_START = 1;
    private final int NUM_END = 9;

    private final int RETRY = 1;
    private final int END = 2;
    private Game game;
    private User user = new User();
    private List<Integer> computer = new ArrayList<>();
    private Message message = new Message();

    public void setGame(){
        game = new Game(NUM_SIZE,NUM_START,NUM_END);
        computer = game.getComputer();
    }

    public void startGame(){
        message.printStartMessage();
        setGame();

        //숫자, 자리 둘다 맞으면 strike, 숫자만 맞으면 ball
        int strikeCount = 0;

        while(strikeCount != NUM_SIZE){
            int[] score = checkScore(getUserNum());
            message.printScore(score[0],score[1]);
            strikeCount = score[0];
        }
        stopGame();
    }

    public void stopGame(){
        message.printEndMessage(NUM_SIZE);
        retryGame();
    }

    public void retryGame(){
        int answer = Integer.parseInt(Console.readLine());
        message.printRetryMessage(answer);
        if(answer == RETRY){
            startGame();
        }
    }

    public int[] getUserNum(){
        String userNum = Console.readLine();
        message.printAskMessage(userNum);
        return user.parseUserNum(userNum, NUM_SIZE);
    }

    public int[] checkScore(int[] user){
        int[] score = new int[2];
        for(int i=0;i<user.length;i++){
            if(!computer.contains(user[i])) continue;
            if(computer.indexOf(user[i]) == i) score[0]++;
            else score[1]++;
        }
        return score;
    }
}
