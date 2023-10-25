package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static boolean computerPower, gamePower;
    public static void main(String[] args) {

        // [대기 화면]
        computerPower = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(computerPower){
            List<Integer> randomAnswer = generateRandomAnswer();

            // [게임 시작]
            gamePower = true;
            while(gamePower){
                // 사용자 입력값 대기...
                Set<Integer> userGuessSet = readUserGuess();
                boolean checkResult = formatCheck(userGuessSet);
                if(!checkResult) {
                    turnOff();
                    continue;
                }
                compareAnswer(randomAnswer, userGuessSet);
            }
        }
    }

    private static void turnOff() {
        computerPower = false;
        gamePower = false;
        throw new IllegalArgumentException("잘못된 형식의 입력입니다. 프로그램을 종료합니다.");
    }

    public static int compareAnswer(List<Integer> randomAnswer, Set<Integer> userGuessSet) {
        int ball = 0, strike = 0;
        ArrayList<Integer> userGuessArr = new ArrayList<>(userGuessSet);
        for(int i = 0; i < userGuessArr.size(); i++){
            int match = randomAnswer.indexOf(userGuessArr.get(i));
            if(match==-1){
                continue;
            } else if(match==i){
                strike++;
                continue;
            }
            ball++;
        }
        return ball;
//        printResult(ball, strike);
    }

    private static void printResult(int ball, int strike) {

    }

    public static boolean formatCheck(Set<Integer> set){
        return set.size()==3 ? true : false;
    }

    public static Set<Integer> readUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userGuessStr = Console.readLine();
        // 형식 확인
        // 1. 입력이 3자리 수 인가
        // 2. 3자리중 중복이 없는가
        // set<int>에다 저장하고 size가 3인가 확인.
        Set<Integer> userGuessSet = new LinkedHashSet<>();
        userGuessSet.add(userGuessStr.charAt(0)-'0');
        userGuessSet.add(userGuessStr.charAt(1)-'0');
        userGuessSet.add(userGuessStr.charAt(2)-'0');
        return userGuessSet;
    }

    public static List<Integer> generateRandomAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
