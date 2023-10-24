package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.GameConstants;
import baseball.domain.hint.Ball;
import baseball.domain.hint.HintItem;
import baseball.domain.hint.Nothing;
import baseball.util.ObjectUtil;

import java.util.List;

public class NothingHintServiceImpl implements HintItemService {

    private static final NothingHintServiceImpl nothingService = new NothingHintServiceImpl();

    public static NothingHintServiceImpl getInstance() {
        return nothingService;
    }

    private NothingHintServiceImpl() {

    }

    @Override
    public HintItem create(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        int count = count(computerBaseball, inputBaseball);
        HintItem nothing = new Nothing(count);

        return nothing;
    }

    public int count(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        int count = 0;
        List computer = computerBaseball.getValues();
        List input = inputBaseball.getValues();

        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            for (int j = 0; j < GameConstants.NUMBER_LENGTH; j++) {
                if (ObjectUtil.isSame(computer.get(i), input.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public boolean isActive(HintItem hintItem) {
        return hintItem.isActive();
    }
}

