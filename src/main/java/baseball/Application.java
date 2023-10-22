package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //User의 숫자값 입력해서 List형으로 리턴
    public static List<Integer> User(){
        String num_str = Console.readLine();
        char[] num_ch = num_str.toCharArray();

        if(is_Not_number(num_str)) {
            throw new IllegalArgumentException();
        }

        String[] token = num_str.split("");

        List<Integer> User_num = new ArrayList<>();

        for(int i = 0 ; i < token.length ; i++){
            User_num.add(Integer.parseInt(token[i]));
        }

        is_illegal(User_num);
        return User_num;
    }

    //숫자인지 아닌지 확인하는 예외처리
    public static boolean is_Not_number(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(IllegalArgumentException e) {
            return true;
        }
    }

    //숫자지만 잘못된 값 또는 잘못된 개수 또는 중복된 숫자를 입력한 예외처리
    public static void is_illegal(List<Integer> User_num) {
        //List의 크기가 3이상이면 예외처리
        if(User_num.size() != 3) {
            throw new IllegalArgumentException();
        }

        //중복된 숫자가 있다면 예외처리
        if(User_num.size() != User_num.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    //컴퓨터의 값을 입력(중복숫자 넣지 않도록 설정)

    public static List<Integer> com_num(){
        List<Integer> com_num = new ArrayList<Integer>();

        for(int i = 0 ; com_num.size() < 3 ; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!com_num.contains(num)) {
                com_num.add(num);
            }
        }

        return com_num;
    }

    //User_com이 com_num의 숫자들을 포함하고 있는지 확인
    public static int contain(List<Integer> User_num, List<Integer> com_num) {
        int contain = 0;

        for(int i = 0 ; i < User_num.size() ; i++) {
            if(User_num.contains(com_num.get(i))) {
                contain++;
            }
        }

        return contain;
    }

    //컴퓨터와 숫자가 맞는지 비교하기
    public static int compare(List<Integer> User_num, List<Integer> com_num) {
        int correct = 0;

        for(int i = 0 ; i < User_num.size() ; i++) {
            if(User_num.get(i).equals(com_num.get(i))) {
                correct++;
            }
        }

        return correct;
    }

    //결과를 출력해준다.
    public static String Output(List<Integer> User_num, List<Integer> com_num, int strike) {
        int contain = contain(User_num, com_num);
        int ball = contain - strike;

        String result = "";

        if(contain == 0) {
            result = "낫싱";
        } else if(strike == 0) {
            result = ball + "볼";
        } else if(ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = ball + "볼" + " " + strike + "스트라이크";
        }

        return result;
    }

    //계속 진행할건지, 나갈건지 확인

    public static boolean not_exit(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String str_choice = Console.readLine();

        if(is_Not_number(str_choice)) {
            throw new IllegalArgumentException();
        }

        int choice = Integer.parseInt(str_choice);

        exit_error_check(choice);

        return choice == 1;
    }

    public static void exit_error_check(int exit_num) {
        if(exit_num != 1 && exit_num != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}