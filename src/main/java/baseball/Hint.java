package baseball;

public class Hint{
    int ball,strike;
    private void StrikeCount(){
        this.strike++;
    }
    private void BallCount(){
        this.ball++;
    }
    void Compare(Game answer, Game target){
        int tmp;
        for (int i=0; i<3; i++){
            tmp = answer.Answer[i];
            if(!Check.RepeatNumber(target.Answer, tmp)){
                continue;
            }
            if (i == Hint.Location(target.Answer,tmp)){
                StrikeCount();
                continue;
            }
            BallCount();
        }
    }

    void PrintResult(){
        String result = "";
        if (this.ball != 0){
            result += this.ball + "볼 ";
        }
        if (this.strike != 0){
            result += this.strike + "스트라이크";
        }
        if (result.equals("")){
            result = "낫싱";
        }
        System.out.println(result);
    }

    static int Location(final int[] arr, final int num){
        for (int i=0; i<3; i++){
            if (arr[i]==num) return i;
        }
        return -1;
    }
}
