package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String commonFromInput() {
        return Console.readLine();
    }

    public String racingCarName(String carName) {
        return String.join(",", carName);
    }
}
