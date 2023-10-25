package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static boolean computerPower, gamePower;
    private static int ball, strike;
    public static void main(String[] args) {

        // [대기 화면]
        computerPower = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(computerPower){
            List<Integer> randomAnswer = generateRandomAnswer();

            // [게임 시작]
            gamePower = true;
            while(gamePower){
                Set<Integer> userGuessSet = readUserGuess(); // 사용자 입력값 대기...
                formatCheck(userGuessSet);  // 올바른 형식의 입력값 확인...
                compareAnswer(randomAnswer, userGuessSet); // 정답 확인 로직 실행...
                printResult(); // 분석 결과 출력...
            }
            gameContinue();
        }
    }

    private static void gameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(input.equals("1")){
            return;
        }
        else if(input.equals("2")){
            computerPower=false;
        }
        else{
            turnOff();
        }
    }

    private static boolean turnOff() {
        computerPower = false;
        gamePower = false;
        throw new IllegalArgumentException();
    }

    public static void compareAnswer(List<Integer> randomAnswer, Set<Integer> userGuessSet) {
        ball = 0; strike = 0;
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
    }

    public static void printResult() {
        if(ball!=0){
            System.out.print(ball+"볼 ");
        }
        if(strike!=0){
            System.out.print(strike+"스트라이크 ");
        }
        if(ball==0 && strike==0){
            System.out.print("낫싱");
        }
        System.out.println();
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gamePower=false;
        }
    }

    public static boolean formatCheck(Set<Integer> set){
        return set.size()==3 ? true : turnOff();
    }

    public static Set<Integer> readUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userGuessStr = Console.readLine();
        // 형식 확인
        // 1. 입력이 3자리 수 인가
        // 2. 3자리중 중복이 없는가
        // set<int>에다 저장하고 size가 3인가 확인.
        for(int i = 0; i < userGuessStr.length(); i++){
            if(!Character.isDigit(userGuessStr.charAt(i))){
                turnOff();
            }
        }
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
