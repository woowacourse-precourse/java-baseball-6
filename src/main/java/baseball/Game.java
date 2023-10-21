package baseball;

import java.io.BufferedReader;

public class Game {
    private final static int ON = 1;
    private final static int OFF = 2;
    private Computer computer;
    private User user;
    private RuleManager ruleManager;
    private NumberManager numberManager;
    private int status = ON;
    

    Game(BufferedReader br){
        this.computer = new Computer();
        this.user = new User();
        this.ruleManager = new RuleManager();
        this.numberManager = new NumberManager(br);
    }

    public int getStatus(){
        return status;
    }

    public void start(){
        computer.setNumber(numberManager.createRandomNumber());
        while(true){
            user.setNumber(numberManager.receiveUserNumber());
            ruleManager.compareNumber(computer, user);
            ruleManager.printStrikeAndBallCnt();
            if(ruleManager.isAnswer()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }   
        }
    }

    public void askRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        status=Integer.parseInt(numberManager.readLine());
    }
}
