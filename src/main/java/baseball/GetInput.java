package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GetInput {
    public List<Integer> getComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        System.out.println(computer);
        return computer;
    }
    public List<Integer> getPlayerNum() {
        System.out.print("숫자를 입력해 주세요 : ");
        String scan = Console.readLine();
        int checkint = 0;
        try {
            checkint = Integer.parseInt(scan);
        } catch(NumberFormatException ime) {
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
        if(scan.length() != 3)
            throw new IllegalArgumentException("3글자 입력하세요");
        List<Integer> player = new ArrayList<>();
        List<Integer> checkDupList = new ArrayList<>();
        for(String num : scan.split("")) {
            player.add(Integer.parseInt(num));
            checkDupList.add(Integer.parseInt(num));
        }
        long checkDup = checkDupList.stream().distinct().count();
        if(player.size() != checkDup)
            throw new IllegalArgumentException("중복 제외 숫자 입력하세요");
        return player;
    }
}