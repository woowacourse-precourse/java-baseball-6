package baseball.model;

public class Status{
    private static final String INPUT_ERROR_MESSAGE = "1과 2 중 하나를 입력해주세요";
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private static final boolean GO = true;
    private static final boolean STOP = false;
    private boolean status = true;


    public void setStatus(int userChoice) {
        if (userChoice == RESTART_GAME) {
            status = GO;
            return ;
        }
        if (userChoice == END_GAME) {
            status = STOP;
            return ;
        }
        throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }

    public void resetStatus(){
        this.status = GO;
    }

    public boolean isOngoing() {
        return status == GO;
    }
}
