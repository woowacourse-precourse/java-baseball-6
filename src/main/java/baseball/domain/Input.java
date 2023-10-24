package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {

    Validation validation = new Validation();


    public List<Integer> playerInput(int dataType) {
        char[] player = readLine().toCharArray();
        validation.runValidation(player, dataType);
        return convertIntoList(player);
    }

    // 인풋 값을 List<Integer> 로 변환합니다.
    private List<Integer> convertIntoList(char[] target) {
        List<Integer> convertedData = new ArrayList<>();

        for (char chr : target) {
            convertedData.add(chr - '0');
        }
        return convertedData;
    }
}