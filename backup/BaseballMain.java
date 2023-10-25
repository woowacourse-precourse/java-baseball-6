package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

/*

    출력 내용은 .java에서 가져온다.
    ** 상수와 변수 값을 동일한 파일에 설정하기 or 다른 파일에 설정하기 >> 상수 전부 CONSTANT_CASE를 사용

    1. 시작 시 컴퓨터 랜덤 함수 생성
    2. 사람의 숫자 입력 > 문자열을 int형으로 변환 > 정해진 숫자 및 자릿수에 벗어나면 IllegalArgumentException 발생 후 종료
    3. 사람의 입력 데이터를 이용해서 랜덤 수와 비교
    4. 비교 내용 출력
    5. <3> 스트라이크 일 때, 게임 재시작 및 종료 설정 콘솔
    
    Error
    1. 숫자를 3개 미만 혹은 초과하였을 때 오류 문구 추가
    2. 볼과 스트라이크 카운트 중복 수정 >> 스트라이크 일때 볼의 카운트 증가 수정
    ** 처음 랜덤수의 생성 갯수를 설정한 상수인 BALL_COUNT와 실제 사용자가 입력한 변수에 대한 BALLS_COUNT의
    상수 이름이 비슷하여 사용자의 입력에 대한 볼을 초기 랜덤수에 사용한 BALL_COUNT를 사용하여 이상한 값이 계속 출력하였다.
    3. 재시작 함수 확인
    
    
    추가
    1. 3스트라이크일 때, STRIKE_OUT을 출력하도록 설정 o
    2. 1을 입력하여 재시작을 할 때, 숫자 야구 게임을 시작합니다. 라는 문구를 안뜨도록 설정 o
    3. 게임 종료시 1, 2 이외의 문자를 입력하면 IllegalArgumentException으로 종료하도록 설정 o
    4. 숫자를 3개 미만 혹은 초과하였을 때 오류 문구 추가 확인하기. o
      >> 인트형이 아닌 다른 타입을 작성하였을 때, 숫자를 입력하라는 문구 출력하도록 설정 O

    - 사용자의 입력 변수인 inputNumberString을 userInput으로 변경하여 가독성을 불필요한 길이를 줄여 가독성을 높인다.
*/

public class BaseballMain {
    List<Integer> computer = new ArrayList<>();
    
    // 랜덤 숫자 생성
    public BaseballMain(){
        while (computer.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void run(){
        BaseballMain playBaseball;
        System.out.print(GAME_START_PRINT);
        do{
            playBaseball = new BaseballMain();
            playBaseball.mainStarting();
        }while(playBaseball.askRestart());

    }

    private void mainStarting(){
        String userInput;
        do{
            System.out.print("\n" +INPUT_NUMBER_MESSAGE);
            userInput = Console.readLine(); // 사용자 숫자 입력
        }while(!checkUserBall(userInput)); // 사용자 숫자가 입력 요구 사항에 적합한지 판단 및 랜덤수와 입력 수 비교. >> check boolean으로 설정

    }

    /*
        사용자가 입력한 수의 적합성 확인

        1. 자릿수가 3자리 O
        2. 사용자의 입력이 허용된 숫자만 존재하는지 확인 O
        3. 컴퓨터의 랜덤숫자와 사용자의 입력 비교 o
        4. 수의 일치값에 따라 각 문자 출력 o

     */

    // 자릿수 3자리
    // Checking_Input_length을 lowerCamelCase를 이행하도록 메소드 이름 변경 >> checkInputLength
    private void checkInputLength(String userInput){
        if(userInput.length() != NUMBER_LENGTH){
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR  + userInput);
        }
    }

    // Checking_User_Ball을 lowerCamelCase를 이행하도록 메소드 이름 변경 >> checkUserBall
    // checkUserBall 메소드: 문자열 길이 확인, 내용확인, 스트라이크와 볼 개수 확인 후 프린트
    // >> 메소드를 작게 나눠 관리에 유용하게 만들 수 있을것.
    private boolean checkUserBall(String userInput){
        // 사용자의 입력 문자 길이 확인 O
        // 사용자의 입력 문자를 int로 변경
        // 랜덤수와 입력 숫자를 비교 후 각 값에 대한 내용 출력
        // Check at the same time? >> how
        checkInputLength(userInput); // 문자열 길이 확인
        int[] inputNumberInteger = changeUserInputNumber(userInput); // 문자열의 내용 확인 후 int형으로 변환
        int ball = ballCount(inputNumberInteger);
        int strikes = strikeCount(inputNumberInteger);
        printAll(strikes, ball);

        if(strikes == STRIKE_OUT_COUNT){ // 스트라이크 상수 생성 3 >> STRIKE_OUT_COUNT
            System.out.println("\n" +STRIKE_OUT);
            return true;
        }
        else{
            return false;
        }
    }

    private void printAll(int strikes, int ball){
        // strikes가 3개일 때 true를 리턴하는 것을 Checking_User_ball 함수로 이동.

        if(ball > 0){
            printBall(ball);
        }
        if(strikes > 0){
            printStrike(strikes);
        }
        if(ball == 0 && strikes == 0){
            System.out.print(NOTHING);
        }

    }

    // Checking_User_Ball 내부의 If 말고 개별 print 함수 사용
    private void printStrike(int strikes){
        System.out.print(strikes + STRIKES_COUNT);
    }

    private void printBall(int ball){
        System.out.print(ball + BALLS_COUNT);
    }

    private int[] changeUserInputNumber(String userInput){
        // 문자열을 저장할 변수 초기화
        // 사용X: userInput을 char[]에 저장한 이후 다시 int[] 형으로 변환 >> Charater.getNumbericValue
        // 채택: Integer.parseInt()를 이용하여 문자열을 직접 int형으로 변환
        int[] userArray = new int[NUMBER_LENGTH];
        // If passed Checking length, Change char to int
        for(int i = 0; i < NUMBER_LENGTH; i++){
            char userArrayChar = userInput.charAt(i);
            // If the number entered by the User is not from 1 ~ 9 에러 출력
            if(userInput.charAt(i) < '1' || userInput.charAt(i) > '9'){
                throw new IllegalArgumentException(INPUT_NUMBER_ERROR + " "+ userInput);
            }
            userArray[i] = Character.getNumericValue(userArrayChar);
        }
        return userArray;

    }

    private int strikeCount(int[] userArray){
        int strikes = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++ ){
            if(userArray[i] == computer.get(i)){
                strikes++;
            }
        }
        return strikes;
    }

    private int ballCount(int[] userArray){
        int balls = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++ ){
            // 사용자의 입력 내용이 랜덤수에 존재하지'만', 자릿수가 다른 곳에 존재할 경우
            if(computer.contains(userArray[i]) && userArray[i] != computer.get(i)){
                balls++;
            }
        }
        return balls;
    }

    private boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if(userInput.equals(GAME_RESTART)){
            return true;
        }
        else if(userInput.equals(GAME_EXIT)){
            return false;
        }
        else{
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }
}
