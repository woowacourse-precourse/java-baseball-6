package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    // 유저가 추측한 값을 입력 받고 List 형태로 반환
    public List<Integer> readUserGuessNumber() {
        String guessString = Console.readLine();
        List<Integer> guess = Arrays.stream(guessString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return guess;
    }

    // 게임 Continue 여부를 입력받고 반환
    public Integer readContinueMode() {
        String continueString = Console.readLine();
        int continueMode = Integer.parseInt(continueString);
        return continueMode;
    }
}
