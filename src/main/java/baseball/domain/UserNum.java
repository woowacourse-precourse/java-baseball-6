package baseball.domain;

import baseball.util.ConvertUtil;
import java.util.List;

public class UserNum {

    public List<Integer> buildUserNum(String input) {
        return ConvertUtil.convertStrToIntList(input);
    }

}
