package baseball;

public class Game {
    private enum Status{
        START, PROGRESS, FINISH, TERMINATED
    }
    private Status status;

    public Status getStatus(){
        return status;
    }

}
