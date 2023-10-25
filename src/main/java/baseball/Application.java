package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;



import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int n = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            int[] arr = new int[10];
            for(int i=0; i<=9; i++) arr[i] = -1;
            int k = 1;
            while (k <= 3) {
                int rand = Randoms.pickNumberInRange(1,9);
                if(arr[rand] == -1) {
                    arr[rand] = k;
                    k++;
                }
            }

            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String num= readLine();
                if(num.length()!=3){
                    throw new IllegalArgumentException();
                }
                int[] mul = new int[3];
                for(int i=0; i<3; i++){
                    mul[i]=num.charAt(i) -'0';
                }
                if(mul[0]==mul[1] || mul[1]== mul[2] || mul[0]==mul[2]){
                    throw new IllegalArgumentException();
                }

               int s = 0, b = 0;
               for(int i=1; i<=3; i++){
                   int ch = num.charAt(i-1) - '0';
                   if(arr[ch] == -1) continue;
                   else {
                       int idx = arr[ch];
                       if(idx == i) s++;
                       else b++;
                   }
               }
               if(s ==0 && b!=0){
                   System.out.printf("%d볼\n",b);
               }
               if(b ==0 && s!=0) {
                   System.out.printf("%d스트라이크\n",s);
               }
               if(s>0 && b>0) {
                   System.out.printf("%d볼 %d스트라이크\n", b, s);
               }
               if(s==0 && b==0){
                   System.out.println("낫싱");
               }
            if(s == 3) {System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");break;}
                }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            n = Integer.parseInt(readLine());
        } while(n == 1);
    }
}

