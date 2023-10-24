package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구를 시작합니다."); //게임 시작 문구
        //게임 실행
        while(true) {
            if (game()) {
                break; //게임 종료
            }
        }
    }
    public static Boolean game() {
        List<Integer> computer = new ArrayList<>(); //랜덤한 값을 담을 리스트
        createRandomNumber(computer); // 랜덤한 세 자리 수 생성

        while(true) {
            String user = inputNumber(); //사용자 입력
            if (compareTwoNumber(computer, user)) { //두 수를 비교하여 3스트라이크일 경우
                break; //게임 종료
            }
        }
        Boolean result = checkGameContinueOrEnd(); //게임 종료 여부 - false : 재시작, true : 종료

        computer.clear(); //새로운 수 생성을 위한 컴퓨터 리스트 초기화
        return result; //게임 종료 여부 반환
    }
    public static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : "); //3자리 숫자 입력 문구
        String user = Console.readLine(); //3자리 수 입력
        if (user.length() != 3 || isNotDigit(user)) {
            throw new IllegalArgumentException("Input is not 3 digits long.");
        } //3자리 수가 아닐 경우 IllegalArgumentException 발생시켜 종료
        return user; //입력 값 반환
    } //사용자 입력 값 반환
    public static boolean isNotDigit(String user) {
        for(int i : user.toCharArray()) {
            if (!Character.isDigit(i)) {
                return true; //숫자가 아니라면 true 반환
            }
        }
        return false; //숫자라면 false 반환
    } //문자열이 숫자인지 판별
    public static void createRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) { //랜덤한 세 자리 수를 가질 때까지 반복
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1부터 9까지 중 랜덤한 수를 생성
            if (checkNotContain(computer, randomNumber)) { //리스트에 해당 수가 없을 경우
                computer.add(randomNumber); //리스트에 추가 -> 중복 제거
            }
        }
    } //랜덤한 3자리 수를 생성
    public static boolean checkNotContain(List<Integer> computer, int randomNumber) {
        if (computer.contains(randomNumber)) { //리스트에 숫자가 포함된 경우
            return false; //false
        }
        return true; //리스트에 숫자가 포함되어 있지 않을 경우 true 반환
    } //리스트 중복 체크
    public static Boolean compareTwoNumber(List<Integer> computer, String user) {
        List<Integer> checkScore = new ArrayList<>(); //list[strike, ball]의 형태로 구현 -> 각 요소 값이 strike, ball 개수
        checkScore.add(0); //strike -> 0으로 초기화
        checkScore.add(0); //ball -> 0으로 초기화
        for (int i = 0; i < 3; i++) {
            int userNumber = user.charAt(i) - '0'; //사용자 입력 값의 요소를 int로 변환 ex) '1' -> 1
            int computerNumber = computer.get(i); //컴퓨터 리스트의 요소
            if (userNumber == computerNumber) {
                checkScore.set(0, checkScore.get(0) + 1);
            } //사용자 입력 값과 컴퓨터 생성 값이 같을 경우 -> 스트라이크 + 1
            if (userNumber != computerNumber && computer.contains(userNumber)) {
                checkScore.set(1, checkScore.get(1) + 1);
            } //사용자 입력 값과 컴퓨터 생성 값이 같지 않지만 컴퓨터 생성 값에 사용자 입력 값이 존재할 경우 -> 볼 + 1
            //스트라이크와 볼이 아닐 경우는 낫싱 -> 스트라이크 == 볼 == 0일 때이므로 값을 기록하지 않음
        }
        int strike = checkScore.get(0); //strike 개수
        int ball = checkScore.get(1); //ball 개수

        checkScore.clear(); //새로운 스트라이크, 볼의 개수 저장을 위한 스코어 리스트 초기화
        if (printResult(strike, ball) == 1) {
            return true;
        } //3스트라이크일 경우 true 반환
        return false; //아닐 경우 결과 출력 후 false 반환
    } //스트라이크, 볼의 개수 세기 및 결과 출력 후 3스트라이크 여부 반환
    public static Integer printResult(int strike, int ball) {
        String resultString = ""; //초기 출력 문자열
        if (strike == 3) { //스트라이크가 3개일 경우
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1; //3스트라이크 및 게임 종료 문구 출력 후 1 반환
        }
        if (strike == 0 && ball == 0) { //스트라이크와 볼이 없을 때
            resultString = "낫싱"; //'낫싱' 출력
        }
        if (strike != 0 && ball == 0) { //스트라이크가 있고 볼이 없을 때
            resultString = strike + "스트라이크"; //'스트라이크' 개수 출력
        }
        if (strike == 0 && ball != 0) { //스트라이크가 없고 볼이 있을 때
            resultString = ball + "볼"; //'볼' 개수 출력
        }
        if (strike != 0 && ball != 0) { //스트라이크와 볼이 모두 있을 때
            resultString = ball + "볼 " + strike + "스트라이크 "; //'스트라이크' 개수와 '볼' 개수 출력
        }
        System.out.println(resultString); //게임 결과 문구 출력
        return 0; //0 반환
    } //스트라이크, 볼 결과 반환
    public static Boolean checkGameContinueOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); //게임 종료 여부 문구
        String checkContinue = Console.readLine(); //1 또는 2 입력
        if ((!checkContinue.equals("1")) && (!checkContinue.equals("2"))) {
            throw new IllegalArgumentException("Input is not 1 or 2.");
        } //입력값이 1이나 2가 아닐 경우 IllegalArgumentException 발생시켜 종료
        if (checkContinue.equals("2")) { //입력값이 2라면
            return true; //게임 종료
        }
        return false; //게임 재시작
    } //게임 재시작 또는 종료 여부 반환
}