package baseball.controller;

import baseball.domain.BallNumbers;
import baseball.domain.dto.RestartDTO;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.MessageConst.NUMBER_INPUT_FORMAT_EXCEPTION;

public class InputFormatter {
    private final InputView inputView;

    public InputFormatter(InputView inputView) {
        this.inputView = inputView;
    }

    public BallNumbers createUserBallNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String ballNumbersStr = inputView.readLine();
        validateNumber(ballNumbersStr);
        String[] splitNumberStr = ballNumbersStr
                .split("");
        for (String numStr : splitNumberStr) {
            userNumbers.add(Integer.parseInt(numStr));
        }
        return BallNumbers.from(userNumbers);
    }

    private void validateNumber(String ballNumbersStr) {
        for (int i = 0; i < ballNumbersStr.length(); i++) {
            if (!Character.isDigit(ballNumbersStr.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_INPUT_FORMAT_EXCEPTION);
            }
        }
    }

    public boolean wantRestart() {
        String userChoice = inputView.readLine();
        RestartDTO restartDTO = new RestartDTO(userChoice);
        return restartDTO.wantRestart();
    }
}

