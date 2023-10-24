package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    // 사용 문자열 정리
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String GET_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


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
        System.out.println(START_GAME);

        // 컴퓨터 수 생성
        List<Integer> computerNum = computerNumberGenerator();

        // 게임 반복 시작점
        while (true) {

            // 사용자 값 입력 받기
            System.out.println(GET_USER_NUMBER);
            String[] userInput_str = readLine().split("");

            // 사용자 수 strArray -> intList 변환
            List<Integer> userInput = strArrayTointList(userInput_str);

            // 잘못된 입력 값 체크 -> 예외 발생 후 종료
            List<Integer> temp = new ArrayList<>();

            try {
                // 3자리 숫자가 서로 다른 수가 아닐 경우

                //중복 제거 후와 제거 전의 리스트 사이즈 비교하기
                temp = userInput.stream().distinct().collect(Collectors.toList());
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

            // 컴퓨터 수와 비교하기
            int strike = 0;
            int ball = 0;
            int ball_val = 0;
            String nothing = "";
            List<Integer> ballList = new ArrayList<>();

            System.out.println("computer num:" + computerNum);

            // 스트라이크 체크
            for (int i = 0; i < 3; i++) {
                if (userInput.get(i).equals(computerNum.get(i))) {
                    strike += 1;
                    continue;
                }
                // 볼 체크
                if (Collections.frequency(computerNum, userInput.get(i)) > 0) {
                    ball += 1;
                }
            }

            // 낫싱 체크
            if (ball < 1 && strike < 1) {
                nothing = "낫싱";
            }


            // 3 스트라이크 일 경우
            String user_answer = "";

            if (strike == 3) {
                System.out.println(strike + "스트라이크" + "\n" + END_GAME + "\n" + RESTART_OR_END);
                user_answer = readLine();

                // 게임 재시작
                if (user_answer.equals("1")) {

                    // 컴퓨터 수 생성 후 처음으로 돌아가기
                    computerNum = computerNumberGenerator();
                    continue;

                // 게임 종료
                } else if (user_answer.equals("2")) {
                    return;
                }
            }

            // 3 스트라이크 아닐 경우, 사용자 수-컴퓨터 수 판단 결과 출력
            else {
                String ball_res = (ball > 0) ? (ball + "볼 ") : "";
                String strike_res = (strike > 0) ? (strike + "스트라이크") : "";

                System.out.println(ball_res + strike_res + nothing);
            }
        }

    }
}