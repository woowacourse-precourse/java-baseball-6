package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    Validation validation = new Validation();


    public List<Integer> playerInput(int dataType) {
        String[] player = readLine().split("");
        validation.runValidation(player, dataType);
        return convertIntoList(player);
    }

    // 인풋 값을 List<Integer> 로 변환합니다.
    private List<Integer> convertIntoList(String[] target) {
        List<Integer> convertedData = new ArrayList<>();
        //검증 후 입력값 파싱하기
        for (String str: target) {
            convertedData.add(Integer.valueOf(str));
        }
        return convertedData;
    }
}
