package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.GameConstants;
import baseball.domain.hint.Strike;
import baseball.util.ObjectUtil;

import java.util.List;

public class StrikeService implements HintItemService<Strike> {

    private static final StrikeService strikeService = new StrikeService();

    public static StrikeService getInstance(){
        return strikeService;
    }

    private StrikeService() {

    }

    public int count(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        int count = 0;
        List computer = computerBaseball.getValues();
        List input = inputBaseball.getValues();

        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            if (ObjectUtil.isSame(computer.get(i), input.get(i))) {
                count++;
            }
        }

        return count;
    }

    public boolean active(Strike strike) {
        if (strike.getCount() > 0 ) {
            return true;
        } return false;
    }

}
