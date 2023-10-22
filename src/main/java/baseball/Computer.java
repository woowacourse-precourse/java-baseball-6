package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Computer {

    public final int DIGIT = 3;
    List<Integer> computer = new ArrayList<>();

    Computer(){

        setRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    private void setRandomNumber(){
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean getResult(int playerNum){

        int strikeCount = strikeCounter(playerNum);
        int ballCount = ballCounter(playerNum);

        printResult(strikeCount, ballCount);

        return strikeCount == DIGIT;
    }

    private int strikeCounter(int playerNum){

        int strikeCount= 0;
        for(int i=computer.size()-1; i>=0; i--){
            if(computer.get(i) == playerNum/10)
                strikeCount++;
            playerNum/=10;
        }
        return strikeCount;
    }

    private int ballCounter(int playerNum) {
        int ballCount = 0;
        for(int i=0; i<computer.size(); i++){
            if( computer.contains(playerNum/10))
                ballCount++;
            playerNum/=10;
        }
        return ballCount;
    }

    private void printResult(int strikeCount, int ballCount){
        if (ballCount!=0)
            System.out.print(ballCount-strikeCount+"볼 ");

        System.out.print(strikeCount+"스트라이크");
    }
}
