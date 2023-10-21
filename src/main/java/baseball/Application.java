package baseball;
import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        boolean flag1 = false;



        //1. 서로 다른 3자리의 수를 입력받는 객체
        Scanner sc = new Scanner(System.in);
        System.out.println("start baseball game");

        char[] Random_Baseball_numArr = new char[3];
        int Random_Baseball_Num =0;


        while(flag1 != true){
            boolean flag2 = false;
            //bound 900 => 0~899
            while(flag2 != true){
                //기능구현 3 근데 왜 random 인수값이 100단위에서 노니?

                Random rand = new Random();
                rand.setSeed(System.currentTimeMillis());
                Random_Baseball_Num = rand.nextInt(900)+100;
                System.out.println("Random_Baseball_Num =" + Random_Baseball_Num);
                String strRandom_Baseball_Num = Integer.toString(Random_Baseball_Num);
                Random_Baseball_numArr = strRandom_Baseball_Num.toCharArray();
                if(Random_Baseball_numArr[0] != Random_Baseball_numArr[1]){
                    if (Random_Baseball_numArr[1] != Random_Baseball_numArr[2]) {
                        if (Random_Baseball_numArr[0] != Random_Baseball_numArr[2]) {
                            flag2 = true;
                        }
                    }
                }
            }
            System.out.println(Random_Baseball_numArr + "   the number of computer's");
            // 지금 아니 왜 배열출력이 제대로 안되지?
            int strike=0;
            int ball=0;
            while( strike != 3){
                strike=0;
                ball=0;
                try{
                    System.out.println("input the nums");
                    int baseball_num = 0;
                    baseball_num = sc.nextInt();
                    //지금 asdf 넣으면 에러생김 예외처리 필수


                    if(100<=baseball_num && baseball_num<1000){
                        //기능구현 1
                        String strBaseball_num = Integer.toString(baseball_num);
                        char[] Baseball_numArr = strBaseball_num.toCharArray();
                        //기능구현 2
                        if(Baseball_numArr[0] != Baseball_numArr[1] && Baseball_numArr[1] != Baseball_numArr[2] && Baseball_numArr[0] != Baseball_numArr[2]){
                            //기능구현 4 입력으로 3개 받아서 스트라이크 볼 낫싱 확인

                            //스트라이크 확인하는거
                            //i j가 같으면 strike for문 사용, 다른경우는 ball +=1
                            System.out.println("checking random nums  " + Random_Baseball_Num);
                            System.out.println("checking intput nums  " + baseball_num);

                            for(int i=0 ; i<3; i++){
                                for(int j=0; j<3 ;j++){
                                     System.out.println("int i= " + i +"  int j= " + j);
                                    if(i==j){
                                        System.out.println(Random_Baseball_numArr);
                                        System.out.println(Baseball_numArr);
                                        if(Random_Baseball_numArr[i] == Baseball_numArr[j]){
                                            System.out.println("strike checking");
                                            System.out.println("Random num " + i + "= " + Random_Baseball_numArr[i]);
                                            System.out.println("User num " + j + "= " + Baseball_numArr[j]);
                                            strike++;
                                        }
                                    }else{
                                        if(Random_Baseball_numArr[i] == Baseball_numArr[j]){
                                            System.out.println("ball cheking");
                                            System.out.println("Random num " + i + "= " + Random_Baseball_numArr[i]);
                                            System.out.println("User num " + j + "= " + Baseball_numArr[j]);
                                            ball++ ;
                                        }
                                    }
                                }
                            }
                            if(ball!=0){
                                System.out.print(ball + "ball" + " ");
                            }
                            if(strike!=0){
                                System.out.print(strike + "strike" + " ");
                            }
                            if(ball == 0 && strike == 0){
                                System.out.print("nothing");
                            }
                            System.out.println();

                        }else{
                            System.out.println("OMG! you input over the same of two numbers. Error.");
                            IllegalArgumentException e;
                        }

                    }else{
                        System.out.println("OMG! should input the nums well in range. Error.");
                        IllegalArgumentException e;
                    }
                }catch(IllegalArgumentException e){
                    System.out.println("no. should not input out of variable");
                }
                //-- 0< num <1000
                //-- 변수 숫자가 아니어도 오류
                //-- tochararray 변환해서 length 3자리 이상일경우 IllegalArgumentException
                // try catch문으로 IllegalArgumentException e로 처리.
            }
            System.out.println("3 strike! game finished");
            boolean flag3 = false;
            while(flag3 != true){
                try {
                    System.out.println("want to finish a this game? 1. continue 2. exit");
                    int choice;
                    choice = sc.nextInt();
                    if(choice == 1){
                        flag3 = true;
                    }else if(choice == 2){
                        flag1 = true;
                        flag3 = true;
                    }else{
                        System.out.println("Should input num 1 or 2");
                        IllegalArgumentException e;
                    }
                }catch (IllegalArgumentException e){
                    System.out.println("no. should not input out of variable");
                }
            }
        }
    }
}
