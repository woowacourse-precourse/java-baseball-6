package baseball.service.impl;

import baseball.service.BaseballRandomCodeService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballRandomCodeServiceImpl implements BaseballRandomCodeService {

    @Override
    public List<Integer> makeRandomCodeList() {
        List<Integer> codes = new ArrayList<>();
        while (codes.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!codes.contains(randomNumber)) {
                codes.add(randomNumber);
            }
        }
        return codes;
    }
}
