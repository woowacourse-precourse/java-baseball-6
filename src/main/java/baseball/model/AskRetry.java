package baseball.model;

public class AskRetry {
    private String retryNum;

    // 생성자
    public AskRetry(String retryNum) {
        isCorrectNumber(retryNum);
        this.retryNum = retryNum;
    }

    // getRetryNum() 함수 호출 시 retryNum 반환
    public String getRetryNum(){
        return retryNum;
    }

    public static void isCorrectNumber(String number) throws IllegalArgumentException{
        if(!number.equals("1") && !number.equals("2")){
            throw new IllegalArgumentException("1 또는 2의 숫자만 입력해주세요.");
        }
    }
}
