package baseball.model;

public class RestartNumber {
    private String restartNumber;

    public String getRestartNumber(){
        return restartNumber;
    }
    public RestartNumber(String restartNumber){
        validateRestart(restartNumber);
        this.restartNumber = restartNumber;
    }
    public void validateRestart(String number){
        if(!number.equals("1")&&!number.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
