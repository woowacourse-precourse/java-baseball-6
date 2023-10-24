package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {

    private static List<Integer> nummaker(){
        List<Integer> templist = new ArrayList<>();

        while(templist.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!templist.contains(randomNumber)){
                templist.add(randomNumber);
            }

        }
        return templist;
     }
     private static List<Integer> toList(int input){
        List<Integer> tempList = new ArrayList<>(3);
        System.out.println(input);
         //방법1 하드코딩

         tempList.add(input/100);
         input = input - ( (input/100) *100);
         tempList.add(input/10);
         tempList.add(input%10);

         //방법2 루프 이용
//        for(int i=0; i<3; i++){
//            System.out.println(input%10);
//
//            tempList.add(2-i,input%10);
//            input =     input/ 10;
//        }
        return tempList;
     }
     private  static boolean checkanswer(List<Integer>human, List<Integer> compuet){
        int ball =0;
        int strick =0;
        System.out.println("human: "+ human + "\ncompuet:"+compuet+"\n");
        for(int i =0; i < 3; i++){
            for(int j=0; j<3; j++){
                if( (human.get(i) == compuet.get(j)) &&  i==j ) //두 숫자가 같고 위치가 같으면
                    strick++;
                else if((human.get(i) == compuet.get(j)) &&  i!=j) //두숫자는 같지만 위치가 다르면
                    ball++;
            }
        }

        if(strick == 3){
            return true;
        }
        else if(strick ==0 && ball ==0){
            System.out.println("낫싱");
            return false;
        }
        else if(strick ==0 && ball !=0){
            System.out.println( ball+ "볼");
            return false;
        }

        else if(strick !=0 && ball ==0){
            System.out.println( strick+ "스트라이크");
            return false;
        }
        else{
            System.out.println( ball+ "볼 " + strick+"스트라이크"  );
            return false;
        }

     }
    public static void baseballgame(){


        String continu = "1";
        List<Integer> computer;
        List<Integer> human;
        String input;


        while(continu.equals("1")){
            computer = nummaker(); // 정답 생성
            System.out.println(computer);
            human = null; // 초기화

            while(true){
                System.out.println("숫자를 입력해주세요 : ");
                input =  Console.readLine();

                if( 99>Integer.parseInt(input) || Integer.parseInt(input) > 1000 )
                    throw new IllegalArgumentException("허용되지 않는 범위입니다.");

                human = toList(Integer.valueOf(input));

                if(checkanswer(human, computer)){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    break;
                }

            }
            System.out.println("게임을 새로 시작 하려면 1, 종료하려면 2를 입력하세요.\n");
            continu = Console.readLine();

        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        baseballgame();

    }

}
