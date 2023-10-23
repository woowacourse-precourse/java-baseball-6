package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean flag =false;//나중에 다맞추면 true로 바꾸고 나가게 할 거
        ArrayList<Integer> correctList = getComputer();

        while(flag!=true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if(input.length()!=3) throw new IllegalArgumentException("입력값의 길이는 3이어야 합니다.");
            if(!input.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException("입력값은 숫자여야 합니다.");

            int[] checkResult = getResult(input,correctList);

            int ballCount=checkResult[0],strikeCount =checkResult[1];
            if(ballCount+strikeCount==0) System.out.println("낫싱");
            else{
                if(ballCount>=1 && strikeCount>=1) System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
                else if(ballCount>=1) System.out.println(ballCount+"볼");
                else if(strikeCount>=1) System.out.println(strikeCount+"스트라이크");
                if(strikeCount==3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String choice = Console.readLine();
                    System.out.println(choice);

                    if(choice.length()!=1) throw new IllegalArgumentException("입력값의 길이는 3이어야 합니다.");
                    if(!choice.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException("입력값은 숫자여야 합니다.");

                    if(Integer.parseInt(choice)==1){
                        correctList = getComputer();
                    }
                    else{
                        return;
                    }
                }

            }


        }
    }


    public static int[] getResult(String input,ArrayList<Integer> correctList){
        int ballCount=0;
        int strikeCount=0;
        int[] result = new int[2];

        for (int i = 0; i < 3; i++) {
            char digit = input.charAt(i);
            int number = Character.getNumericValue(digit);
            if(correctList.get(i)==number){
                strikeCount+=1;
            }else{
                if(correctList.contains(number)) ballCount+=1;
            }
        }

        result[0]= ballCount;
        result[1]= strikeCount;
        return result;
    }
    public static ArrayList<Integer> getComputer(){
        //초기 랜덤 숫자 뱉어주는 함수
        System.out.println("숫자 야구 게임을 시작합니다.");
        ArrayList<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        for (int i=0;i<3;i++)
            System.out.print(computer.get(i));
        System.out.println();
        return computer;
    }

}
