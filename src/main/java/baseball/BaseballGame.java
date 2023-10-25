package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame{
    private List<Integer> computer;

    public BaseballGame(){
        computer = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public boolean isCorrectAnswer(List<Integer> user){
        // 힌트 출력
        int strike=0;
        int ball=0;
        for(int i=0;i<3;i++){
            if(Objects.equals(user.get(i), computer.get(i))){
                strike+=1;
            }
            else if(computer.contains(user.get(i))) {
                ball += 1;
            }
        }

        printHint(strike, ball);

        return strike==3;
    }

    private static void printHint(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike!=0 && ball==0){
            System.out.println(strike+"스트라이크");
        }
        if(strike==0 && ball!=0){
            System.out.println(ball+"볼");
        }
        if(strike!=0 && ball!=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}