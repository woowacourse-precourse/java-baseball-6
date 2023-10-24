package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.StreamWriting;

/**
 * 숫자야구.
 */
public class Application {

    /**
     * 메인 함수.
     * @param args
     * a
     */
    public static void main(String[] args) {
        List<Integer> computer = randomNumber();
        System.out.println(computer);
        boolean bool = true;

        while (bool) {
            List<Integer> user;
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            user = userNumer(input);
            Map<String, Integer> judgment = compareNumber(computer, user);
            if(checkAnswer(judgment)){
                if(!correctAnswer(computer)){
                    computer = randomNumber();
                }
                else{
                    bool = false;
                }
            }
        }
    }

    /**
     * 중복되지 않는 랜덤한 3개의 숫자를 만듦
     *
     * @return Random 3 Numbers
     */
    private static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(number)) {
                computer.add(number);
            }
        }
        return computer;
    }

    /**
     * user의 input을 받아 Integer로 변환하고 예외처리하는 메소드
     * @param input(String)
     * @return List<Integer>
     */
    private static List<Integer> userNumer(String input){
        final int maxNumber = 3;
        List<Integer> user = new ArrayList<>();

        try{
            // 좌우의 공백문자를 제거하는 trim을 사용하고, 문자의 크기가 3이 아닐시 IllegalArgumentException
            if(input.trim().length() != maxNumber){
                throw new IllegalArgumentException();
            }
            // parseInt와 substring을 사용해서 User input의 문자열을 나누고, int로 변환하는 과정
            int firstNumber = parseInt(input.substring(0,1));
            int secondNumber = parseInt(input.substring(1,2));
            int thirdNumber = parseInt(input.substring(2,3));
            // 변환된 int를 user라는 list에 담음.
            user.add(firstNumber);
            user.add(secondNumber);
            user.add(thirdNumber);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }
        // HashSet을 사용해서 중복된 숫자를 제거
        Set<Integer> set = new HashSet<>(user);
        List<Integer> dist = new ArrayList<>(set);

        //중복 숫자를 제거한 후에 길이를 검사
        if (dist.size() < maxNumber) {
            // user의 데이터가 문자열이거나 3보다 작다면 IllegalArgumentException
            throw new IllegalArgumentException();
        }

        return user;
    }

    /**
     * 랜덤한 3자리의 숫자(computer)와 user의 input을 받아서 값을 비교하고 strikes와 ball을 리턴
     * @param computer
     * @param user
     * @return judgment
     */
    private static Map<String, Integer> compareNumber(List<Integer> computer, List<Integer> user){
        int length = computer.size();
        int strikes = 0;
        int balls = 0;
        Map<String, Integer> judgment = new HashMap<>();
        for (int i = 0; i < length; i++) {
            // computer의 i번째 숫자와 user의 i번째 숫자가 같을 경우 strikes++
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
            }
            // 같은 자리의 숫자가 같은 경우가 없으니 contains를 사용해 다른 자리의 숫자가 같을 경우 balls++
            else if (computer.contains(user.get(i))) {
                balls++;
            }
        }
        judgment.put("strikes", strikes);
        judgment.put("balls", balls);

        return judgment;
    }

    /**
     * user의 input이 정답인지 확인
     * @param judgment
     * @return boolean
     */
    private static boolean checkAnswer(Map<String, Integer> judgment){
        boolean isThreeStrikes = false;
        int strikes = judgment.get("strikes");
        int balls = judgment.get("balls");
        // strike와 ball이 모두 0이면 "낫싱" 출력
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
        // 아닐 경우 strike와 ball 모두 출력
        else {
            System.out.print(balls + "볼 ");
            System.out.println(strikes + "스트라이크");
        }

        //3개의 숫자를 모두 맞췄을 경우
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다 !");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isThreeStrikes = true;
        }
        return isThreeStrikes;
    }

    /**
     * 유저의 input이 정답일 경우 게임 실행 여부
     * @param computer
     * @return boolean
     */
    private static boolean correctAnswer(List<Integer> computer){
        boolean isGameOver = false;
        String result = readLine();
        try { // 사용자의 result결과에 따른 try, catch
            int resultNumber = parseInt(result);
            if (resultNumber == 1) {
                return isGameOver;
            } else if (resultNumber == 2) {
                System.out.println("게임 종료");
                isGameOver = true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return isGameOver;
    }
}
