package baseball;

import baseball.model.ComputerNumbers;
import baseball.model.Number;
import baseball.model.UserNumbers;

public class CompareWithAnswer {

    public static boolean compareWithAnswer(ComputerNumbers computerNums, UserNumbers userNums) {
        Integer strike=0;
        Integer ball=0;

        for(int i=0;i<computerNums.size;i++){
            if(checkStrike(userNums.numbers[i],computerNums.numbers[i]))
                strike++;
            if(checkBall(i,userNums.numbers[i],computerNums))
                ball++;
        }
        return compareResult(strike, ball);
    }

    private static boolean checkBall(int index, Number number, ComputerNumbers computerNums) {
        for(int i=0;i<computerNums.size;i++){
            if(i!=index && number.isequal(computerNums.numbers[i]))
                return true;
        }
        return false;
    }

    private static boolean checkStrike(Number usernumber, Number comuternumber) {
        if(usernumber.isequal(comuternumber))
            return true;
        return false;
    }

    public static Boolean compareResult(Integer strike, Integer ball){
        if(strike==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        else if(strike==0){
            System.out.println(ball+"볼");
        }
        else if(ball==0){
            System.out.println(strike+"스트라이크");
        }
        else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        return false;
    }
}
