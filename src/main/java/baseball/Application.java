package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart(1);
    }

    // 게임 시작 메소드
    public static void gameStart(int status){
        // status 가 1이면 게임 실행 1이 아닌 경우 게임 종료
        if(status == 1){
            // 게임 실행 문구 출력
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 컴퓨터 숫자 리스트 생성
            List<Integer> computer = computerNumber();
            // 맞춘 상태를 false 로 지정
            boolean isCorrect = false;
            // 만약 맞추지 못한 상태라면 계속 while 문을 실행
            while(!isCorrect){
                // 숫자 입력받기
                System.out.print("숫자를 입력해주세요 : ");
                // 사용자의 입력 받기
                String numbers = Console.readLine();
                // 사용자가 입력한 값이 숫자인지 비교한 이후 리스트에 저장
                List<Integer> userNumbers = numberList(numbers);
                // 입력한 숫자와 컴퓨터 숫자가 일치하는지 확인
                isCorrect = equals(userNumbers, computer);
            }
            // 맞다면 while 문 종료 이후 상태 숫자 입력 받기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            // 숫자 입력 받기
            String strStatus = Console.readLine();
            // 입력받은 숫자가 진짜 숫자인지 확인
            boolean isNumber = isNumber(strStatus);
            // 진짜 숫자가 맞다면 입력받은 숫자로 다시 메소드 실행 그렇지 않다면 exception 실행
            if(isNumber == true){
                status = Integer.parseInt(strStatus);
                // 입력받은 숫자로 다시 메소드 재실행
                gameStart(status);
            }else{
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
        }else if(status == 2){
            System.out.println("게임 종료");
        }
    }

    // 숫자 비교 메소드
    public static boolean equals(List<Integer> userNumbers, List<Integer> computer){
        // 볼 숫자를 저장할 변수 생성
        int ball = 0;
        // 스트라이크 숫자를 저장할 변수 생성
        int strike = 0;
        // 반복문으로 입력한 숫자들과 랜덤으로 생성된 숫자들을 비교 후 스트라이크, 볼 의 갯수를 증가
        for(int i = 0; i < computer.size(); i++){
            for(int j = 0; j < userNumbers.size(); j++){
                if(i == j && computer.get(i) == userNumbers.get(j)){
                    strike++;
                    break;
                }else if(computer.get(i) == userNumbers.get(j)){
                    ball++;
                    break;
                }
            }
        }
        // 스트라이크와 볼의 갯수를 가지고 출력 내용을 정한다.
        if(strike != 0 || ball != 0){
            if(strike != 0 && ball != 0){
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            }
            if(strike != 0 && ball == 0){
                System.out.println(strike + "스트라이크");
            }
            if(ball != 0 && strike == 0){
                System.out.println(ball + "볼");
            }
        }else{
            System.out.println("낫싱");
        }
        // 만약 숫자 3개를 모두 맞췄다면 게임이 종료 되었다는 문구를 출력한 이후 true 를 반환 그렇지 않다면 게임을 끝내지 않기 위해서 false 를 반환
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else{
            return false;
        }
    }

    // 컴퓨터 숫자 리스트 랜덤 생성 메소드
    public static List<Integer> computerNumber(){
        // 랜덤 숫자를 저장할 리스트 생성
        List<Integer> computer = new ArrayList<>();
        // 리스트의 총 길이가 3보다 작을 때만 반복
        while (computer.size() < 3) {
            // 1 ~ 9 사이의 랜덤 숫자를 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // 만약 생성한 숫자가 리스트에 없다면 리스트에 추가
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // 리스트 반환
        return computer;
    }

    // 사용자 숫자 리스트 생성 메소드
    public static List<Integer> numberList(String numbers){
        // 사용자 숫자 리스트 생성
        List<Integer> numberList = new ArrayList<>();
        // 사용자가 입력한 숫자를 숫자로 변환할 수 있는지 확인
        boolean isNumber = isNumber(numbers);
        // 만약 숫자들의 길이가 3보다 크거나 작다면 입력이 잘못된 것이므로 exception 을 실행
        if(numbers.length() > 3 || numbers.length() < 3){
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        // 만약 숫자로 변환이 불가능 하다면 입력이 잘못된 것이므로 exception 을 실행
        }else if(!isNumber){
            throw new IllegalArgumentException("입력하신건 숫자가 아닙니다.");
        // 모두 해당되지 않는다면 숫자들을 리스트에 저장
        }else{
            for(int i = 0; i < numbers.length(); i++){
                int num = Character.getNumericValue(numbers.charAt(i));
                numberList.add(num);
            }
        }
        // 리스트 반환
        return numberList;
    }

    // 입력값이 숫자인지 확인하는 메소드
    public static boolean isNumber(String numbers){
        // 입력한 문자열을 숫자로 변경해보고 변경이 된다면 true 를 반환하고 되지않는다면 숫자가 아니므로 false 를 반환
        try{
            Integer.parseInt(numbers);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
