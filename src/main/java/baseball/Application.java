package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static List<Integer> createRandomNum(){ //[4, 3, 5]
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> checkUserNum(String num) throws IllegalArgumentException{
        //num 3자리가 아닐 때
        if(num.length() != 3)
            throw new IllegalArgumentException();

        List<Integer> userNum = new ArrayList<>();
        for(int i = 0; i<num.length(); i++){
            userNum.add(num.charAt(i) - '0');
        }

        return userNum;
    }



    public static void main(String[] args) {


        while(true){
            //컴퓨터 숫자 세팅
            List<Integer> comNum = createRandomNum();

//            System.out.println("---------------------------------------------");
//            System.out.println("comNum" + comNum);
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true){
                //사용자 숫자 세팅(다 맞을 때까지 계속 입력 받기)
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();


                List<Integer> userNum = new ArrayList<>();
                try {
                    userNum = checkUserNum(num);
                }catch(IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                }



                //사용자 숫자와 컴퓨터 숫자 확인하기




                //결과 출력



            }


            //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            //String s = Console.readLine();
            //if(s.equals("2")) break;

//            System.out.println("---------------------------------------------");
        }



    }
}