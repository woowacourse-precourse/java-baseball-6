package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            //랜덤한 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 스트라이크, 볼 숫자 초기화
            int strike = 0;
            int ball = 0;
            while (strike<3) {
                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요: ");
                
                // 플레이어 숫자 입력
                String player_num = Console.readLine();

                // 입력값 확인
                List<Integer> player = new ArrayList<>();
                parseInput(player_num, player);
                validateInput(player);

                // 숫자 비교
                for(int i = 0; i < computer.size(); i++) {
                    if (player.get(i)==computer.get(i)) {
                        strike++;
                    } else if (computer.contains(player.get(i))) {
                        ball++;
                    }
                }
                
                // 출력
                if (strike==0 && ball==0) {
                    System.out.println("낫싱");
                } else {
                    if (strike != 0 && ball != 0) {
                        System.out.print(ball + "볼 "+ strike + "스트라이크\n");
                    } else if (strike == 0) {
                        System.out.println(ball + "볼");
                    } else {
                        System.out.println(strike + "스트라이크");
                    }
                }
            }
            
            //게임 종료 및 재시작
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitNum = Console.readLine();
            if (!validRestartInput(exitNum)) {
                break;
            }
        }
    }
    private static void parseInput(String input, List<Integer> player) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
        try {
            String[] strArray = input.split("");
            player.add(Integer.parseInt(strArray[0]));
            player.add(Integer.parseInt(strArray[1]));
            player.add(Integer.parseInt(strArray[2]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식의 입력이 아닙니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
    private static void validateInput(List<Integer> numbers) {
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException("0~9까지의 숫자가 아닙니다.");
        } else if (!isValidDuplicated(numbers)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private static boolean isValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }

    private static boolean validRestartInput(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num == 1) {
                return true;
            } else if(num == 2) {
                return false;
            }else {
                throw new IllegalArgumentException("1 또는 2를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}