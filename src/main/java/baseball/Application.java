package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //컴퓨터 랜덤값 생성 함수(매개변수x, 리턴값 ArrayList<Integer>)
    public static List<Integer> makeRandom(){
        List<Integer> computer = new ArrayList<>();
//        System.out.println(computer.size());    //0
        while (computer.size() < 3) {    //0
            int randomNumber = Randoms.pickNumberInRange(1, 9); //랜덤숫자 1개
            if (!computer.contains(randomNumber)) { //컴퓨터수는 중복된 수가 없어야함
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //사용자 입력값 받는 함수(매개변수x, 리턴값 ArrayList<Integer>)
    //예외처리
    //1. 3글자가 아닐 때 3보다 작거나 3초과일때
    //2. 숫자가 아닌 경우 그러니까 아스키코드로 0~9가 아닌 것
    //--- 띄어쓰기가 들어갔을때(1,2에서 걸러짐)
    //3. 중복된 수가 입력됐을 때
    public static List<Integer> inputUser() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외처리
        //1. 입력값이 3글자가 아닐 때
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
        //2. 숫자가 아닌 경우(아스키코드로 0~9가 아닌 것)
        for(int i=0; i<input.length(); i++){
            if('0' > input.charAt(i) && input.charAt(i) > '9'){
                throw new IllegalArgumentException();
            }
        }
        //3. 중복된 수가 입력됐을 떄
        String[] arr = input.split("");
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(inputNum.contains(Integer.parseInt(arr[i]))){
                throw new IllegalArgumentException();
            }
            inputNum.add(Integer.parseInt(arr[i]));
        }
        return inputNum;
    }

    // 입력값과 컴퓨터값 비교
    // (매개변수(ArrayList<Integer>inputNum, ArrayList<Integer>computer))
    // 리턴값 void
    public static void play(){
        //컴퓨터 랜덤값
        List<Integer> computer = makeRandom();
        System.out.println("computer = " + computer);
        
        while (true) { //strike=0
            // 3 스트라이크가 되면 종료
            int strike = 0;
            int ball = 0;
            
            //사용자 입력값
            List<Integer> inputNum = inputUser();

            //computer[425] 입력값[123]
            // 입력값을 하나씩 읽어가면서 컴퓨터값 배열 다 비교
            for (int i = 0; i < inputNum.size(); i++) {
                for (int j = 0; j < computer.size(); j++) { //i=1, j=1
                    //입력값하나와 컴퓨터값 모두를 비교
                    if(inputNum.get(i) == computer.get(j) && i == j){
                        // 수가 같고 자리까지 같으면 스트라이크
                        strike++;
                    }
                    if(inputNum.get(i) == computer.get(j) && i != j){
                        // 수가 같고 자리가 다르면 볼
                        ball++;
                    }

                }
            } // 값 비교 완료

            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            if (strike == 3) {
                System.out.println();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                //while밖으로 빼자. 어차피 3스트라이크면 게임종료니까
//                int yesOrNo = replay();
//                if(yesOrNo==1){ //재시작
//                    play();
//                }
//                if(yesOrNo==2){//게임종료
//                    break;
//                }
                break;
            }

            System.out.println();

        } //while

        int yesOrNo = replay();
        if(yesOrNo==1){ //재시작
            play();
        }
        if(yesOrNo==2){//게임종료
            //코드X
            //if를 1과 2가 아닐때 예외처리날리면 될듯
        }

    }

    //게임 재시작(1), 종료(2) 입력 받는 함수
    //매개변수x, 리턴값 int
    //예외 무조건 1,2만 가능
    //입력받는수가 한자릿수이상이거나, 공백이거나, 수가 아닐경우 예외처리
    public static int replay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    //게임 재시작(1), 종료(2) 함수 (매개변수 int, 리턴값 void)

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //컴퓨터 랜덤값 생성 기능
//        List<Integer> computer = new ArrayList<>();
////        System.out.println(computer.size());    //0
//        while (computer.size() < 3) {    //0
//            int randomNumber = Randoms.pickNumberInRange(1, 9); //랜덤숫자 1개
//            if (!computer.contains(randomNumber)) { //컴퓨터수는 중복된 수가 없어야함
//                computer.add(randomNumber);
//            }
//        }

        // 컴퓨터 숫자 확인
//        System.out.print("computer: ");
////        for (Integer integer : computer) {
////            System.out.print(integer);
////        }
//        System.out.println(computer);
////        System.out.println(computer.get(2));
//
//        System.out.println();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //찐게임시작
        try{
            play();
        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException 예외 발생");
        }

        //예외확인
//        try{ // 예외가 발생할 지도 모르는 코드
//            inputUser();
//        } catch(IllegalArgumentException e){
//            System.out.println("IllegalArgumentException 예외 발생");
//        }


        // 사용자 값 입력 받는 기능
        // 서로 다른 3자리의 수 => 잘못된 값을 입력할 경우 예외 발생 후 종료
        // 길이가 3이 아니거나 중복된 수가 존재할 경우 예외
        // 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수
//        System.out.print("숫자를 입력해주세요 : ");
//        String input = Console.readLine();
//        String[] arr = input.split("");
//        List<Integer> inputNum = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            inputNum.add(Integer.parseInt(arr[i]));
//        }
//        System.out.println("입력값 : " + inputNum);

        //랜덤값과 입력값 비교
        // play 함수로 빼겠음
//        while (true) { //strike=0
//            // 3 스트라이크가 되면 종료
//            int strike = 0;
//            int ball = 0;
//
//            System.out.print("숫자를 입력해주세요 : ");
//            String input = Console.readLine();
//            String[] arr = input.split("");
//            List<Integer> inputNum = new ArrayList<>();
//            for (int i = 0; i < arr.length; i++) {
//                inputNum.add(Integer.parseInt(arr[i]));
//            }
////            System.out.println("입력값 : " + inputNum);
//
//            //computer[425] 입력값[123]
//            // 입력값을 하나씩 읽어가면서 컴퓨터값 배열 다 비교
//            for (int i = 0; i < inputNum.size(); i++) {
//                for (int j = 0; j < computer.size(); j++) { //i=1, j=1
//                    //입력값하나와 컴퓨터값 모두를 비교
//                    if(inputNum.get(i) == computer.get(j) && i == j){
//                        // 수가 같고 자리까지 같으면 스트라이크
//                        strike++;
//                    }
//                    if(inputNum.get(i) == computer.get(j) && i != j){
//                        // 수가 같고 자리가 다르면 볼
//                        ball++;
//                    }
//
//                }
//            } // 값 비교 완료
//
//            if (ball > 0) {
//                System.out.print(ball + "볼 ");
//            }
//            if (strike > 0) {
//                System.out.print(strike + "스트라이크");
//            }
//            if (ball == 0 && strike == 0) {
//                System.out.print("낫싱");
//            }
//            if (strike == 3) {
//                System.out.println();
//                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                break;
//            }
//
//            System.out.println();
//
////            System.out.println("숫자를 입력해주세요 : ");//스트라이크가 될때까지 반복
////            input = Console.readLine();
////            arr = input.split("");
////            inputNum = new ArrayList<>();
////            for (int i = 0; i < arr.length; i++) {
////                inputNum.add(Integer.parseInt(arr[i]));
////            }
//        }


    }
}
