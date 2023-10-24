package baseball.game.model;

import baseball.game.Validator;

public class Restart {
    boolean isRestart;

    private Restart(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public boolean isRestart() {
        return isRestart;
    }

    public static Restart of(String str){
        int num = Integer.parseInt(str);
        Validator.validRestartNum(num);
        if(num == 1){
            return new Restart(true);
        }
        return new Restart(false);
    }
}
