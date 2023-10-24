package baseball;

import baseball.validation.ValidGameContinueMode;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameContinueSelector {
    public void gameContinueSelect() {
        String gameContinueSelection = readLine();
        try {
            new ValidGameContinueMode().validateInputOfGameContinueSelection(gameContinueSelection);
        }
        catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
        if (gameContinueSelection.equals("1")) {
            new Baseball().play();
        }
    }
}
