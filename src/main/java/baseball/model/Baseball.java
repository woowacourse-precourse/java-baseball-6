package baseball.model;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constants.*;

public class Baseball implements Game{

    private final List<Integer> computer;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private Boolean status;

    public Baseball(InputHandler inputHandler) {
        computer = new ArrayList<>();
        this.inputHandler = inputHandler;
        outputHandler = new OutputHandler();
        initGame();
    }

    @Override
    public void initGame() {
        status = true;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    @Override
    public void playGame() {
        // 반복문을 통해 예측 값을 입력받고 그 값을 정답과 비교해 결과(ScoreBoard)를 입력받는다.
        while(status){
            System.out.print(INPUT_PREDICTED_MESSAGE);
            int input = inputHandler.scanInteger();
            List<Integer> expectedNums = inputHandler.inputToExpectedNumber(input);
            ResultScoreBoard resultScoreBoard = compareExpect(expectedNums);
            outputHandler.printScore(resultScoreBoard);
            if(resultScoreBoard.strike() == 3) {
                System.out.println(GAME_STOP_MESSAGE);
                status = false;
            }
        }
    }

    private ResultScoreBoard compareExpect(List<Integer> expectedNums) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < INPUT_MAX_SIZE; i++) {
            // 값이 있으면 일단 ball
            if(computer.contains(expectedNums.get(i))) ball++;
            // 값이 자리까지 같으면 ball->strike
            if(computer.get(i) == expectedNums.get(i)) {
                strike++;
                ball--;
            }
        }
        return new ResultScoreBoard(strike, ball);
    }
}
