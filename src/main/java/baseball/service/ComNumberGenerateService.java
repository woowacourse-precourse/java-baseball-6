package baseball.service;

import baseball.model.ComNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComNumberGenerateService {
    public List<Integer> generateComNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            addRandomNumber(number);
        }
        return new ComNumber(number).getNumber();
    }

    private void addRandomNumber(List<Integer> computerNumber) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) computerNumber.add(randomNumber);
    }

}
