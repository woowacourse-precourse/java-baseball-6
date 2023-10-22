package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();



        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }


        while(true){
            int strike=0, ball=0;

            //입력
            System.out.print("숫자를 입력해주세요 : ");
            Scanner sc=new Scanner(System.in);
            String input=sc.nextLine();
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
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int exit = sc.nextInt();
                    if(exit==2) break;
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
}
