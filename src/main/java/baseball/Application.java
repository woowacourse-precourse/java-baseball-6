package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

//현재 내가 한 방식은 단위테스트 방식으로 작업함
//TDD를 하려면 TEST코드 작성후 TEST로 집어넣은 내용들에서 오류가 나는것을 수정하여야함

import java.util.*;

//코드에 중복이 되는 요소가 없는가?
//한 메서드에 너무 많은 기능이 들어가 있지는 않는가?
//객체 간 기능의 분리가 잘 되어있는가?
//리팩토링
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
//사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

//        int pickNumberInList(final List<Integer> numbers)
//        int pickNumberInRange(final int startInclusive, final int endInclusive)
//        List<Integer> pickUniqueNumbersInRange
//        List<T> shuffle(final List<T> list)
//        void validateNumbers(final List<Integer> numbers)
//        void validateRange(final int startInclusive, final int endInclusive)
//        void validateCount(final int startInclusive, final int endInclusive, final int count)
//        String readLine() {
//                return getInstance().nextLine();
//            }
//        void close()
//        Scanner getInstance()

        boolean flag1 = false;

        //1. 서로 다른 3자리의 수를 입력받는 객체
        System.out.println("ㅁㄴㅇㅁㄴㄹㅇㄻㅇㄴstart baseball game");

        char[] Random_Baseball_numArr = new char[3];


        while(flag1 != true){
            boolean flag2 = false;
            //bound 900 => 0~899
            while(!flag2){
                //flag2 != true == !flag2
                //기능구현 3 근데 왜 random 인수값이 100단위에서 노니?

                String strRandom_Baseball_Num = Integer.toString(Randoms.pickNumberInRange(100,999));
                System.out.println("strRandom_Baseball_Num =" + strRandom_Baseball_Num);

//                List<Integer> computer = new ArrayList<>();
//                //리스트에 1~9까지 넣는데 이미 포함되어있으면 작업 X 크기 3까지 작업
//                while (computer.size() < 3) {
//                    int randomNumber = Randoms.pickNumberInRange(1, 9);
//                    if (!computer.contains(randomNumber)) {
//                        computer.add(randomNumber);
//                    }
                }


                Random_Baseball_numArr = strRandom_Baseball_Num.toCharArray();
//                LinkedHashSet<Character> set = new LinkedHashSet<>();
//                linked hashset은 순서 유지됨
//                for(int i=0 ; i<Random_Baseball_numArr.length; i++){
//                    set.add(Random_Baseball_numArr[i]);
//                    System.out.println(Random_Baseball_numArr[i]);
//                }
//                // 왜 중복제거 안되지?
//                if(Random_Baseball_numArr.length ==3){
//                    flag2=true;
//                }
                if(Random_Baseball_numArr.length==3){
                    if(Random_Baseball_numArr[0] != Random_Baseball_numArr[1]){
                        if (Random_Baseball_numArr[1] != Random_Baseball_numArr[2]) {
                            if (Random_Baseball_numArr[0] != Random_Baseball_numArr[2]) {
                                flag2 = true;
                            }
                        }
                    }
                }
            }
            // 지금 아니 왜 배열출력이 제대로 안되지?
            int strike=0;
            int ball=0;
            while( strike != 3){
                strike=0;
                ball=0;
                try{
                    System.out.println("input the nums");
                    String str_baseball_num = Console.readLine();
                    int baseball_num = Integer.valueOf(str_baseball_num);
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
                            System.out.println("checking random nums  " + strBaseball_num);
                            System.out.println("checking intput nums  " + baseball_num);

                            //비교하는 좋은 방법 체크
                            //그리고 객체 분리.
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
            while(!flag3){
                //!flag3 = true
                try {
                    System.out.println("want to finish a this game? 1. continue 2. exit");
                    String choice = Console.readLine();
                    if(choice.length()!= 1){
                        System.out.println("should input only 1");
                        IllegalArgumentException e;
                    }else if(Integer.valueOf(choice) == 1){
                        flag3 = true;
                    }else if(Integer.valueOf(choice) == 2){
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
