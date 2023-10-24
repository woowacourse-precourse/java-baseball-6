package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.util.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.enums.Constants.*;

public class GameService {
    //TODO
    // - stopGame() 게임을 종료시키는 메소드
    // - retryGame() 게임을 재시작하는 메소드
    // - checkScore()
    //

    private Game game;
    private User user = new User();
    private List<Integer> computer = new ArrayList<>();
    private Message message = new Message();

    static record BaseballScore(int strikeCount, int ballCount){}

    public void setGame(){
        game = new Game(NUM_SIZE.getValue(), NUM_START.getValue(), NUM_END.getValue());
        computer = game.getComputer();
    }

    public void startGame(){
        message.printStartMessage();
        //숫자, 자리 둘다 맞으면 strike, 숫자만 맞으면 ball
        int strikeCount = 0;

        while(strikeCount != NUM_SIZE.getValue()){
            BaseballScore score = checkCount(getUserNum());
            message.printScore(score.strikeCount, score.ballCount);
            strikeCount = score.strikeCount;
        }
    }

    public void stopGame(){
        message.printEndMessage(NUM_SIZE.getValue());
    }

    public boolean retryGame(){
        int answer = Integer.parseInt(Console.readLine());
        message.printRetryMessage(answer);
        if(answer == RETRY.getValue()){
            return true;
        }
        return false;
    }

    public int[] getUserNum(){
        String userNum = Console.readLine();
        message.printAskMessage(userNum);
        return user.parseUserNum(userNum, NUM_SIZE.getValue());
    }

    public BaseballScore checkCount(int[] user){
        int ballCount = 0, strikeCount = 0;
        for(int i=0;i<user.length;i++){
            if(!computer.contains(user[i])) continue;
            if(computer.indexOf(user[i]) == i) strikeCount++;
            else ballCount++;
        }
        return new BaseballScore(strikeCount, ballCount);
    }

}
