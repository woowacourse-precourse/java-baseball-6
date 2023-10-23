package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private int randomNum(){
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    //사용자 입력 문자열을 숫자 목록으로 변환
    private static List<Integer> playerNum(String playerStr){
        List<Integer> playerNum = new ArrayList<>();
        for(int i = 0; i < playerStr.length(); i++){
            char playerChar = playerStr.charAt(i);
            int playerInt = Character.getNumericValue(playerChar);
            playerNum.add(playerInt);
        }
        return playerNum;
    }

    //숫자 확인
    private boolean isNumeric(String playerStr){
        return playerStr.matches("\\d+");
    }
    //중복 숫자 체크
    private boolean containsRepeats(String playerStr){
        boolean result = false;
        List<Integer> playerNumList = BaseballGame.playerNum(playerStr);
        Set<Integer> playerNumSet = new HashSet<>(playerNumList);

        if(playerNumList.size() == playerNumSet.size()) result = true;

        return result;
    }

    //입력값 예외 체크
    public void inputChk(String playerStr){
        if (playerStr == null || playerStr.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        else if(playerStr.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(playerStr.contains("0")) {
            throw new IllegalArgumentException("숫자는 1부터 9까지 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(!isNumeric(playerStr)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다. 입력한 값 : " + playerStr);
        }
        else if(!containsRepeats(playerStr)) {
            throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다. 입력한 값 : " + playerStr);
        }
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
        return strikeCount == 3;
    }
    private boolean nothing(){
        return (strikeCount == 0 && ballCount == 0);
    }
    private boolean ballAndStrike(){
        return (strikeCount != 0 && ballCount != 0);
    }
    private boolean ballOnly(){
        return (strikeCount == 0 && ballCount != 0);
    }
    private boolean strikeOnly(){
        return (strikeCount != 0 && ballCount == 0);
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
