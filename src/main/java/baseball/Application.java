package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    }
    public static void game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber = makeRandomNumber();
        boolean stopSign=false;
        while (true){
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> inputNumber = inputUserNumber();
            Result result = checkResult(computerNumber, inputNumber);
            viewResult(result);
            if(checkGame(result)){
                restartOrExit();
            }
        }
    }

    public static void restartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int sign = inputSign();

    }

    public static int inputSign() {
        String sign = Console.readLine();
        if(sign.equals("1")) return 1;
        return 2;
    }

    public static boolean checkGame(Result result) {
        if(result.strike==3){
            return true;
        }
        return false;
    }
    public static void viewResult(Result result) {
        String view = "";
        if(result.ball>0){
            view+=Integer.toString(result.ball)+"볼 ";
        }
        if(result.strike>0){
            view+=Integer.toString(result.strike)+"스트라이크 ";
        }
        if(result.isNothing) view="낫싱";
        System.out.println(view);
    }
    public static List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static boolean checkError(String s) {
        if (s.length() != 3) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            if (tmp >= 0 && tmp < 10) return true;
        }
        return false;
    }

    public static List<Integer> inputUserNumber() {
        String s = Console.readLine();
        if (checkError(s)) throw new IllegalArgumentException();
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            inputNumber.add(s.charAt(i) - '0');
        }
        return inputNumber;
    }

    public static Result checkResult(List<Integer> computerNumber, List<Integer> inputNumber) {
        Result result = new Result();

        List<Integer> ballList = new ArrayList<>();
        ballList.addAll(computerNumber);

        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(inputNumber.get(i))) {
                result.strike++;
                ballList.set(i, -1);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (ballList.contains(inputNumber.get(i))) {
                result.ball++;
            }
        }
        if (result.ball == 0 && result.strike == 0) {
            result.isNothing = true;
        }
        return result;
    }

    public static class Result {
        int strike;
        int ball;
        boolean isNothing;

        public Result() {
            this.strike=0;
            this.ball=0;
            this.isNothing = false;
        }
    }
}
