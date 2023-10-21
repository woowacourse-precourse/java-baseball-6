package baseball;

/**
 * 나는 숫자를 전달해주면
 * 숫자를 비교하고 결과값을 출력해줄게
 *
 */
public class NumberCompare {
    private static final int CHANCE = 3;
    private int ball;
    private int strike;



    public int[] Compare(String userNumber, String computerNumber){
        System.out.println(userNumber + " " + computerNumber);
        CountStrike(userNumber,computerNumber);
        CountBall(userNumber, computerNumber);
        return new int[] {ball,strike};
    }


    public void CountBall(String userNumber, String computerNumber){
        for(int i = 0; i < CHANCE; i++){
            if(computerNumber.contains(Character.toString(userNumber.charAt(i)))){
                ball++;
            }
        }
        ball = ball - strike;
    }

    public void CountStrike(String userNumber, String computerNumber){
        for(int i = 0; i < CHANCE; i++){
            if(computerNumber.charAt(i) == userNumber.charAt(i)){
                strike++;
            }
        }
    }
}