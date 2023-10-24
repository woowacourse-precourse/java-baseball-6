package baseball.game.model;

import baseball.game.Validator;

public class RestartState {
    boolean isRestart;

    private RestartState(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public boolean isRestart() {
        return isRestart;
    }

    public static RestartState of(String str){
        int num = Integer.parseInt(str);
        Validator.validRestartNum(num);
        if(num == 1){
            return new RestartState(true);
        }
        return new RestartState(false);
    }
}
