package baseball.domain;

public class RetryNum {
    private String retryNum;

    public String getRetryNum(){
        return retryNum;
    }

    public RetryNum(String retryNum) {
        retryNumCheck(retryNum);
        this.retryNum = retryNum;
    }

    public static void retryNumCheck(String num) throws IllegalArgumentException {
        if(!num.equals("1") && !num.equals("2")){
            throw new IllegalArgumentException("잘못된 값 입력.");
        }
    }
}