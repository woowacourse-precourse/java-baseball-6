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



    public static void main(String[] args) {

        // 게임 시작 문구 출력
        System.out.println(START_GAME);

        // 컴퓨터 수 생성
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 게임 반복 시작점
        while (true) {

            // 사용자 값 입력 받기
            System.out.println(GET_USER_NUMBER);
            String[] userInput_str = readLine().split("");

            // str 배열 -> int 배열로 변환
            int[] userInput_int = Arrays.stream(userInput_str).mapToInt(Integer::parseInt).toArray();

            // int 배열 -> int 리스트 변환
            List<Integer> userInput = new ArrayList<>();
            userInput = Arrays.stream(userInput_int).boxed().collect(Collectors.toList());


            // 예외 발생 후 종료하기
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
                if (userInput_int.length != 3) {
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

            System.out.println("computer num:" + computer);

            // 스트라이크 체크
            for (int i = 0; i < 3; i++) {
                if (userInput.get(i).equals(computer.get(i))) {
                    strike += 1;
                    continue;
                }
                // 볼 체크
                if (Collections.frequency(computer, userInput.get(i)) > 0) {
                    ball += 1;
                    //ballList.add(userInput.get(i));
                }
            }

            // 낫싱 체크
            if (ball < 1 && strike < 1) {
                nothing = "낫싱";
            }


            // -만약 3스트라이크면 게임 종료
            String user_answer = "";

            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println(END_GAME);
                System.out.println(RESTART_OR_END);
                user_answer = readLine();
                if (user_answer.equals("1")) {

                    // 컴퓨터 수 생성
                    computer = new ArrayList<>();

                    while (computer.size() < 3) {
                        int randomNumber = pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }

                    continue;

                } else if (user_answer.equals("2")) {
                    return;
                }
            }

            // -3스트라이크 아닐 경우, 예측 결과 출력
            else {
                String ball_res = (ball > 0) ? (ball + "볼 ") : "";
                String strike_res = (strike > 0) ? (strike + "스트라이크") : "";

                System.out.println(ball_res + strike_res + nothing);
            }
        }

    }
}