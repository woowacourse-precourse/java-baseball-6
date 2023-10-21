package baseball.service;

import baseball.model.Command;

public class RestartService {

    public Boolean isRestart(Command command) {
        if (Command.RESTART.equals(command)) {
            return true;
        }
        if (Command.QUIT.equals(command)) {
            return false;
        }
        return null;
    }

}
