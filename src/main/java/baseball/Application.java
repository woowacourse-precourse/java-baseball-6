package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static String INPUT_MSG = "숫자를 입력해주세요 : ";
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
            //스트라이크 개수 기록
            int strike = result[0];
            //볼 개수 기록
            int ball = result[1];
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
}
