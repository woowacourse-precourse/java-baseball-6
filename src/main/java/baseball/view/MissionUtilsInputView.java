package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MissionUtilsInputView implements Input {

    @Override
    public String read() {
        return readLine();
    }

}
