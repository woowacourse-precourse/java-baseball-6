package baseball;

public class ReturnCount {
    CompareNumber compareNumber = new CompareNumber();

    public String count(int[] inputArr, int[] randomArr){
        int ball = compareNumber.getBall(inputArr,randomArr);
        int strike = compareNumber.getStrike(inputArr,randomArr);
        int realBall = ball-strike;

        if(ball == 0){
            return "낫싱";
        } else if (strike == 0){
            return realBall+"볼";
        } else if (realBall == 0){
            return strike+"스트라이크";
        } else {
            return strike+"스트라이크 " + realBall+"볼";
        }
    }
}
