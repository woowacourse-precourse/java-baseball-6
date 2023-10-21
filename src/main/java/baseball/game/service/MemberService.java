package baseball.game.service;

import baseball.game.entity.Member;
import baseball.game.repository.MemberRepository;
import camp.nextstep.edu.missionutils.Console;
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

    public Member readUserNumber(String input) {
        if (!isInput(input)) {
            Console.close();
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. 중복되지 않은 3자리 숫자를 입력해주세요.");
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
        // input을 LinkedHashSet으로 변환
        LinkedHashSet<Integer> inputs = stringToIntegerLinkedHashSet(input);
        if (inputs.size() != 3) {
            return false;
        }
        return true;
    }

    private LinkedHashSet<Integer> stringToIntegerLinkedHashSet(String input) {
        // 순서를 보장하는 Set
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
