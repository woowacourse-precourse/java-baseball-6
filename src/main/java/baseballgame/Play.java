package baseballgame;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseballgame.Constant.*;


public class Play {
    List<Integer> result = new ArrayList<>();

    public Play(){
        // 컴퓨터의 숫자 생성하고 list에 집어넣기
        while(result.size() < ANSWER_SIZE ){
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if(!result.contains(randomNumber)){
                result.add(randomNumber);
            }
        }
    }

    public static void run(){
        //객체 선언
        Play play;
        do{
            //컴퓨터 숫자생성
            play = new Play();
            //게임 1회 시행
            play.;
        }while(/*게임 재시작 여부확인*/);
    }

    //게임 1회 시행
    public void playOnce(){
        String inputString;
        do{
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();
        }while(/*게임결과확인*/ != SUCCESS_BOOLEAN);
    }

    //게임 결과 확인
    private boolean checkGameResult(String inputNumberString){
        int[] inputNumberArray = 문자열을 정수형 배열로;
        int strike = 스트라이크 갯수 세기;
        int ballWithStrike = 볼 갯수 세기;
        결과 출력;

        //스트라이크개수 3개면 반복 종료
        if(strike == SUCCESS_STRIKE){
            return true;
        }else{
            return false;
        }
    }

    //string을 int배열로 변환
    private int[] changeInputStringToIntArray(String inputString){
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        입력받은 문자열의 크기 확인 로직;
        for(int i = 0; i < inputString.length(); i++){
            // 숫자 아닌 입력 예외던지기
            if(inputString.charAt(i) < '0' || inputString.charAt(i) > '9'){
                throw new IllegalArgumentException(wrongTypeInputError);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i + 1));
        }
        return intArray;
    }

    //입력받은 숫자의 길이 3자리 확인
    private void verifyInputStringLength(String inputString, int correctLength){
        if(inputString.length() != correctLength){
            throw new IllegalArgumentException(wrongLengthInputError);
        }
    }

    //재시작 여부 확인
    private boolean restart(){
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if(inputString.equals(RESTART_INPUT_STRING)){
            return true;
        }else if(inputString.equals(TERMINATE_INPUT_STRING)){
            return false;
        }else{
            throw new IllegalArgumentException(wrontInputError);
        }
    }

}
