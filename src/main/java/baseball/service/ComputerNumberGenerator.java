package baseball.service;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberGenerator {

    private static final Integer NUMBER_LENGTH = 3;
    private static ComputerNumberGenerator instance = new ComputerNumberGenerator();

    private ComputerNumberGenerator() {

    }

    public static ComputerNumberGenerator getInstance(){
        return instance;
    }

    public String generate(){
        StringBuilder comNumberBuilder = new StringBuilder();
        for(int i =0; i<NUMBER_LENGTH; i++){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            comNumberBuilder.append(randomNumber);
        }
        return comNumberBuilder.toString();
    }



}
