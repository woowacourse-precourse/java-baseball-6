package baseball.domain.dto;

import baseball.domain.model.Score;

import java.util.Map;

public class ResultDto {
    private final Map<String, Integer> result;
    private final Boolean isThreeStrike;

    public ResultDto(Map<String, Integer> result, Boolean isThreeStrike) {
        this.result = result;
        this.isThreeStrike = isThreeStrike;
    }

    private Map<String, Integer> getResult(Score score) {
        return score.getResult();
    }

    private Boolean checkIsThreeStrike(Score score) {
        return score.isThreeStrike();
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public Boolean getThreeStrike() {
        return isThreeStrike;
    }

}
