package baseball;

import computer.Comparator;
import computer.Computer;
import computer.Hint;
import user.User;

public class BaseBallGame implements Game{

    private Balls userBalls;
    private Balls computerBalls;
    private static User user=new User();
    private Computer computer = new Computer();
    private static GameRule rule = new BaseBallRule();
    private static Comparator comparator = new Comparator();
    private static Hint hint = new Hint();
    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerBalls=computer.makeComputerNumber();
        userBalls=user.makeUserNumber();
        comparator.compare(computerBalls,userBalls);
        gameProgress();
        over();

    }

    public void gameProgress(){
        boolean pass;
        do{
            pass=ruleApply();
            if(pass==false){
                userBalls=user.makeUserNumber();
                comparator.compare(computerBalls,userBalls);
            }
        }while(!pass);
    }

    public boolean ruleApply(){
        System.out.println("strike:"+ hint.loadStrike()+", ball: "+hint.loadBall());
        if(rule.isRulePass(hint.loadStrike())){
            return true;
        }
        return false;
    }




    @Override
    public void over() {
        System.out.println("게임종료");
    }

}
