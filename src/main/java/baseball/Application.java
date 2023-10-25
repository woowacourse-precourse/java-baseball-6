package baseball;

import camp.nextstep.edu.missionutils.Randoms;



import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int n = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            int[] computer = new int[10];
            for(int i=0; i<=9; i++) computer[i] = -1;
            int k = 1;
            while (k <= 3) {
                int rand = Randoms.pickNumberInRange(1,9);
                if(computer[rand] == -1) {
                    computer[rand] = k;
                    k++;
                }
            }

            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String num= readLine();
                try {
                    if (num.length() != 3) {
                        throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
                    }
                    int[] mul = new int[3];
                    for (int i = 0; i < 3; i++) {
                        mul[i] = Integer.parseInt(num.substring(i, i + 1));
                    }
                    if (mul[0] == mul[1] || mul[1] == mul[2] || mul[0] == mul[2]) {
                        throw new IllegalArgumentException("서로 다른 3자리수를 입력해주세요.");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
                }


                int strike = 0, ball = 0;
                for(int i=1; i<=3; i++){
                    int ch = num.charAt(i-1) - '0';
                    if(computer[ch] == -1) continue;
                    else {
                        int idx = computer[ch];
                        if(idx == i) strike++;
                        else ball++;
                    }
                }
                if(strike ==0 && ball!=0){
                    System.out.printf("%d볼\n",ball);
                }
                if(ball ==0 && strike!=0) {
                    System.out.printf("%d스트라이크\n",strike);
                }
                if(strike>0 && ball>0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                }
                if(strike==0 && ball==0){
                    System.out.println("낫싱");
                }
                if(strike == 3) {System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");break;}
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            n = Integer.parseInt(readLine());
            if (n != 1 && n != 2) {
                throw new IllegalArgumentException("1,2중에 입력하여야합니다.");
            }
        } while(n == 1);
    }
}

