package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.GameConstants;
import baseball.domain.hint.Ball;
import baseball.domain.hint.HintItem;
import baseball.domain.hint.Strike;
import baseball.util.ObjectUtil;

import java.util.List;

public class StrikeHintServiceImpl implements HintItemService {

    private static final StrikeHintServiceImpl strikeService = new StrikeHintServiceImpl();

    public static StrikeHintServiceImpl getInstance(){
        return strikeService;
    }

    private StrikeHintServiceImpl() {

    }

    @Override
    public HintItem create(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        int count = count(computerBaseball, inputBaseball);
        HintItem strike = new Strike(count);

        return strike;
    }

    @Override
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

    @Override
    public boolean isActive(HintItem hintItem) {
        return hintItem.isActive();
    }
}
