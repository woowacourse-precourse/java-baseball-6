package baseball.controller;

import static baseball.CONSTANT.GAME_SIZE;

import baseball.domain.Computer;
import baseball.dto.GameResultDTO;
import baseball.view.ProcessView;
import java.util.ArrayList;
import java.util.List;

public class BasicController {
    Computer computer;

    public void createComputerNumber() {
        if (computer == null) {
            computer = new Computer();
        }
        computer.createRandomNumber();
    }

    public Boolean checkNumber(String userInput) {
        // String -> Integer
        List<Integer> userNum = makeIntegerArray(userInput);

        // service -> 1 0 0 과 같은 정보 리턴
        GameResultDTO gameResult = computer.compareNumber(userNum);

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
