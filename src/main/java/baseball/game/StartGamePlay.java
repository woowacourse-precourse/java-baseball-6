package baseball.game;

import baseball.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class StartGamePlay implements GamePlay {
    @Override
    public String play(List<String> args) {
        Computer.number = "";

        for (int i = 0; i < 3; ++i) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (Computer.number.contains("" + randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            Computer.number += randomNumber;
        }

        return "숫자 야구 게임을 시작합니다.";
    }
}
