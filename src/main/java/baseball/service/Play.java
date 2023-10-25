package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.UserRequestDto;
import java.util.List;

/**
 * 4. playBaseballGame() : 야구 게임 로직 (볼, 스트라이크, 낫싱)
 */
public class Play {
    public User playBaseBallGame(Computer computer, UserRequestDto userRequestDto) {
        int strike = 0;
        int ball = 0;
        List<Integer> computerValue = computer.getComputerValue();
        for (int i = 0; i < computerValue.size(); i++) {
            if (userRequestDto.getUserValue().contains(computerValue.get(i))) {
                if (userRequestDto.getUserValue().indexOf(computerValue.get(i)) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        userRequestDto.setStrike(strike);
        userRequestDto.setBall(ball);

        User user = User.createUser(userRequestDto);
        return user;
    }
}
