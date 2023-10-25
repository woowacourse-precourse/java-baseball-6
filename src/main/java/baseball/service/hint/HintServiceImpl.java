package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.item.HintItem;
import baseball.service.hint.item.HintItemService;
import java.util.ArrayList;
import java.util.List;

public class HintServiceImpl implements HintService {

    private List<HintItemService> hintItemServices;

    public HintServiceImpl(HintItemService... hintItemServices) {
        this.hintItemServices = List.of(hintItemServices);
    }

    @Override
    public Hint createHint(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        List<HintItem> hintItems =  createActiveHintItems(computerBaseball, inputBaseball);
        return Hint.createHint(hintItems);
    }

    @Override
    public List<HintItem> createActiveHintItems(NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        List<HintItem> hintItems = new ArrayList<>();
        for (HintItemService hintItemServiceImpl : hintItemServices) {
            HintItem hintItem = hintItemServiceImpl.create(computerBaseball, inputBaseball);
            if (hintItemServiceImpl.isActive(hintItem)) {
                hintItems.add(hintItem);
            }
        }
        return hintItems;
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
