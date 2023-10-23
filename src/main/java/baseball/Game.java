package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    int[] comArr;
    int[] userArr;
    int s,b;

    //패 일치여부 확인
    private boolean syncronize(int[] comArr,int[] userArr){
        //TO Do : userArr,comArr요소 일치여부 판별 T or F 반환 (F는 낫싱)
        boolean result = false;
        return result;
    }

    //자리 일치여부 확인
    private void placeMatch(int[] comArr,int[] userArr){
        //To DO : syncronize가 참일때만 실행
        //TO Do : userArr,comArr 자리 일치여부 판별 -> 일치하면 s+1, 아니면 b+1 (s,b는 볼,스트랔 카운트변수)

    }
    //컴퓨터 패 생성
    public void settingArr(int[] input){
        List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        int[] comIntArray  = comList.stream().mapToInt(Integer::intValue).toArray();
    }


}
