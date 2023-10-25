package baseball;
public class CompareNums{
    ComputerNums questionNums = new ComputerNums();
    public boolean checkNumInBucket(int userNum){
        int n = userNum;
        for(int i = 0; i<questionNums.computerNumsLength(); i++){
            if(questionNums.getComputerNumsBucket(n%10)) return true;
            n /= 10;
        }
        return false;
    }

    public int[] compareNums(int userNum){
        int[] ballStrikeResult = {0, 0};
        int n = userNum;
        for(int i = questionNums.computerNumsLength()-1; i >= 0; i--){
            if(n%10 == questionNums.getComputerNums(i)) ballStrikeResult[1]++;
            else{
                if(questionNums.getComputerNumsBucket(n%10)) ballStrikeResult[0]++;
            }
            n/=10;
        }
        return ballStrikeResult;
    }
}