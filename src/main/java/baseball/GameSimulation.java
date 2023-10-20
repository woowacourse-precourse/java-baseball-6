package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameSimulation {

    private Integer StrikeCount;
    private Integer BallCount;
    private List<Integer> computer;
    private List<Integer> user;

    public GameSimulation(){
        init();
    }

    // 컴퓨터의 랜덤 숫자를 설정하는 메소드
    void init(){
        while (computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    // 유저의 번호를 받아서 저장하는 메소드
    public List<Integer> userInit(String userInput){
        String[] array=userInput.split("");
        List<Integer> userNumber=new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userNumber.add(Integer.valueOf(array[i]));
        }
        return userNumber;
    }

    // 입력된 유저의 값이 오류인 지 판단 하는 메서드
    public void judgeUser() {
        if (user.size() != 3){
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        if (user.contains(0)){
            throw new IllegalArgumentException("0이 포함 되어 있습니다.");
        }
        for (int i = 0; i < user.size(); i++){
            if (Collections.frequency(user,user.get(i)) != 1){
                throw new IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.");
            }
        }
    }



}
