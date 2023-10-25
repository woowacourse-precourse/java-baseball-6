package baseball.service;
import java.util.List;

public class GameResultReturnService {

    public GameResultReturnService(){}

    //스트라이크, 볼 갯수 확인
    public List<Integer> strikeBallCheck(List<Integer> userNum, List<Integer> computerNum){
        Integer strike = 0;
        Integer ball = 0;

        //스트라이크면 continue 아니면 ball 확인, 둘다 아닌 경우 무시하고 넘어감
        for (int i = 0; i < 3; i ++) {
            if (userNum.get(i) == computerNum.get(i)){
                strike += 1;
                continue;
            }
            if(computerNum.contains(userNum.get(i))) ball += 1;
        }
        //스트라이크 개수와 볼 개수를 반환
        return List.of(strike,ball);
    }



    //스트라이크, 볼 갯수로 결과값 반환
    public String gameResult(List<Integer> userNum, List<Integer> computerNum){
        List<Integer> gameResult = strikeBallCheck(userNum, computerNum);

        //볼, 스트라이크 결과값 작성 ex)1볼 2스트라이크
        String result = (gameResult.get(1) != 0 ? gameResult.get(1) + "볼 " : "") +
                        (gameResult.get(0) != 0 ? gameResult.get(0) + "스트라이크" : "");

        //빈 문자열이면 낫싱
        if (result.equals("")) return "낫싱";

        return result;
    }

}
