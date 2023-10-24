package baseball.Controller;


import baseball.Model.Score;

public class CheckNumberController {
    static final int NUMOFDIGIT = 3;

    static Score score = new Score();
    public static void countBall(Integer[] userNumbers, Integer[] randomNumbers){
        int ball=0;
        for (int i=0;i<NUMOFDIGIT;i++){
            if(isBall(userNumbers, randomNumbers,i))
                ball++;
        }
        score.setBalls(ball);
    }
    public static void countStrike(Integer[] userNumbers, Integer[] randomNumbers){
        int strike=0;
        for(int i=0; i<NUMOFDIGIT;i++){
            if(userNumbers[i]==randomNumbers[i])
                strike++;
        }
        score.setStrikes(strike);

    }
    public static boolean isBall(Integer[] userNumbers, Integer[] randomNumbers,int index){
        for (int j=0;j<NUMOFDIGIT;j++){
            if(userNumbers[index]==randomNumbers[j])
                return isStrikeForBall(j, index);
        }
        return false;
    }
    public static boolean isStrikeForBall(int randomNumberIndex, int userNumberIndex){
        if(userNumberIndex==randomNumberIndex) return false;
        else return true;
    }
    public boolean isCorrected() {
        int ball = score.getBalls();
        int strike = score.getStrikes();
        //검사 결과 출력
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.print(strike + "스트라이크 ");
        if (strike >= 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (ball <= 0 && strike <= 0) {
            System.out.println("낫싱");
            return false;
        }
        return false;
    }
}
