package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {


    private List<Integer> computerNumbers = new ArrayList<>();

    public Computer(){
        if (!computerNumbers.isEmpty()){
            computerNumbers.clear();
        }
        generateComputerNumbers();
    }

    /**
     * 컴퓨터의 숫자를 생성해줍니다.
     *
     * 해당 작업은 3개의 숫자가 중복없이 들어갈때까지 반복하여 작업합니다.
     * */
    public void generateComputerNumbers(){

        while (computerNumbers.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNum)){
                computerNumbers.add(randomNum);
            }
        }
    }

    public List<Integer> getComputerNumbers(){
        return this.computerNumbers;
    }

    public void clean(){
        this.computerNumbers.clear();
    }

}
