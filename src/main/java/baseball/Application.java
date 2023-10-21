package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args){
        
        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();
        RuleManager ruleManager = new RuleManager();
        NumberManager numberManager = new NumberManager();

        System.out.println("야구게임시작");
        computer.setNumber(numberManager.createRandomNumber());
        System.out.println("computerNum="+computer.getNumber());
        while(true){
            user.setNumber(numberManager.receiveNumber());
            System.out.println("userNum="+user.getNumber());
            ruleManager.compareNumber(computer, user);
            ruleManager.printStrikeAndBallCnt();
            if(ruleManager.isAnswer()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        List<Integer> randNum = numberManager.createRandomNumber();
        List<Integer> num = numberManager.receiveNumber();

        System.out.println("randnum = "+randNum);
        System.out.println("num = "+num);

    }
}
