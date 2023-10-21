package baseball.dto;

import baseball.domain.HintType;

import java.util.Map;

public final class HintDto {
    private final Map<HintType, Integer> hint;

    public HintDto(Map<HintType, Integer> hint) {
        this.hint = hint;
    }

    public Map<HintType, Integer> getHint() {
        return hint;
    }
}
