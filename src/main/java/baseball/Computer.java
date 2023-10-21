package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    Computer () {
    }
   public static String generateRandomNumber(){
       StringBuilder computer = new StringBuilder(new String());
       while (computer.length() < 3) {

           String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
           if (!computer.toString().contains(randomNumber)) {
               computer.append(randomNumber);
           }
       }
       return computer.toString();
   }
}
