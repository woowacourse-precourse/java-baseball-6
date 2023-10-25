package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
public class ComputerNum {
    public List<Integer> ComputerNumber(){
        List<Integer> com_num = new ArrayList<>();
        while (com_num.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!com_num.contains(randomNumber)){
                com_num.add(randomNumber);
            }
        }
        return com_num;
    }
}
