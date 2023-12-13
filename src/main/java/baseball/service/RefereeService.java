package baseball.service;

import baseball.dto.ResultDto;
import java.util.List;

public class RefereeService {

    public static ResultDto compareNumbers(List<Integer> user, List<Integer> com) {
        int strike = 0, ball = 0;
        for (int i = 0; i < user.size(); i++) {
            int userNum = user.get(i);
            int comNum = com.get(i);
            if (userNum == comNum) {
                strike++;
                continue;
            }
            if (com.contains(userNum)) {
                ball++;
            }
        }
        return new ResultDto(strike, ball);
    }
}
