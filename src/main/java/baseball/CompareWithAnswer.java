package baseball;

import java.util.List;

public class CompareWithAnswer {
    public static Boolean compareWithAnswer(List<Integer> answer, List<Integer> userInput){
        Integer strike=0;
        Integer ball=0;

        for(int i=0;i<userInput.size();i++){
            if(checkStrike(userInput.get(i),answer.get(i)))
                strike++;
            if(checkBall(i,userInput.get(i),answer))
                ball++;
        }
        return compareResult(strike, ball);
    }

    public static Boolean checkStrike(Integer userIndexInteger,Integer answerIndexInteger){
        if(answerIndexInteger==userIndexInteger)
            return true;
        else
            return false;
    }

    public static Boolean checkBall(Integer index,Integer userIndexInteger,List<Integer> answer){
        for(int i=0;i<answer.size();i++){
            if(i!=index && answer.get(i)==userIndexInteger) {
                return true;
            }
        }
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
