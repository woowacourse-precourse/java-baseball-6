package baseball;

import computer.Comparator;
import computer.Computer;
import computer.Hint;
import user.User;
import view.InputView;
import view.OutputView;

public class BaseballGame implements Game{

    private static GameRule rule = new BaseBallRule();
    private static Comparator comparator = new Comparator();
    private static Hint hint = Hint.getInstance();
    private static OutputView outputView=new OutputView();
    private static InputView inputView=new InputView();
    private static BaseballGame baseballGame=new BaseballGame();

    private Balls userBalls;
    private Balls computerBalls;

    private BaseballGame(){}

    public static BaseballGame getInstance(){
        return baseballGame;
    }

    @Override
    public void start() {
        inputView.start();
        Computer computer=new Computer();
        computerBalls=computer.makeComputerNumber();
        rulePassCheck();
        over();
    }

    public void rulePassCheck(){
        boolean pass=false;
        do{
            receiveUserBalls();
            compare(pass);
            pass=ruleApply();
        }while(!pass);
    }

    public void receiveUserBalls(){
        User user=new User();

        userBalls=user.makeUserNumber(inputView.enterUserAnswer());
    }

    public void compare(boolean pass){
        if(!pass){
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
