package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> makeComputerumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input=Console.readLine();
        return input;
    }

    public static boolean userNumberValidation(String input) {
        boolean valid=true;

        if(input.length() > 3 || input.length() <= 0) {
            valid=false;
        }
        for(int i=0;i<3;i++) {
            if(input.charAt(i) > '9' || input.charAt(i) < '1') {
                valid=false;
            }
        }
        if(input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2)
                || input.charAt(1)==input.charAt(2)) {
            valid=false;
        }
        return valid;
    }

    public static List<Integer> userNumber(String input) {
        List<Integer> user = new ArrayList<>();
        if(userNumberValidation(input)) {
            for(int i=0;i < 3; i++) {
                user.add(Character.getNumericValue(input.charAt(i)));
            }
            return user;
        }else {
            throw new IllegalArgumentException("올바른 값을 입력하세요");
        }
    }

    public static int strikeCheck(List<Integer> computer, List<Integer> user) {
        int strike=0;
        for(int i=0;i<3;i++) {
            if(computer.get(i).equals(user.get(i))) {
                strike+=1;
            }
        }
        return strike;
    }

    public static int ballCheck(List<Integer> computer, List<Integer> user) {
        int ball=0;
        for(int i=0;i<3;i++) {
            if(computer.contains(user.get(i)) && computer.get(i)!=user.get(i)) {
                ball+=1;
            }
        }
        return ball;
    }

    public static String gameResult(int strike, int ball) {
        String result="";
        if(strike == 3) {
            result="3스트라이크\n";
            result+="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }else if(strike == 0 && ball == 0) {
            result="낫싱";
        }else if(strike == 0 && ball != 0) {
            result=ball+"볼";
        }else if(ball == 0 && strike != 0) {
            result=strike+"스트라이크";
        }else if (ball != 0 && strike != 0){
            result=ball+"볼 "+strike+"스트라이크";
        }
        return result;
    }

    public static boolean gameRestart() {
        boolean end=true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input=Console.readLine();
        if(input.equals("1")) {
            end=true;
            return end;
        }else if(input.equals("2")) {
            end=false;
            return end;
        }else {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }

    public static void endGame() {
        System.out.println("게임을 종료합니다!");
    }

    public static void gameProcess() {
        gameStart();
        boolean end=true;
        List<Integer> computer = makeComputerumber();
        while(end) {
            String input=inputNumber();
            List<Integer> user = userNumber(input);
            int strike=strikeCheck(computer, user);
            int ball=ballCheck(computer, user);
            String result=gameResult(strike, ball);
            if(strike != 3) {
                System.out.println(result);
                end=true;
            }else {
                System.out.println(result);
                end=false;
            }
        }
        if(gameRestart()) gameProcess();
        else endGame();
    }

    public static void main(String[] args) {
        gameProcess();
    }

}
