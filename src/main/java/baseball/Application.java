package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> get_random_numbers(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
    public static boolean check_user_input(String userInput){
        // 아무것도 입력 하지 않음
        if (userInput == null) {
            return false;
        }
        // user_input 길이를 확인 (3자리)
        if(userInput.length()!=3){
            return false;
        }
        // user_input이 모두 숫자 인지 확인
        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
    public static List<Integer> convert_user_input(String userInputStr){
        List<Integer> userInput = new ArrayList<>();

        for (char ch : userInputStr.toCharArray()){
            userInput.add(Character.getNumericValue(ch));
        }

        return userInput;
    }
    public static List<Integer> compare_computer_to_user(List<Integer> computer, List<Integer> user){
        int strike = 0, ball = 0;
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<computer.size();i++){
            if(user.get(i).equals(computer.get(i))) {
                strike++;
            } else if(computer.contains(user.get(i))){
                ball++;
            }
        }

        result.add(ball);
        result.add(strike);

        return result;
    }
    public static void print_result(List<Integer> result){
        String answer = "";

        if (result.get(0)>0){
            answer += result.get(0) + "볼 ";
        }

        if (result.get(1)>0){
            answer += result.get(1) + "스트라이크 ";
        }

        if (answer.isEmpty()){
            answer = "낫싱";
        }

        System.out.println(answer);
    }
    public static void main(String[] args) {

        // 중복 없는 3자리 수 만들기
        List<Integer> computer = get_random_numbers();
        System.out.println("컴퓨터: " + computer);
        // 사용자 입력 받기
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        System.out.println();
        //System.out.println("사용자 입력: " + userInputStr);

        // 사용자 입력 유효성 확인
        if (!check_user_input(userInput)){
            // TODO : IllegalArgumentException 발생 후 종료
            System.out.println("입력 잘못 했네!");
        }

        // 사용자 입력을 String -> List<Integer>로 변환
        List<Integer> user = convert_user_input(userInput);
        System.out.println("사용자 입력: " + user);

        // 비교 하기 : [볼, 스트라이크]
        List<Integer> compareResult = compare_computer_to_user(computer, user);

        // 결과 출력
        print_result(compareResult);

    }
}
