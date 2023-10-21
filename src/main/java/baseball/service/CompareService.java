package baseball.service;

import baseball.dto.NumDto;
import baseball.dto.StrikeBallDto;

import java.util.List;

public class CompareService {

    public StrikeBallDto calSB(String readStr, NumDto computerNum) {

        int strikeNum = 0;
        int ballNum = 0;
        List<Integer> comNum = computerNum.numList();

        for (int i=0; i<comNum.size(); i++) {
            int intNum = readStr.charAt(i) - '0';

            if (intNum == comNum.get(i)) {
                strikeNum++;
            } else if (comNum.contains(intNum)) {
                ballNum++;
            }

        }

        return new StrikeBallDto(strikeNum, ballNum);
    }
}
