package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int strikeCount;
    private int ballCount;
    private List<Integer> computerNum;

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int NUMBER_LENGTH = 3;

    //1에서 9 사이 서로 다른 3자리 랜덤 숫자 생성
    public List<Integer> computer(){
        List<Integer> computer = new ArrayList<>();
        int randomNum = randomNum();
        computer.add(randomNum);
        while(computer.size() < NUMBER_LENGTH){
            randomNum = randomNum();
            if(!computer.contains(randomNum)) computer.add(randomNum);
        }
        this.computerNum = computer;
        //컴퓨터 랜덤값 출력 테스트
        System.out.println("BaseballGame computerNum : " + computerNum);
        return computerNum;
    }

    public int randomNum(){
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    //사용자 입력 문자열을 숫자 목록으로 변환
    public static List<Integer> playerNum(String playerStr){
        List<Integer> playerNum = new ArrayList<>();
        for(int i = 0; i < playerStr.length(); i++){
            char playerChar = playerStr.charAt(i);
            int playerInt = Character.getNumericValue(playerChar);
            playerNum.add(playerInt);
        }
        return playerNum;
    }
}
