package baseball.service.impl;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.UserCode;
import baseball.service.UserCodeService;
import java.util.Arrays;
import java.util.List;

public class UserCodeServiceImpl implements UserCodeService {
    @Override
    public UserCode makeUserCode(UserCode userCode) {
        List<Integer> codes = Arrays.stream(readLine().split("")).map(Integer::parseInt).toList();
        return userCode.makeNewUserCode(codes);
    }
}
