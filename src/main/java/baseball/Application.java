package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
public static void main(String[] args) {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    System.out.println("숫자 야구 게임을 시작합니다.");

    boolean flag = true;

    try {
        while (flag) {
//            System.out.println("computer: " + computer);
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            int number = Integer.parseInt(input);

            if (number <= 0 || number > 999 || !IsDifferentDigits(number)) {
                throw new IllegalArgumentException();
            }

            int cntSame = GetSameNumbers(computer, number);
            int cntStrike = GetStrike(computer, number);

            String msg = CheckStrikeBall(cntSame, cntStrike);
            System.out.println(msg);
            if (cntStrike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String inputLast = Console.readLine();
                int selectLast = Integer.parseInt(inputLast);

                switch (selectLast) {
                    case 1:
                        computer.clear();
                        while (computer.size() < 3) {
                            int randomNumber = Randoms.pickNumberInRange(1, 9);
                            if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                            }
                        }
                        break;
                    case 2:
                        flag = false;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

            }
        }

    } catch (RuntimeException e) {

        throw new IllegalArgumentException();

    }

}

static boolean IsDifferentDigits(int number) { // 다 다르면 true
    boolean flag = false;
    Set<Integer> set = NumbersToSet(number);
    if (set.size() == String.valueOf(number).length()) {
        flag = true;
    }
    return flag;
}


static Set<Integer> NumbersToSet(int number) {
    Set<Integer> set = new LinkedHashSet<>();
    while (number > 0) {
        int digit = number % 10;
        set.add(digit);
        number /= 10;
    }
    return set;
}

static List<Integer> NumbersToList(int number) {
    List<Integer> list = new ArrayList<>();
    while (number > 0) {
        int digit = number % 10;
        list.add(0, digit);
        number /= 10;
    }
    return list;
}

static Integer GetSameNumbers(List<Integer> computer, int number) {
    Integer cntSame;
    Set<Integer> computerSet = new HashSet<>(computer);
    Set<Integer> set = NumbersToSet(number);
    set.retainAll(computerSet); // 동일한 원소만 남김
    cntSame = set.size();
    return cntSame;
}

static Integer GetStrike(List<Integer> computer, int number) {
    Integer cntStrike = 0;
    List<Integer> list = NumbersToList(number);
    for (int i = 0; i < computer.size(); i++) {
        if (list.get(i) == computer.get(i)) {
            cntStrike++;
        }
    }
    return cntStrike;
}

static String CheckStrikeBall(Integer cntSame, Integer cntStrike) {
    String msg = "";
    if (cntSame == 0) {
        msg = "낫싱";
    } else {
        if (cntSame - cntStrike != 0) {
            if (cntStrike == 0) {
                msg += cntSame + "볼";
            } else {
                msg += (cntSame - cntStrike) + "볼 " + cntStrike + "스트라이크";
            }
        } else {
            msg += cntStrike + "스트라이크";
        }
    }

    return msg;
}

}
