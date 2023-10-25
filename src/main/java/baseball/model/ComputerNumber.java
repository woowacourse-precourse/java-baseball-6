package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumber {
    private static final int length = 3;
    private static final int startNum = 1;
    private static final int endNum = 9;
    private List<Integer> computerNum = new ArrayList<>();
    public ComputerNumber(){
        createRandomNum();
    }
    private void createRandomNum(){
        List<Integer> computerRandomNums = new ArrayList<>();

        while(computerRandomNums.size()<length){
            int randomNumber = Randoms.pickNumberInRange(startNum,endNum);
            if(!computerRandomNums.contains(randomNumber)){
                computerRandomNums.add(randomNumber);
            }
        }
        this.computerNum = computerRandomNums;
    }
    public List<Integer> getComputerNumber(){
        return computerNum;
    }
}
