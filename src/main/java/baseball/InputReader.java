package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    // 유저가 추측한 값을 입력 받고 List 형태로 반환
    public List<Integer> readUserGuessNumber() {
        String guessedNumberString = Console.readLine();
        List<Integer> guessedNumber = Arrays.stream(guessedNumberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return guessedNumber;
    }

    // 게임 Continue 여부를 입력받고 반환
    public Integer readContinueMode() {
        String continueModeNumberString = Console.readLine();
        int continueModeNumber = Integer.parseInt(continueModeNumberString);
        return continueModeNumber;
    }
}
