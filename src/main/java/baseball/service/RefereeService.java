package baseball.service;

import baseball.domain.HintType;
import baseball.dto.HintDto;

import java.util.Map;

public class RefereeService {
    public HintDto getHintDto(Map<HintType, Integer> hintMap, int size) {
        if (hintMap.get(HintType.NOTHING).equals(size)) {
            hasOnlyNOTHING(hintMap);
            return new HintDto(hintMap);
        }
        hintMap.remove(HintType.NOTHING);

        return new HintDto(hintMap);
    }

    private void hasOnlyNOTHING(Map<HintType, Integer> hintMap) {
        hintMap.remove(HintType.STRIKE);
        hintMap.remove(HintType.BALL);
        hintMap.put(HintType.NOTHING, 1);
    }
}
