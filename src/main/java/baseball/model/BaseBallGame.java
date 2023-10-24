package baseball.model;

import java.util.List;
import java.util.Objects;

public class BaseBallGame {
    public int[] ismatch(List<Integer> computerNum, List<Integer> userNum) {
        int[] resultList = new int[3];
        int strikeCount = 0;
        int ballCount = 0;
        int nothingCount = 0;

        for (int index = 0 ; index<3 ; index++) {
            if (Objects.equals(computerNum.get(index), userNum.get(index))) {
                strikeCount +=1;
            } else if (computerNum.contains(userNum.get(index))) {
                ballCount +=1;
            }
        }
        if (strikeCount+ballCount ==0 ){
            nothingCount+=1;
        }
        resultList[0] = ballCount;
        resultList[1] = strikeCount;
        resultList[2] = nothingCount;

        return resultList;
    }





}
