package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private final int size=3;
    private RandomNumber randomNumber;
    private UserInputNumber userInputNumber;
    private NumberComparator numberComparator;
    private UserInputFlag userInputFlag;
    public BaseballGame(){
        this.randomNumber= new RandomNumber();
        this.userInputNumber= new UserInputNumber();
        this.numberComparator = new NumberComparator();
        this.userInputFlag=new UserInputFlag();
    }
    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean retry=false;
        do{
            boolean finish=false;
            randomNumber.setRandomNumber(size);
            do{
                userInputNumber.inputNumber();
                userInputNumber.numberValidCheck(size);
                numberComparator.compare(randomNumber.getAnswer(),userInputNumber.getUserNumber());
                finish=getResult(numberComparator.getStrike(),numberComparator.getBall());
            } while(!(finish));
            userInputFlag.checkRetry();
            retry=userInputFlag.getFlag();
        }while(retry);
    }
    public boolean getResult(int strike, int ball){
        List<String> instructions = new ArrayList<>();
        if(ball!=0){
            instructions.add(ball+"볼");
        }
        if(strike!=0){
            instructions.add(strike+"스트라이크");
        }
        if(instructions.size()==0){
            System.out.println("낫싱");
        }
        else{
            System.out.println(instructions.stream().collect(Collectors.joining(" ")));
        }
        if (strike==this.size){
            System.out.println(size+"개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }


}
