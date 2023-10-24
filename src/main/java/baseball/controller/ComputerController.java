package baseball.controller;

import baseball.domain.Computer;
import baseball.validation.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerController {
    private Computer computer;
    private NumberValidator numberValidator;

    public ComputerController() {
        this.computer = Computer.getInstance();
        this.numberValidator = new NumberValidator();
    }
    public void setGameClearNumber(){
        List<Integer> computerList = new ArrayList<>();
        while (computerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : computerList) {
            stringBuilder.append(num);
        }
        numberValidator.isValidNumber(stringBuilder.toString());
        computer.setComputerNumber(stringBuilder.toString());
    }
}
