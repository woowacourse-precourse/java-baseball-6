package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static String INPUT_MSG = "숫자를 입력해주세요 : ";
    public static String SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static int LIST_LEN = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //step0. 게임 시작
        System.out.println(START_MSG);

        boolean isFinish = true;
        List<Integer> computer = null;
        while(true) {
            //step1. 랜덤 숫자 생성
            if(isFinish) {
                isFinish = false;
                computer = getRandomNumbers();
            }
            //step2. 사용자 입력
            System.out.print(INPUT_MSG);
            String input = Console.readLine();
            List<Integer> user = getUserNumbers(input);
            //step3. 사용자 입력을 바탕으로 스트라이크/볼 개수 기록
            int[] result = countStrikesAndBalls(computer, user);
            //step4. 결과 출력
            printResult(result);
            //step5. 만약 결과가 3strike라면 게임을 새로 시작할건지 사용자에게 질문
            if(result[0] == 3) {
                System.out.println(SUCCESS_MSG);
                input = Console.readLine();
                if(checkRestart(input)){
                    isFinish = true;
                } else {
                    return;
                }
            }

        }
    }


    /**
     * 랜덤 숫자를 생성해 리스트 형태로 반환하는 함수
     */
    public static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) { //3자리의 자연수
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1부터 9까지의 숫자로 구성
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber); //중복 불가
            }
        }
        return computer;
    }

    /**
     * 사용자의 입력을 검증 후 적절하다면 입력받은 숫자를 리스트 형태로 반환하는 함수
     * 만약 적절하지 않은 입력이라면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료
     */
    public static List<Integer> getUserNumbers(String input) {
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int x = input.charAt(i) - '0';
            if(0 <= x && x <= 9) {
                //중복된 수를 입력
                if (user.contains(x)) {
                    throw new IllegalArgumentException("중복된 수를 입력하셨습니다. 1에서 9까지 서로 다른 수를 입력해 주세요.");
                }
                user.add(x);
            }
            //1부터 9까지의 수가 아닌 다른 문자를 입력
            else {
                throw new IllegalArgumentException("1부터 9까지 서로 다른 수만 공백 없이 입력해 주세요.");
            }
        }

        //숫자를 3개 입력하지 않은 경우
        if(user.size() != 3) {
            throw new IllegalArgumentException("숫자를 3개 입력해 주세요.");
        }

        return user;
    }

    /**
     * 사용자의 입력 리스트 바탕으로 스트라이크/볼 개수를 배열에 저장해 반환하는 함수
     * result[0]은 strike를 의미
     * 같은 수가 같은 자리에 있으면 strike
     * result[1]은 ball을 의미
     * 같은 수가 다른 자리에 있으면 ball
     */
    public static int[] countStrikesAndBalls(List<Integer> computer, List<Integer> user) {
        int[] result = {0, 0};
        for(int i = 0; i < LIST_LEN; i++) {
            if(Objects.equals(computer.get(i), user.get(i))) {
                result[0]++;
            } else {
                if(computer.contains(user.get(i))) {
                    result[1]++;
                }
            }
        }
        return result;
    }

    /**
     * 스트라이크/볼 개수를 바탕으로 결과 출력
     * 둘 다 개수가 0일 경우 낫싱 출력
     */
    public static void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball + "볼 ");
        }
        if(strike != 0) {
            sb.append(strike + "스트라이크 ");
        }
        if(ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    /**
     * 게임이 끝난 경우 재시작/종료 구
     * 입력은 1과 2 중 하나의 수
     */
    public static boolean checkRestart(String input) {
        boolean isRestart;

        //문자를 두 개 이상 입력
        if(input.length() != 1) {
            throw new IllegalArgumentException("1이나 2 하나만 공백없이 입력해야 합니다.");
        }

        if(input.charAt(0) - '0' == 1) { //재시작
            isRestart = true;
        } else if(input.charAt(0) - '0' == 2) { //종료
            isRestart = false;
        } else { //입력이 1이나 2가 아닌 경우
            throw new IllegalArgumentException("1이나 2를 입력해야 합니다.");
        }
        return isRestart;
    }
}
