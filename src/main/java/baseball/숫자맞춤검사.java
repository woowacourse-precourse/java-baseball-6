package baseball;

import java.util.List;

public class 숫자맞춤검사 {

        private static List<Integer> computerNum;

        public 숫자맞춤검사(List<Integer> computerNum) {

                this.computerNum = computerNum;
        }

        public int 스트라이크개수(String strNum){

                내가입력한값검사하기(strNum);

                int strike = 0;

                for(int i=0; i<strNum.length(); i++){

                        int num = (int) strNum.charAt(i) - 48;

                        if(computerNum.contains(num) && computerNum.get(i) == num){

                                strike++;
                        }
                }

                return strike;
        }

        public int 볼개수(String strNum){

                내가입력한값검사하기(strNum);

                int ball = 0;

                for(int i=0; i<strNum.length(); i++){

                        int num = (int) strNum.charAt(i) - 48;

                        if(computerNum.contains(num) && !(computerNum.get(i) == num)){

                                ball++;
                        }
                }

                return ball;
        }

        public void 내가입력한값검사하기(String strNum){

                if(strNum.length() != 3){

                        throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }
        }

}
