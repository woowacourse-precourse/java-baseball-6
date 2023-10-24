package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class BaseballService {

    public List<Integer> generateAnswer() {
       return GenerateRandomNum.generate();
    }
    public List<Integer> stringToList(String str) {
        List<Integer> list = new ArrayList<>();
        for(String s : str.split("")) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }
}
