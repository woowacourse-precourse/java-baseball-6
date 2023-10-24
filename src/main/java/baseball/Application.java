package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean terminate = false; //게임실행조건
        while (!terminate) {
            HashMap<Integer, Integer> comNum = generateValues();
            boolean isCorrect = false; // 매 판마다 정답여부 초기화
            while (!isCorrect) {
                HashMap<Integer, Integer> userNum = getUserInput();
                Map<String, Integer> result = compare(userNum, comNum);
                // checkIfCorrect(result) = true 이면 안쪽 반복문 종료조건 만족
                isCorrect = checkIfCorrect(result);
                if (isCorrect) {
                    terminate = promptFinish(); //바깥쪽 반복문 종료 조건 만족
                }
            }
        }
        // 게임이 최종 종료되면 스캐너 닫기
        Console.close();
    }
    private static HashMap<Integer, Integer> generateValues() {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int newNum = Randoms.pickNumberInRange(1, 9); //첫번째로 랜덤 넘버 생성
            // i = 0일때 항상 false, i = 1 or 2 일때 중복되는 숫자 나올시 재추첨
            while (numbers.containsKey(newNum)) {
                newNum = Randoms.pickNumberInRange(1, 9);
            }
            numbers.put(newNum, i);
        }
        return numbers;
    }

    private static HashMap<Integer, Integer> getUserInput() throws IllegalArgumentException{
        HashMap<Integer, Integer> userNumbers= new HashMap<Integer, Integer>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        // 정규식으로 입력값이 숫자만 포함하는지 확인
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        else if(userInput.length() != 3){
            throw new IllegalArgumentException("허용되는 숫자는 3자리입니다.");
        }
        // String 입력값을 int 타입으로 전환
        int userNum = Integer.parseInt(userInput);
        //입력순서에 따라 인덱스 할당위해 초기화
        int index = 0;

        for (int i = 1; i < 1000; i *= 10) {
            int num = userNum / (100 / i); // i = 1이면 100대 자리의 숫자, i = 10이면 10대 자리의 숫자, i = 100이면 1대 자리의 숫자
            // 이미 맵에 등록되어있는 숫자일 경우(중복된 숫자) 오류
            if (userNumbers.containsKey(num)){
                throw new IllegalArgumentException("숫자는 중복을 포함할 수 없습니다.");
            }
            // 중복이 아닐경우 맵에 추가
            userNumbers.put(num, index);
            // 입력된 초기숫자: abc(a*100 + b*10 + c*1), i = 1일때 abc - a*100 = bc, i = 10일때 bc - b*10 = c, i = 100일때 c - c*1 = 0
            userNum -= num * (100 / i);
            // 반복마다 인덱스 1씩 추가
            index += 1;
        }
        return userNumbers;
    }

    private static Map<String, Integer> compare(HashMap<Integer, Integer> userMap, Map<Integer, Integer> comMap){
        Map<String, Integer> resultMap = new HashMap<>();
        // 유저가 선택한 숫자를 위치별로 반복
        for (int num : userMap.keySet()){
            // 랜덤숫자에 각 위치의 유저숫자가 포함되는지 확인
            if (comMap.containsKey(num)){
                // 값이 같고 인덱스도 같으면 맵의 키인 "스트라이크"의 값에 1을 더함
                if (userMap.get(num) == comMap.get(num)){
                    resultMap.put("Strike", resultMap.getOrDefault("Strike", 0) + 1);
                }
                // 값이 같고 인덱스가 다르면 맵의 키인 "볼"의 값에 1을 더함
                else if (userMap.get(num) != comMap.get(num)){
                    resultMap.put("Ball", resultMap.getOrDefault("Ball", 0) + 1);
                }
            } // 값이 다르면 아무것도 맵에 더하지 않음
        }
        return resultMap;
    }

    private static boolean checkIfCorrect(Map<String, Integer> resultMap){
        String result;
        boolean isCorrect = false;
        // 맵에서 볼과 스트라이크의 숫자 불러오기
        int strike = resultMap.getOrDefault("Strike", 0);
        int ball = resultMap.getOrDefault("Ball", 0);
        if (strike == 0 && ball == 0){ result = "낫싱"; }
        else if (strike == 0){
            result = ball + "볼";
        }
        else if (ball == 0) {
            result = strike + "스트라이크";
            // 볼이 0개고 스트라이크가 3개면 정답, true 리턴
            if (strike == 3){
                isCorrect = true;
            }
        }
        else{
            result = ball + "볼 " + strike + "스트라이크";
        }
        System.out.println(result);
        // 3스트라이크가 아닌 경우에는 전부 false 리턴
        return isCorrect;
    }

    private static boolean promptFinish() throws IllegalArgumentException{
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        else if(!userInput.equals("1") && !userInput.equals("2")){
            throw new IllegalArgumentException("1자리의 수가 아닙니다.");
        }
        return Integer.parseInt(userInput) == 2;
    }
}






