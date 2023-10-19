package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static final int DIGIT = 3;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        playGame(DIGIT);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if(Console.readLine().equals("1")){
            playGame(DIGIT);
        }else if(Console.readLine().equals("2")){
            System.out.println("게임 종료\n");
        }
    }
    public static void playGame(int digit){
        List<Integer> pickedList = selectDigitNumbers(digit);

        String userInput = tryAnswer();
        while (!checkAnswer(userInput, pickedList)){
            userInput = tryAnswer();
        }
    }

    public static List<Integer> selectDigitNumbers(int digit){
        List<Integer> pickedList = new ArrayList<>();
        while(pickedList.size() < digit){
            int pickedRandomNum = Randoms.pickNumberInRange(1, 9);
            if(pickedList.contains(pickedRandomNum)) continue;
            pickedList.add(pickedRandomNum);
        }
        return pickedList;
    }

    public static String tryAnswer(){
        System.out.println("세개의 숫자를 입력해주세요. : ");
        String userInput = Console.readLine();
        try {
            validateInput(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return userInput;
    }
    public static void validateInput(String userInput) throws Exception {
        // 3자리 수가 아니거나, 숫자가 아니거나, 동일한 수가 있으면 에러
        boolean isDuplicate = Arrays.stream(userInput.split("")).distinct().count() != userInput.split("").length;
        boolean hasZero = userInput.contains("0");
        if(userInput.length() != 3 || isDuplicate || hasZero) throw new Exception();
    }

    public static boolean checkAnswer(String candidate, List<Integer> pickedList) {
        Map<String, Integer> resultMap = new HashMap<>();
        int[] parsedIntegerArray = Arrays.stream(candidate.split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < parsedIntegerArray.length; i++){
            if(pickedList.contains(parsedIntegerArray[i])){
                if(pickedList.get(i) == parsedIntegerArray[i]){
                    resultMap.put("strike", resultMap.containsKey("strike")? resultMap.get("strike")+1 : 1);
                }else{
                    resultMap.put("ball", resultMap.containsKey("ball")? resultMap.get("ball")+1 : 1);
                }
            }
        }
        printAnswer(resultMap);
        return resultMap.containsKey("strike") && resultMap.get("strike") == 3;
    }
    public static void printAnswer(Map<String, Integer> map){
        String strike = "";
        String ball = "";
        if(map.isEmpty()){
            System.out.println("낫싱");
        }
        if(map.containsKey("strike")){
            strike = map.get("strike") + "스트라이크";
        }
        if(map.containsKey("ball")){
            ball = map.get("ball") + "볼";
        }
        System.out.println(ball+" "+strike);
    }
}
