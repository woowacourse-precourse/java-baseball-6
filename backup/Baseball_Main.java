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

*/

public class Baseball_Main {
    List<Integer> computer = new ArrayList<>();
    
    // 랜덤 숫자 생성
    public Baseball_Main(){
        while (computer.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_COUNT, END_COUNT);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (Integer integer : computer) {
            System.out.println(integer.toString());
        }
    }

    public static void run(){
        Baseball_Main playBaseball;
        do{
            playBaseball = new Baseball_Main();
            playBaseball.mainStarting();
        }while(playBaseball.askRestart());

    }

    private void mainStarting(){
        String inputNumberString;
        System.out.println(GAME_START_PRINT);

        do{
            System.out.print(PLZ_INPUT_NUMBER);
            inputNumberString = Console.readLine(); // 사용자 숫자 입력
        }while(Checking_User_Ball(inputNumberString) == false); // 사용자 숫자가 입력 요구 사항에 적합한지 판단 및 랜덤수와 입력 수 비교. >> check boolean으로 설정

    }

    /*
        사용자가 입력한 수의 적합성 확인

        1. 자릿수가 3자리 O
        2. 사용자의 입력이 허용된 숫자만 존재하는지 확인 O
        3. 컴퓨터의 랜덤숫자와 사용자의 입력 비교
        4. 수의 일치값에 따라 각 문자 출력

     */

    // 자릿수 3자리
    private void Checking_Input_Length(String inputNumberString){
        if(inputNumberString.length() != NUMBER_LENGTH){
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR + "\n" + inputNumberString);
        }

        changeUserInputNumber(inputNumberString);
    }

    private boolean Checking_User_Ball(String inputNumberString){
        // 사용자의 입력 문자 길이 확인 O
        // 사용자의 입력 문자를 int로 변경
        // 랜덤수와 입력 숫자를 비교 후 각 값에 대한 내용 출력
        // Check at the same time? >> how
        Checking_Input_Length(inputNumberString); // 문자열 길이 확인
        int[] inputNumberInteger = changeUserInputNumber(inputNumberString); // 문자열의 내용 확인 후 int형으로 변환
        


        if(strikeCount(inputNumberInteger) == 3){
            System.out.print(STRIKES_OUT);
            return true;
        }
        else{
            if(ballCount(inputNumberInteger) != 0){
                System.out.print(ballCount(inputNumberInteger) + BALL_COUNT);
            }
            else if(strikeCount(inputNumberInteger) > 0 && strikeCount(inputNumberInteger) < 3){
                System.out.print(strikeCount(inputNumberInteger) + STRIKES_COUNT);
            }
            else if(ballCount(inputNumberInteger) == 0 && strikeCount(inputNumberInteger) == 0){
                System.out.print(NOTHING);
            }
            return false;
        }
    }


    private int[] changeUserInputNumber(String inputNumberString){
        // 문자열을 저장할 변수 초기화
        // 사용X: inputNumberString을 char[]에 저장한 이후 다시 int[] 형으로 변환 >> Charater.getNumbericValue
        // 채택: Integer.parseInt()를 이용하여 문자열을 직접 int형으로 변환
        int[] userArray = new int[NUMBER_LENGTH];
        // If passed Checking length, Change char to int
        for(int i = 0; i < inputNumberString.length(); i++){
            // If the number entered by the User is not from 1 ~ 9 에러 출력
            if(inputNumberString.charAt(i) < '0' || inputNumberString.charAt(i) > '9'){
                throw new IllegalArgumentException(INPUT_NUMBER_ERROR + " "+ inputNumberString);
            }
            userArray[i] = Integer.parseInt(inputNumberString.substring(i));
        }
        return userArray;

    }

    /*
    // 볼 스트라이크를 각각 연산하여 출력하도록 함수 두개를
    private int[] compareInputNum(int[] userArray){
        int strikes = 0;
        int balls = 0;

        for(int i = 0; i < NUMBER_LENGTH; i++ ){
            if(userArray[i] == computer.get(i)){
                strikes++;
            }else if(computer.contains(userArray[i])){
                balls++;
            }
        }

        if(strikes == NUMBER_LENGTH){
            System.out.print("")
        }
        // 볼과 스트라이크를 동시에 출력하도록 만들려 했는데 if else가 너무 많아진다.
        // 따라서 스트라이크와 볼을 체크하는 각각의 새로운 함수를 작성한다.

        return userArray;
    }
     */

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
            if(computer.contains(userArray[i])){
                balls++;
            }
        }
        return balls;
    }

    private boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        return "1".equals(userInput);
    }
}
