package baseball.service;

import baseball.domain.HintType;
import baseball.dto.HintDto;

import java.util.List;
import java.util.Map;

public class Service {
    public HintDto getHintDto(Map<HintType, Integer> hintMap, int size) {
        if (!hintMap.get(HintType.NOTHING).equals(size)) {
            hintMap.remove(HintType.NOTHING);
        }
        removeIfZero(hintMap);

        return new HintDto(hintMap);
    }

    private void removeIfZero(Map<HintType, Integer> hintMap) {
        List<HintType> removes = hintMap.keySet().stream()
                .filter(type -> hintMap.get(type) == 0)
                .toList();

        removes.forEach(hintMap::remove);
    }
}
