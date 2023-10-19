package baseball.model;

public class CompareNumber {
    private int strikes = 0;
    private int balls = 0;


    /**
     * 스트라이크 개수 체크
     */
    public void checkStrike(String userNumber, String programNumber){
        for (int i = 0; i < userNumber.length(); i++){
            if(userNumber.charAt(i) == programNumber.charAt(i)){
                strikes++;
            }
        }
    }

}
