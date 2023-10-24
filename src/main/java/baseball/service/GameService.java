package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.massage.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.massage.Message.GAME_START;
import static baseball.massage.Message.REQUEST_USER_NUMBER;

public class GameService {
    private List<Integer> computer;
    private List<Integer> user;
    private int strike;
    private int ball;
    public void startGame(){
        System.out.println(GAME_START.getMessage());
        baseballGame();
        restartGame();
    }

    public void baseballGame(){
        clearGame();
        this.computer = Computer.makeRandomNumber();
        while(strike!=3){
            //System.out.println(REQUEST_USER_NUMBER.getMessage());
            System.out.println("값을 입력해주세요 : ");
            this.user = User.inputUserNumber();
            this.strike = countStrike();
            this.ball = countBall();
            printResult();
        }
    }

    public int countStrike(){
        int count=0;
        for(int i=0;i<3;i++){
            if(this.computer.get(i).equals(this.user.get(i))){
                count++;
            }
        }
        return count;
    }

    public int countBall(){
        int count=0;
        for(int i=0;i<3;i++){
            if(this.computer.get(i).equals(this.user.get(i))){
                continue;
            }else if (this.computer.contains(this.user.get(i))){
                count++;
            }
        }
        return count;
    }

    public void printResult(){
        if(strike==3){
            System.out.println(strike+Message.STRIKE.getMessage());
            System.out.println(Message.GAME_END.getMessage());
            return;
        }
        if(strike==0 && ball==0){
            System.out.println(Message.NOTHING.getMessage());
            return;
        }
        if(ball>0&&strike==0){
            System.out.println(ball+Message.BALL.getMessage());
            return;
        }
        if(ball>0&&strike>0){
            System.out.println(ball+Message.BALL.getMessage()+" "+strike+Message.STRIKE.getMessage());
            return;
        }
        if(strike>0&&ball==0){
            System.out.println(strike+Message.STRIKE.getMessage());
        }
    }

    public void restartGame(){
        System.out.println(Message.REQUEST_CHOICE_NUMBER.getMessage());
        String choiceNumber = User.inputChoiceNumber();
        if(choiceNumber.equals("1")){
            baseballGame();
        }
        else{
            Console.close();
        }
    }

    public void clearGame(){
        this.strike = 0;
        this.ball = 0;
    }
}
