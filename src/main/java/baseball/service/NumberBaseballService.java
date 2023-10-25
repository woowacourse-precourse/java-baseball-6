package baseball.service;

import baseball.constant.Constant;
import baseball.dto.ResultDTO;
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

    /**
     * 사용자가 입력한 수와 정답을 비교하여 그 결과를 반환하는 함수
     *
     * @param computerNumbers : 컴퓨터가 정답으로 가지고 있는 랜덤 수
     * @param inputNumbers    : 사용자가 입력한 수
     * @return :Strike, Ball 결과를 담은 객체를 DTO로 반환
     */
    public ResultDTO calculateResult(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0, ballCount = 0;
        for (int i = 0; i < Constant.GAME_NUMBERS_SIZE; ++i) {
            if (computerNumbers.contains(inputNumbers.get(i)) && (computerNumbers.get(i) == inputNumbers.get(i))) {
                ++strikeCount;
            }
            if (computerNumbers.contains(inputNumbers.get(i)) && (computerNumbers.get(i) != inputNumbers.get(i))) {
                ++ballCount;
            }
        }
        return new ResultDTO(strikeCount, ballCount);
    }
}
