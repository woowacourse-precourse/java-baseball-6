package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int eog = 0; // end of game 게임 종료
        int strike = 0;
        int ball = 0;

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(eog == 0){ // 게임 완전히 안 끝남.

            // 값 생성
            List<Integer> computer = createRandomVariable();

            while(strike != 3){

                // strike, ball 초기화
                strike = 0;
                ball = 0;

                try{
                    System.out.print("숫자를 입력해주세요 : ");

                    // user input이 담기는 장소
                    int number = isValidNumber();

                    List<Integer> numberList = new ArrayList<>();
                    numberList.add(number/100);
                    numberList.add((number%100)/10);
                    numberList.add(number%10);

                    // ball strike 결과 받아오기
                    ball = getBallValue(computer, numberList);
                    strike = getStrikeValue(computer, numberList);

                    // 결과 출력문 작성
                    String result = getResult(strike, ball);

                    System.out.println(result);

                    // 정답의 경우?
                    if(strike == 3){
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        // 콘솔에서 읽는 값.
                        String sfns = Console.readLine();

                        int fns;
                        try{
                            fns = Integer.parseInt(sfns);

                            if(fns == 1)
                                eog = 0;
                            else if (fns ==  2){
                                eog = 1;
                            }
                            else // 1,2가 아닌 다른 값 넣으면 Illegal
                                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");

                        } catch(NumberFormatException e){
                            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                        }

                    }

                } catch(IllegalArgumentException e){
                    // exit이 아닌 방법으로 종료는 정상종료(숫자가 아니거나 형식과 다른 경우)
                    strike = 3;
                    eog = 1;
                }
            }

            strike = 0;

        }
    }

    // 숫자야구 랜덤 값 생성 함수
    public static List<Integer> createRandomVariable(){
        // 숫자 3개 생성
        List<Integer> computer = new ArrayList<>();

        while(computer.size()< 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 숫자가 문자가 아닌지 숫자라도 정해진 양식에서 벗어났는지 체크
    // 만약에 문자라면 -> InputMismatchException -> IllegalArgException
    // 숫자가 양식이 틀리면 -> IllegalArgException
    // 맞으면 숫자 return
    public static int isValidNumber(){

        String snumber = Console.readLine();
        int number;

        // 숫자인지 아닌지 판별
        try{
            number = Integer.parseInt(snumber);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.", e);
        }

        // user 입력 숫자 판별
        int first;
        int second;
        int third;

        // 숫자 값이 3자리가 아닌 경우
        if(number < 100 || number > 999)
            throw new IllegalArgumentException("값의 입력범위를 넘었습니다.");
        else{

            // 각 자릿수 구하기
            first = number/100;
            second = (number%100)/10;
            third = (number%10);

            // 한 쌍이라도 값이 같으면? 예외처리
            if(first == second || second == third || first == third)
                throw new IllegalArgumentException("숫자의 양식이 주어진 양식이 아닙니다");

            // 숫자에 하나라도 0이 있는 경우 왜냐하면 1-9까지니까
            if(second == 0 || third == 0)
                throw new IllegalArgumentException("숫자의 양식이 주어진 양식이 아닙니다.");
        }



        return number;
    }

    public static int getBallValue(List<Integer> computer, List<Integer> numberList){
        // return할 ball 값
        int ball = 0;

        // 자동생성 자리별 값
        int computer0 = computer.get(0);
        int computer1 = computer.get(1);
        int computer2 = computer.get(2);

        // 유저입력 자리별 값
        int numberList0 = numberList.get(0);
        int numberList1 = numberList.get(1);
        int numberList2 = numberList.get(2);

        if(computer0 == numberList1 || computer0 == numberList2)
            ball++;
        if(computer1 == numberList0 || computer1 == numberList2)
            ball++;
        if(computer2 == numberList1 || computer2 == numberList0)
            ball++;

        return ball;
    }

    // strike 값 가져오기
    public static int getStrikeValue(List<Integer> computer, List<Integer> numberList){
        // return할 strike 값
        int strike = 0;

        // 자동생성 자리별 값
        int computer0 = computer.get(0);
        int computer1 = computer.get(1);
        int computer2 = computer.get(2);

        // 유저입력 자리별 값
        int numberList0 = numberList.get(0);
        int numberList1 = numberList.get(1);
        int numberList2 = numberList.get(2);

        if(computer0 == numberList0)
            strike++;

        if(computer1 == numberList1)
            strike++;

        if(computer2 == numberList2)
            strike++;

//        System.out.println(computer0);
//        System.out.println(computer1);
//        System.out.println(computer2);
//        System.out.println(numberList0);
//        System.out.println(numberList1);
//        System.out.println(numberList2);
        return strike;
    }

    // strike ball값 보고 출력 값 생성
    public static String getResult(int strike, int ball){

        String result;

        if(strike == 0){
            if(ball == 0){ // 아무것도 못 맞춤
                result = "낫싱";
                return result;
            }
            else{ // 볼만
                result = ball + "볼";
                return result;
            }
        }
        else{
            if(ball == 0){ // 스트라이크만
                result = strike + "스트라이크";
                return result;
            }
            else{ // 볼 스트라이크
                result = ball + "볼" + " " + strike + "스트라이크";
                return result;
            }
        }

    }
}
