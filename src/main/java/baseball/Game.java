package baseball;

public class Game {
    private enum Status{
        START, PROGRESS, FINISH, TERMINATED
    }
    private Status status;

    public void init(){
        this.status = Status.START;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(status != Status.TERMINATED){
            switch (status) {
                case START -> start();
                case PROGRESS -> progress();
                case FINISH -> finish();
            }
        }
    }

    private void start(){

    }
    private void progress(){

    }
    private void finish(){

    }
    private void terminate(){
        this.status = Status.TERMINATED;
    }

}
