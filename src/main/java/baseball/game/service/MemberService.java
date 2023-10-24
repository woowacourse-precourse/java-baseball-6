package baseball.game.service;

import baseball.game.entity.Member;
import baseball.game.exception.NumberBaseBallException;
import baseball.game.repository.MemberRepository;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MemberService {

    private final MemberRepository memberRepository;
    private static MemberService instance;

    private MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static MemberService getInstance(MemberRepository memberRepository) {
        if (instance == null) {
            return instance = new MemberService(memberRepository);
        }
        return instance;
    }

    public Member saveUserNumber(String input) {
        if (!isInput(input)) {
            Console.close();
            throw new IllegalArgumentException(NumberBaseBallException.WRONG_NUMBER);
        }

        List<Integer> numbers = stringToIntegerList(input);
        Member member = Member.create(numbers);

        return memberRepository.save(member);
    }

    private List<Integer> stringToIntegerList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isInput(String input) {
        // 3자리가 아니면
        if (input.length() != 3) {
            return false;
        }

        // 문자열 중 숫자만 HashSet으로 변경
        HashSet<Integer> inputSet = stringToIntegerHashSetOnlyNumber(input);
        if (inputSet.size() != 3) {
            return false;
        }

        return true;
    }

    // 문자열 중 0을 제외한 숫자만 HashSet으로 변경
    private HashSet<Integer> stringToIntegerHashSetOnlyNumber(String input) {
        return input.chars()
                .filter(ch -> Character.getNumericValue(ch) != 0 && Character.isDigit(ch))
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Deprecated
    private boolean isAllDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    @Deprecated
    private LinkedHashSet<Integer> stringToIntegerLinkedHashSet(String input) {
        // 순서를 보장하는 Set
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
