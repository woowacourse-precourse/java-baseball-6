package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Array {
    private static final int START = 1;
    private static final int END = 9;
    int[] answer = new int[Game.NUMBER];
    int[] userInput = new int[Game.NUMBER];

    void getRandomAnswer(){
        int newNum;
         int answerIndex = 0;

         while(answerIndex < Game.NUMBER) {
             newNum = pickNumberInRange(START, END);

             if(!isValueInArray(newNum, answer)) {
                 answer[answerIndex] = newNum;
                 answerIndex++;
             }
         }
     }

     static boolean isValueInArray(int input, int[] arr) {
         for (int i : arr) {
             if (input == i) return true;
         }
         return false;
     }

     void getUserInput(){
        String strInput = readLine();
        throwError(strInput);

        for(int i = 0; i < Game.NUMBER; i++)
            userInput[i] = strInput.charAt(i) - '0';
     }

     void throwError(String str){
        checkInputDuplicates(str);
        checkInputFormat(str);
        checkInputLength(str);
     }

    void checkInputDuplicates(String str) {
        for (int i = 0; i < Game.NUMBER; i++) {
            for (int j = i + 1; j < Game.NUMBER; j++) {
                if (str.charAt(i) == str.charAt(j))
                    throw new IllegalArgumentException();
            }
        }
    }

    void checkInputLength(String str){
        if (str.length() != Game.NUMBER)
            throw new IllegalArgumentException();
    }

    void checkInputFormat(String str) {
        for (int i = 0; i < Game.NUMBER; i++) {
            if ('1' > str.charAt(i) || str.charAt(i) > '9')
                throw new IllegalArgumentException();
        }
    }
}