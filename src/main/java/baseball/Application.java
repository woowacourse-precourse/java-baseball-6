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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}