package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    public List<Integer> ComputerNumbersList() {

        List<Integer> com_num_List = new ArrayList<>();
        while (com_num_List.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!com_num_List.contains(randomNumber)) {
                com_num_List.add(randomNumber);
            }
        }
        return com_num_List;
    }
}
