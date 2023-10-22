package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * GameItem 인터페이스를 구현한 클래스입니다.
 * 무작위로 숫자를 선택하고 스트라이크와 볼을 검사하는 메서드들을 제공합니다.
 * 
 * @author 김지환
 */
public class GameItemImpl implements GameItem {
    
    /**
     * 무작위로 1~9사이의 숫자 3개를 선택하여 리스트를 반환하는 메서드
     * @return 1부터 9 사이의 중복되지 않는 3개의 숫자로 이루어진 리스트
     */
    @Override
    public List<Integer> computer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 스트라이크와 볼의 개수에 따라 메시지를 출력하는 메서드입니다.
     * 
     * @param strike 스트라이크 개수
     * @param balls 볼 개수
     */
    @Override
    public void showStrikeAndBall(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (strikes != 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls != 0) {
            System.out.println(balls + "볼");
        }
    }
    
    /**
     * 스트라이크와 볼을 검사하고, 3스트라일 경우 게임을 종료합니다.
     * 
     * @param numList 사용자가 입력한 숫자 리스트
     * @param computer 컴퓨터가 선택한 숫자 리스트
     * 
     * @return 게임이 종료되면 true, 아니면 false
     */
    @Override
    public boolean checkForStrikes(List<Integer> numList, List<Integer> computer) {
        int strikes = 0;
        int balls = 0;
        boolean yn = false;
        for (int i = 0; i < 3; i++) {
            if (numList.get(i) == computer.get(i)) {
                strikes++;
            } else if (computer.contains(numList.get(i))) {
                balls++;
            }
            
        }
        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            yn = true;
        } else if (strikes != 3) {
            showStrikeAndBall(strikes, balls);
        }
        return yn;
    }
        
    /**
     * 숫자 리스트에 중복된 숫자가 있는지 확인합니다.
     * 
     * @param numList 숫자 리스트
     * @return 중복된 숫자가 있으면 true, 아니면 false
     */
    @Override
    public boolean isDuplicated(List<Integer> numList) {
        Set<Integer> number = new HashSet<Integer>(numList);
        return number.size() != numList.size();
    }
    
    /**
     * 입력된 문자열의 길이가 3인지 확인하는 메서드입니다.
     * 
     * @param input 사용자 입력 문자열
     * @return 문자열의 길이가 3이 아닐경우 true, 아니면 false
     */
    @Override
    public boolean validateLength(String input) {
        return input.length() != 3;
    }

}
