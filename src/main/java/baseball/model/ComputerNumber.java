package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumber {

    public String computerNumber;

    public ComputerNumber(){
        setGameclearNumber();
    }

    public String getComputerNumber(){
        return computerNumber;
    }

    public void setGameclearNumber(){
        Set<String> computerNumberMaker = new HashSet<>();
        while(computerNumberMaker.size()<3){
            computerNumberMaker.add(getRandomNumber());
        }
        this.computerNumber = String.join("",computerNumberMaker);
    }

    public static String getRandomNumber(){
        return Integer.toString(Randoms.pickNumberInRange(1,9));
    }



}
