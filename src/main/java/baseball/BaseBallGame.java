package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class BaseBallGame {
    public List<Integer> computer;
    //상대방(컴퓨터)의 수 생성 함수
    public void RandomNum() {
        computer =new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber =Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
    public BaseBallGame(){
        RandomNum();
    }
}
