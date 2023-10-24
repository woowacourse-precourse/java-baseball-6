package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Computer {

    public final int DIGIT = 3;
    List<Integer> computer;

    Computer(){

        setRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    private void setRandomNumber(){
        computer = new ArrayList<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println("* "+computer.toString());
    }

    public boolean getResult(int playerNum){

        int strikeCount = 0;
        int ballCount = 0;
        for(int i=computer.size()-1; i>=0; i--){
            //System.out.println("* "+computer.get(i)+" vs "+playerNum%10);
            //같은 자리의 숫자가 같으면 strike
            if(computer.get(i) == playerNum%10)
                strikeCount++;
            //랜덤숫자 중 하나이지만 자리가 같지 않으면 ball
            if(computer.get(i) != playerNum%10 && computer.contains(playerNum%10))
                ballCount++;

            playerNum/=10;
        }
        //System.out.println("*볼: "+ballCount);
        //System.out.println("*스트라이크: "+strikeCount);

        printResult(strikeCount, ballCount);

        return strikeCount == DIGIT;
    }

    private void printResult(int strikeCount, int ballCount){
        if (strikeCount==0 && ballCount==0) {
            System.out.println("낫싱");
        }
        if(ballCount!=0) {
            System.out.print(ballCount + "볼 ");
        }
        if(strikeCount!=0){
            System.out.print(strikeCount+"스트라이크");
        }
        System.out.println(" ");
    }
    public boolean reset(){
        setRandomNumber();
        return true;
    }
}
