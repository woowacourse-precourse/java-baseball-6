package baseball.model;

public class RestartNum {
    private String restartNum;

    public String getRestartNum() {
        return restartNum;
    }

    public RestartNum(String restartNum) {
        equalsRestartNum(restartNum);
        this.restartNum = restartNum;
    }

    public static void equalsRestartNum(String num){
        if (!num.equals("1") && !num.equals("2")) {
            throw new IllegalArgumentException("1 과 2 둘 중에 하나만 선택");
        }
    }
}
