package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

//숫자를 랜덤으로 생성해서 게임 진행을 해주는 친구
public class GameManager {
    private Player player;
    private Computer computer;

    public GameManager(Computer computer, Player player)
    {
        this.computer = computer;
        this.player = player;
    }

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> inputNumbers = new ArrayList<>();
            String input = Console.readLine();
            for (int i = 0; i < input.length(); i++) {
                // 문자를 정수로 변환하여 리스트에 추가
                int digit = Character.getNumericValue(input.charAt(i));
                inputNumbers.add(digit);
            }
            player.setNumbers(inputNumbers);
            List<Integer> playerNumbers = player.getNumbers();
            if (!isValid(playerNumbers)) {
                throw new IllegalArgumentException();
            }
            int[] result = judge(playerNumbers);
            if (count_msg(result) == false)
                break ;
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            computer.changeNumber();
            startGame();
        }
        else if (input.equals("2")) {
            return ;
        }
        else
            throw new IllegalArgumentException();
    }
    private boolean count_msg(int[] result) {
        if (result[0] == 0 && result[1] == 0)
            System.out.println("낫싱");
        if (result[0] > 0 && result[1] > 0)
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        if (result[0] > 0 && result[1] == 0)
            System.out.println(result[0] + "스트라이크 ");
        if (result[0] == 0 && result[1] > 0)
            System.out.println(result[1] + "볼 ");
        if (result[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    private int[] judge(List<Integer> numbers){
        int[] result = new int[2];
        for (int i = 0; i < 3; i++){
            if (numbers.get(i) == computer.getNumbers().get(i)){
                result[0]++;
            }
            else{
                for (int j = 0; j < 3; j++) {
                    if (numbers.get(i) == computer.getNumbers().get(j)){
                        result[1]++;
                        break;
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(List<Integer> numbers){
        boolean isValid = true;
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 3){
            isValid = false;
        }
        if (numbers.size() != set.size())
            return false;
        else{
            for(Integer number : numbers){
                if (number < 0 || number > 9){
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }
}
