package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

       Scanner scanner=new Scanner(System.in);
       
       int ball=0;
       int strike=0;
       String x="낫싱";
       
       RandomNumber randomComputerNum=new RandomNumber();
       
       end :
       while(true) {
          //컴퓨터 3자리 난수 ex) [8, 1, 4]
         List<Integer> computer=randomComputerNum.randomcomputerNum();
          
          System.out.println(computer);
          //3자리 난수 정수배열에 대입
          int[] randomNum = {computer.get(0),computer.get(1),computer.get(2)};
          
          System.out.println("숫자 야구 게임을 시작합니다.");
          
          restart :
          while(true) {
             
           System.out.print("숫자를 입력해주세요 : ");  
             
            if(scanner.hasNextInt()==false) {
               throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(정수가 아닌 값)");
            }
             
             //서로 다른 정수3자리
             int num = scanner.nextInt();
             
             if(num<99 || num>999) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(입력값 3자리수)");
             }
              
             //일의자리
             int num3 = num%10;
             //십의자리
             int num2 = num%100/10;
             //백의자리
             int num1 = num/100;
             
             if(num1==num2 || num1==num3 || num2==num3) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(중복된 값)");
             }
             
             if(num1==0 || num2==0 || num3==0) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(1~9사이의 숫자 입력)");
             }
              
             int[] arrNum = {num1,num2,num3};
             
             for(int i=0;i<randomNum.length;i++) {
                for(int j=0;j<arrNum.length;j++) {
                   if(randomNum[i]==arrNum[j]) {
                      if(randomNum[i]==arrNum[i]) {
                         strike++;
                         continue;
                      }
                      ball++;
                   }
                }
             }
             if(ball==0 && strike==0) {
                System.out.println(x);
             }
             else if(ball!=0 && strike==0) {
                System.out.println(ball+"볼");
             }
             else if(ball!=0 && strike!=0) {
                System.out.println(ball+"볼 "+strike+"스트라이크");
             }
             else if(ball==0 && strike!=0) {
                System.out.println(strike+"스트라이크");
                if(strike==3) {
                   System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                   System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                   String restart=scanner.next();
                   
                   if(!restart.equals("1") && !restart.equals("2")) {
                      throw new IllegalArgumentException("잘못된 값을 입력하셨습니다(1 또는 2 입력)");
                   }
                   if(restart.equals("1")) {
                      ball=0;
                      strike=0;
                      break restart;
                   }
                   else if(restart.equals("2")) {
                      break end;
                   }
                }
             }
             ball=0;
             strike=0;
         }
      }
   }
}