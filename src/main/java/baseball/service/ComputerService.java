package baseball.service;

import static baseball.domain.Computer.BASEBALL_NUMBERS_SIZE;

import baseball.repository.ComputerRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class ComputerService {
    
    private static final int BASEBALL_MIN_NUMBER = 1;
    private static final int BASEBALL_MAX_NUMBER = 9;
    
    private final ComputerRepository computerRepository = new ComputerRepository();
    
    public String initComputer() {
        String number = makeComputerNumber();
        saveComputerNumber(number);
        return number;
    }
    
    private String makeComputerNumber() {
        LinkedHashSet<String> result = new LinkedHashSet<>();
    
        while (result.size() < BASEBALL_NUMBERS_SIZE) {
            result.add(makeRandomNumber());
        }
    
        return String.join("", result);
    }
    
    private String makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
        return Integer.toString(randomNumber);
    }
    
    private void saveComputerNumber(String number) {
        computerRepository.save(number);
    }
}
