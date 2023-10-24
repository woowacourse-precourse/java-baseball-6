package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.item.HintItem;
import baseball.service.hint.item.HintItemService;
import java.util.ArrayList;
import java.util.List;

public class HintServiceImpl implements HintService {

    //★DB를 사용하는 구조라면 Repository에 의존하면 되지만 여기서는 그렇지 않으므로 Service에 의존
    private List<HintItemService> hintItemServices;

    public HintServiceImpl(HintItemService... hintItemServices) {
        this.hintItemServices = List.of(hintItemServices);
    }

    @Override
    public Hint createHint(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        List<HintItem> hintItems = new ArrayList<>();

        for (HintItemService hintItemServiceImpl : hintItemServices) {
            HintItem hintItem = hintItemServiceImpl.create(computerBaseball, inputBaseball);
            if (hintItemServiceImpl.isActive(hintItem)) {
                hintItems.add(hintItem);
            }
        }
        return Hint.createHint(hintItems);
    }

    @Override
    public List<String> counts(Hint hint) {
        return hint.getCounts();
    }

    @Override
    public List<String> names(Hint hint) {
        return hint.getNames();
    }
}
