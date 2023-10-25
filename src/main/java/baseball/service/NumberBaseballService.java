package baseball.service;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {

    /**
     * 한 사이클의 숫자야구게임에서 정답으로 사용될 랜덤 숫자 List 생성
     *
     * @return : 숫자야구게임 정답으로 사용될 랜덤 숫자 List Collection 반환
     */
    public List<Integer> generateGameNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.START_RANGE, Constant.END_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
