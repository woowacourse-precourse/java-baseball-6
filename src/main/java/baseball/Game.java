package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game{

        Input input = new Input();
        Output output = new Output();
        public void init()
        {

        }

        private int generateNumber()
        {
                int[] randomNumber = new int[3];

                for (int index = 0; index < 3;) {
                        int randomPickNumber = Randoms.pickNumberInRange(1, 9);
                        if (randomNumber[0] == randomPickNumber || randomNumber[1] == randomPickNumber) {
                                continue;
                        }
                        randomNumber[index] = randomPickNumber;
                        index++;
                }

                return randomNumber[0]*100 + randomNumber[1]*10 + randomNumber[2];
        }
}
