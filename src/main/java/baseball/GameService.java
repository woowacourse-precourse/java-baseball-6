package baseball;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class GameService {

    private final CodeRepository codeRepository;

    public GameService(final CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Long createComputerCode() {
        List<Integer> randomCode = new ArrayList<>();
        while (randomCode.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomCode.contains(randomNumber)) {
                randomCode.add(randomNumber);
            }
        }
        return codeRepository.save(randomCode);
    }

    public Map<Grade, Integer> guessCode(final List<Integer> inputCode, final Long computerCodeId) {
        List<Integer> computerCode = codeRepository.findById(computerCodeId).getNumber();
        Map<Grade, Integer> response = new EnumMap<>(Grade.class);
        response.put(Grade.STRIKE, 0);
        response.put(Grade.BALL, 0);
        for(int i = 0; i < 3; i++) {
            if(computerCode.get(i) == inputCode.get(i)) {
                response.compute(Grade.STRIKE, (key, value) -> value + 1);
            }
            else if(computerCode.contains(inputCode.get(i))) {
                response.compute(Grade.BALL, (key, value) -> value + 1);
            }
        }
        return response;
    }

    public boolean determinePass(final Map<Grade, Integer> result) {
        if(result.get(Grade.STRIKE) == 3) {
            return true;
        }
        return false;
    }

    public boolean determineRestarting(final Integer command) {
        if(command == 1) {
            return true;
        }
        return false;
    }

    public void removeComputerCode(final Long computerCodeId) {
        codeRepository.delete(computerCodeId);
    }
}
