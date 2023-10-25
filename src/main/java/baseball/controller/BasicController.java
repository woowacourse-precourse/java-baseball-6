package baseball.controller;

import static baseball.CONSTANT.GAME_SIZE;

import baseball.dto.GameResultDTO;
import baseball.service.CheckService;
import baseball.view.ProcessView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BasicController {
    private List<Integer> computerNumber;

    public void createComputerNumber() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < GAME_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

    }

    public Boolean checkNumber(String userInput) {
        // String -> Integer
        List<Integer> userNum = makeIntegerArray(userInput);

        // service -> 1 0 0 과 같은 정보 리턴
        GameResultDTO gameResult = CheckService.matchNumber(userNum, computerNumber);

        // view -> 해당 결과 출력 요청
        ProcessView.printResult(gameResult);

        // 성공시 true, 아니면 false 반환
        if (gameResult.getSuccess() == true) {
            return true;
        }

        return false;

    }

    private List<Integer> makeIntegerArray(String userInput) {
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE; i++) {
            userNum.add(userInput.charAt(i) - '0');
        }
        return userNum;
    }
}
