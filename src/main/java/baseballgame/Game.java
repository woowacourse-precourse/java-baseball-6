package baseballgame;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static constants.Constant.*;
import static constants.StringError.*;


public class Game {
    static final List<Integer> computerArray = new ArrayList<>();

    // 이미 스트라이크로 처리한 숫자에 대해 볼을 중복으로 처리하면 안된다. 이를 위한 배열이다.
    boolean[] checkPos = new boolean[INPUT_SIZE];

    BallCount ballCount = new BallCount();
    String restartFlagString;


    // 컴퓨터배열 및 스트라이크&볼 체크를 위한 배열 초기화 메서드
    public void init(){
        computerArray.clear();
        Arrays.fill(checkPos, Boolean.FALSE);
    }

    // 컴퓨터 배열을 위한 랜덤 샘플링 메서드
    public void pickComputerNum(){
        while(computerArray.size()<ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_NUM, END_RANGE_NUM);
            if (!computerArray.contains(randomNumber)) {
                computerArray.add(randomNumber);
            }
        }
    }

    // 숫자 야구 게임이 동작하는 메서드
    public void playGame(){
        while(!checkEndGame()) {
            ballCount.initValues();

            // 입력을 받는다.
            String inputString;
            System.out.print(INPUT_NUM_CMD);
            inputString = Console.readLine();


            // 검증한다.
            verifyInputStringLength(inputString);
            verifyInputStringContent(inputString);

            // String -> int Array로 바꾼다.
            int[] inputArray = changeStringToIntArray(inputString);

            // strike로 표시된 자리는 볼로 인식하면 안된다.
            Arrays.fill(checkPos, Boolean.FALSE);


            // 볼 카운트를 계산한다.
            CountBallAndStrike(inputArray);

            // 결과를 출력한다.
            PrintResult();

        }

        System.out.println(END_GAME_CMD);
        ballCount.initValues();
    }

    // 입력 길이 검증하는 메서드
    private void verifyInputStringLength(String inputString){
        if(inputString.length() != ANSWER_SIZE){
            throw new IllegalArgumentException(wrongLengthError +
                    "\nExpect : " + ANSWER_SIZE + "\nInput : " + inputString.length());
        }
    }

    // 입력 타입 검증하는 메서드
    private void verifyInputStringContent(String inputString){
        for(int i=0; i<INPUT_SIZE;i++){
            int inputChar = Character.getNumericValue(inputString.charAt(i));

            if(inputChar<START_RANGE_NUM || inputChar>END_RANGE_NUM){
                throw new IllegalArgumentException(wrongTypeError+
                        "\nExpect : 1~9" +"\nInput : "+inputChar);
            }
        }
    }

    // 문자열을 정수 배열로 변환하는 메서드
    private int[] changeStringToIntArray(String inputString) {
        int[] inputArray = new int[INPUT_SIZE];
        for(int i=0;i<INPUT_SIZE;i++){
            int inputNum = Integer.parseInt(inputString.substring(i, i+1));
            inputArray[i]=inputNum;
        }
        return inputArray;
    }

    // 볼&스트라이크 계산하는 메서드
    private void CountBallAndStrike(int[] inputArray) {
        CountStrike(inputArray);
        CountBall(inputArray);
    }

    // 볼 계산하는 메서드
    private void CountBall(int[] inputArray) {
        for(int i=0;i<INPUT_SIZE;i++){
            int inputNum = inputArray[i];
            if(!checkPos[i] && computerArray.contains(inputNum)){
                ballCount.addOneBallCnt();
            }
        }
    }

    // 스트라이크 계산하는 메서드
    private void CountStrike(int[] inputArray){
        for(int i=0;i<INPUT_SIZE;i++){
            int computerNum = computerArray.get(i);
            if(computerNum==inputArray[i]){
                checkPos[i]=true;
                ballCount.addOneStrikeCnt();
            }
        }
    }

    // 게임 종료 여부를 확인하는 메서드
    private boolean checkEndGame(){
        int totalStrikeNum = ballCount.getStrikeCnt();
        if(totalStrikeNum==MAX_STRIKE_NUM)
            return true;
        else if(totalStrikeNum<MAX_STRIKE_NUM)
            return false;
        else {
            throw new IllegalArgumentException(wrongEndGame +
                    "\nExpect : maximum strike num is 3" +
                    "\nInput : " +totalStrikeNum);
        }
    }

    // 게임 결과를 출력하는 메서드
    private void PrintResult() {
        int strikeNum = ballCount.getStrikeCnt();
        int ballNum = ballCount.getBallCnt();
        if(strikeNum==ZERO_COUNT && ballNum==ZERO_COUNT){
            System.out.println(NOTHING_CMD);
        }
        else if(strikeNum!=ZERO_COUNT && ballNum==ZERO_COUNT){
            System.out.println(strikeNum+STRIKE_CMD);
        }
        else if(strikeNum==ZERO_COUNT && ballNum!=ZERO_COUNT){
            System.out.println(ballNum+BALL_CMD);
        }
        else if(strikeNum != ZERO_COUNT && ballNum!=ZERO_COUNT){
            System.out.println(ballNum+BALL_CMD+" "+strikeNum+STRIKE_CMD);
        }
    }

    // 재시작을 물어보는 메서드
    public void askRestart(){
        System.out.println(RESTART_GAME_CMD);
        restartFlagString = Console.readLine();
    }

    // 재시작을 확인하는 메서드
    public boolean checkRestart(){
        if(Objects.equals(restartFlagString, RESTART_TRUE))
            return true;
        else if(Objects.equals(restartFlagString, RESTART_FALSE))
            return false;
        else{
            throw new IllegalArgumentException(wrongInputError+
                    "\nExpect : "+ "1 or 2" +"\nInput : "+ restartFlagString);
        }
    }
}