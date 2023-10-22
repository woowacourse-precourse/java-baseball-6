package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    // main 함수
    public static void main(String[] args) {
        Application baseballGame = new Application();

        baseballGame.sayStart();
        List<Integer> computer = baseballGame.getRandomThreeNum(); // System.out.println("[디버깅] computer: " + computer);

        boolean restartGame = true;
        while (restartGame) { // 게임 시작
            List<Integer> user = baseballGame.getThreeNum();
            baseballGame.calculateBallStrike(user, computer);
            baseballGame.sayBallStrike();
            if (baseballGame.strike == 3) {
                baseballGame.sayEnd();
                restartGame = baseballGame.determineRestart();
                computer = baseballGame.getRandomThreeNum(); // System.out.println("[디버깅] computer: " + computer);
            }
        }
    }
    // strike, ball 변수 정의
    public int strike, ball;
    // 1. 게임 시작
    public void sayStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    // 2. computer input 받기
    public List<Integer> getRandomThreeNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // input 받은 값이 int 인지 판별
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // 3. 유저로부터 3자리 수 받기
    public List<Integer> getThreeNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException(); // "길이가 3이 아닙니다."
        }

        List<Integer> user = new ArrayList<>();
        for (int i=0; i<3; i++) {
            char charValue = input.charAt(i);
            String stringValue = String.valueOf(charValue);
            if (isNumeric(stringValue)){
                Integer intValue = Integer.parseInt(stringValue);
                if (intValue == 0) {
                    throw new IllegalArgumentException(); // "0이 포함되어 있습니다."
                }
                if (user.contains(intValue)) {
                    throw new IllegalArgumentException(); // "중복된 숫자가 포함되어 있습니다."
                }
                user.add(intValue);
            }else { // 숫자가 아닐 때
                throw new IllegalArgumentException(); // "유효한 정수가 아닌 문자열입니다."
            }
        }
        return user;
    }
    // 4-1. strike, ball 판별
    public void calculateBallStrike(List<Integer>user, List<Integer>computer){
        strike = 0;
        ball = 0;
        for (int i=0; i<user.size(); i++) {
            for (int j=0; j< computer.size(); j++) {
                if (user.get(i).equals(computer.get(j))) {
                    if (i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }
    }
    // 4-2. strike, ball 출력
    public void sayBallStrike(){
        // else 사용 X
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else if (ball != 0 && strike == 0){
            System.out.printf("%d볼", ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        } else if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }System.out.println();
    }
    // 5-1. 게임 종료 (3스트라이크 시)
    public void sayEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    // 5-2. 게임 재시작 할 지 정하기
    public Boolean determineRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException(); // "입력값이 예상한 값(1, 2)이 아닙니다."
        }
    }
}
