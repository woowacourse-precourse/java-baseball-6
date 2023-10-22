package baseball;

public class Game {
    private enum Status{
        PROGRESS, FINISH
    }
    private Status status;

    public Status getStatus(){
        return status;
    }

}
