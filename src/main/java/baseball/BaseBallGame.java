package baseball;

import computer.Comparator;
import computer.Computer;
import computer.Hint;
import user.User;
import view.OutputView;

public class BaseBallGame implements Game{

    private static GameRule rule = new BaseBallRule();
    private static Comparator comparator = new Comparator();
    private static Hint hint = new Hint();
    private static OutputView outputView=new OutputView();

    private Balls userBalls;
    private Balls computerBalls;
    private User user=new User();
    private Computer computer = new Computer();

    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerBalls=computer.makeComputerNumber();
        userBalls=user.makeUserNumber();
        comparator.compare(computerBalls,userBalls);
        rulePassCheck();
        over();
    }

    public void rulePassCheck(){
        boolean pass;
        do{
            pass=ruleApply();
            getUserNumberAndCompare(pass);
        }while(!pass);
    }

    public void getUserNumberAndCompare(boolean pass){
        if(!pass){
            userBalls=user.makeUserNumber();
            comparator.compare(computerBalls,userBalls);
        }
    }

    public boolean ruleApply(){
        outputView.viewHint();
        if(rule.isRulePass(hint.loadStrike())){
            return true;
        }
        return false;
    }

    @Override
    public void over() {
        outputView.viewGameOver();
    }
}
