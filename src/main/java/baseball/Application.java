package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    // 출력 메시지 정리
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    // 사용자 수 입력 값 예외처리 함수
    public static void exceptionGeneartor(List<Integer> userInput){
        try {
            // 3자리 숫자가 서로 다른 수가 아닐 경우
            List<Integer> temp = userInput.stream().distinct().toList();
            if(temp.size() != userInput.size()){
                throw new IllegalArgumentException();
            }

            // 1~9 사이의 수가 아닐 경우
            for(Integer i: userInput){
                if (i == 0) {
                    throw new IllegalArgumentException();
                }
            }

            // 3자리 숫자가 아닐 경우
            if (userInput.size() != 3) {
                throw new IllegalArgumentException();
            }

        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }



    // 결과 출력 함수
    public static void resultPrinter(List<Integer> sblist, String nothing){
        String ball = (sblist.get(1) > 0) ? (sblist.get(1) + "볼 ") : "";
        String strike = (sblist.get(0) > 0) ? (sblist.get(0) + "스트라이크") : "";

        System.out.println(ball + strike + nothing);
    }


    // 낫싱 체크 함수
    public static String nothingChecker(List<Integer> sblist){
        if (sblist.get(1) < 1 && sblist.get(0) < 1) {
            return "낫싱";
        }
        return "";
    }


    // 스트라이크 & 볼 체크 함수
    public static List<Integer> strike_ballChecker(List<Integer> computerNum, List<Integer> userNum){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userNum.get(i).equals(computerNum.get(i))) {
                strike += 1;
                continue;
            }
            // 볼 체크
            if (Collections.frequency(computerNum, userNum.get(i)) > 0) {
                ball += 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(strike);
        result.add(ball);

        return result;

    }


    // 메시지 출력함수
    public static void messagePrinter(String msg){
        System.out.println(msg);
    }

    // 사용자 수를 String 배열 -> Int 리스트로 변환하는 함수
    public static List<Integer> strArrayTointList(String[] userInput){

        // str 배열 -> int 배열로 변환
        int[] userInput_int = Arrays.stream(userInput).mapToInt(Integer::parseInt).toArray();

        // int 배열 -> int 리스트 변환
        List<Integer> userInput_result = new ArrayList<>();
        userInput_result = Arrays.stream(userInput_int).boxed().collect(Collectors.toList());

        return userInput_result;
    }

    // 컴퓨터 수 생성하는 메소드
    public static List<Integer> computerNumberGenerator(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }


    public static void main(String[] args) {

        // 게임 시작 문구 출력
        messagePrinter(START_GAME);

        // 컴퓨터 수 생성
        List<Integer> computerNum = computerNumberGenerator();

        // 게임 반복 시작점
        while (true) {

            // 사용자 값 입력 받기
            messagePrinter(GET_USER_NUMBER);
            String[] userInput_str = readLine().split("");

            // 사용자 수 intList 생성
            List<Integer> userInput = strArrayTointList(userInput_str);

            // 잘못된 입력 값 체크 -> 예외 발생 후 종료
            exceptionGeneartor(userInput);

            // 컴퓨터수 확인용 --주석처리
            System.out.println("computer num:" + computerNum);

            // 스트라이크+볼 체크
            List<Integer> strike_ball_list = strike_ballChecker(computerNum, userInput);

            // 낫싱 체크
            String nothing = nothingChecker(strike_ball_list);

            // 3 스트라이크 일 경우
            if (strike_ball_list.get(0) == 3) {
                // 게임 결과 출력
                System.out.println(strike_ball_list.get(0) + "스트라이크");
                messagePrinter(END_GAME);
                messagePrinter(RESTART_OR_END);

                // 게임 재시작할지 종료할지에 대한 사용자 입력 값 받기
                String user_answer = readLine();

                // 게임 재시작
                switch (user_answer){
                    case "1": computerNum = computerNumberGenerator();
                        break;
                    case "2": return;
                    default: try {
                                throw new IllegalArgumentException();
                            } catch (RuntimeException e) {
                                throw new IllegalArgumentException();
                            }
                }
            }

            // 3 스트라이크 아닐 경우
            else {
                // 게임 결과 출력
                resultPrinter(strike_ball_list, nothing);
            }
        }

    }
}