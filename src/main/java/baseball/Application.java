package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램

        boolean restart=true;
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            if(restart){
                computer=setRandomValue();
                restart=false;
            }
            System.out.println(computer);
            int strike=0, ball=0;

            //입력
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if(input == null){
                throw new IllegalArgumentException();
            }

            if(input.length()!=3){
                throw new IllegalArgumentException();
            }

            Set<Character> set=new HashSet<>();
            for(int i=0; i<input.length(); i++){
                set.add(input.charAt(i));
            }
            if(set.size()!=input.length()){
                throw new IllegalArgumentException();
            }

            for(int i=0; i<input.length(); i++){
                if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException();
            }



            for(int i=0; i<input.length(); i++){
                int value=(int)input.charAt(i)-'0';
                user.add(value);
            }


            //비교
            for(int idx=0; idx<user.size(); idx++){
                int value=user.get(idx);
                if(computer.contains(value)){
                    if(computer.indexOf(value)==idx) strike++;
                    else ball++;
                }
            }

            //출력
            if(strike==0 && ball==0){
                System.out.println("낫싱");
            }
            else{
                if(strike==3){
                    System.out.println(strike+"스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String command = Console.readLine();
                    int exit=(int)command.charAt(0)-'0';
                    if(exit==2) break;
                    restart=true;
                }
                else{
                    if(ball>0 && strike>0) System.out.println(ball+"볼 "+strike+"스트라이크");
                    else if(ball>0) System.out.println(ball+"볼");
                    else if(strike>0) System.out.println(strike+"스트라이크");
                }
            }

            user.clear();



        }


    }

    static List<Integer> setRandomValue(){
        List<Integer> computer = new ArrayList<>();


        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }


}
