package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = createComputer();

        boolean reply = true;

        int strike = 0;
        int total = 0;
        String answer = "";

        while (reply){
            List<Integer> player = createPlayer();

            total = getTotal(computer, player);
            strike = getStrike(computer, player);
            answer = outPut(total, strike);
            System.out.println(answer);

            if (strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                reply = reStart();
                if(reply){
                    computer = createComputer();
                }
            }
        }
    }

    public static List<Integer> createComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            // 범위 지정해주면 범위 안에 있는 int형 하나 반환
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> createPlayer(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        List<Integer> player = new ArrayList<>();
        String input = sc.next();
        try {
            if(!checkNumeric(input) || input.length() != 3 || repeatStringCheck(input)) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.exit(0);
        }

        for (String s : input.split("")){
            player.add(Integer.parseInt(s));
        }
        return player;
    }
    // 예외처리 : 숫자인지 아닌지 체크
    public static boolean checkNumeric(String input){
        boolean isNumeric = true;

        for (int i=0; i< input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isNumeric = false;
            }
        }
        return isNumeric;
    }

    // 예외처리 : 문자열 반복여부 체크
    public static boolean repeatStringCheck(String input){
        boolean flag = false;

        for (int i=0; i<input.length(); i++){
            for (int j=0; j<input.length(); j++){
                if (i != j && input.charAt(i) == input.charAt(j)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    public static int getTotal(List<Integer> computer, List<Integer> player){
        int total = 0;
        for (int i=0; i<computer.size(); i++){
            if (computer.contains(player.get(i))) total++;
        }
        return total;
    }

    public static int getStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for (int i=0; i<computer.size(); i++){
            if (Objects.equals(computer.get(i), player.get(i))){
                strike++;
            }
        }
        return strike;
    }

    public static String outPut(int total , int strike){
        int ball = total - strike;

        if (total == 0){
            return "낫싱";
        }else if (strike == 0) {
            return ball + "볼";
        }else if (ball == 0){
            return strike + "스트라이크";
        }
        return ball +"볼 " + strike +"스트라이크";
    }

    public static boolean reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return false;
            }
        }
        return false;
    }
}
