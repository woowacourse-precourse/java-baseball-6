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
    private static final int NOTHING = 0;
    //1에서 9 사이 서로 다른 3자리 랜덤 숫자 생성
    public List<Integer> computer(){
        List<Integer> computer = new ArrayList<>();
        while(computer == null || computer.size() < NUMBER_LENGTH){
            int randomNum = randomNum();
            if(!computer.contains(randomNum)) computer.add(randomNum);
        }
        this.computerNum = computer;
        //컴퓨터 랜덤값 출력 테스트
        System.out.println("BaseballGame computerNum : " + computerNum);
        return computerNum;
    }

    private int randomNum(){
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

    //스트라이크, 볼 계산
    public void playGame(String playerStr, List<Integer> computer){
        this.computerNum = computer;
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> playerNum = BaseballGame.playerNum(playerStr);
        for(int i = 0; i < computerNum.size(); i++){
            if(computerNum.get(i).equals(playerNum.get(i)))
                strikeCount++;
            else if(playerNum.contains(computerNum.get(i)))
                ballCount++;
        }
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private boolean threeStrikes(){
        return strikeCount == NUMBER_LENGTH;
    }
    private boolean nothing(){
        return (strikeCount == NOTHING && ballCount == NOTHING);
    }
    private boolean ballAndStrike(){
        return (strikeCount != NOTHING && ballCount != NOTHING);
    }
    private boolean ballOnly(){
        return (strikeCount == NOTHING && ballCount != NOTHING);
    }
    private boolean strikeOnly(){
        return (strikeCount != NOTHING && ballCount == NOTHING);
    }

    //스트라이크와 볼 수에 따라 결과를 표시
    public boolean showResult() {
        boolean result = false;
        if (threeStrikes()) {
            System.out.println("3스트라이크");
            result = true;
        } else if (nothing())
            System.out.println("낫싱");
        else if (ballAndStrike())
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if (ballOnly())
            System.out.println(ballCount + "볼");
        else if (strikeOnly())
            System.out.println(strikeCount + "스트라이크");
        return result;
    }
}
