package baseball.repository;


import baseball.domain.Referee;

public class RefereeRepository {
    private static Referee referee;

    public static void save(Referee referee){
        RefereeRepository.referee = referee;
    }

    public static Referee find(){
        return RefereeRepository.referee;
    }
}