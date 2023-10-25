## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

랜덤으로 1~9짜리 서로 다른 3개의 수를 생성한다.
사용자에게 수를 입력받는다.
입력받은 수를 검증한다.
입력받은 3자리 수에서 볼, 스트라이크 개수를 구해서 반환한다.
구해진 볼, 스트라이크를 통해 출력값을 결정한다.
스트라이크, 볼 0개 : "낫싱"
스트라이크 0~2개, 볼 0개 아님 : "n볼 n스트라이크"
스트라이크 3개 : "3스트라이크"
정답문구 출력 : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
계속 진행할 것인지 묻기 : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
1 입력 : 처음으로 돌아간다.
2 입력 : 프로그램을 종료한다.
스트라이크 3개가 나올 때 까지 2~5과정을 반복한다.
커밋메세지 컨벤션

"태그: 제목"의 형태이며, 태그는 영어로 쓰되 첫 문자는 대문자로 합니다.
: 뒤에만 space가 있습니다.
ex) feat(...): add score compute
태그이름	설명
feat	새로운 기능을 추가할 경우
fix	버그를 고친 경우
style	코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우
refactor	프로덕션 코드 리팩토링
comment	필요한 주석 추가 및 변경
docs	문서를 수정한 경우
test	테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
chore	빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
rename	파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
remove	파일을 삭제하는 작업만 수행한 경우
Java 컨벤션 (내가) 주의할 사항

import

import 선언의 순서와 빈 줄 삽입 [import-grouping]

import 구절은 아래와 같은 순서로 그룹을 묶어서 선언한다.

static imports
java.
javax.
org.
net.
8~10을 제외한 com.*
16, 810을 제외한 패키지에 있는 클래스
com.nhncorp.
com.navercorp.
com.naver.
각 그룹 사이에는 빈줄을 삽입한다. 같은 그룹 내에서는 알파벳 순으로 정렬한다.

좋은 예

import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.google.common.base.Function;

import com.naver.lucy.util.AnnotationUtils;
이 규칙은 대부분 IDE에서 자동으로 정리해주는 대로 쓰기 때문에 IDE 설정을 일치시키는데 신경을 써야 한다.

줄바꿈 위치

줄바꿈 허용 위치 [line-wrapping-position]

가독성을 위해 줄을 바꾸는 위치는 다음 중의 하나로 한다.

extends 선언 후
implements 선언 후
throws 선언 후
시작 소괄호(() 선언 후
콤마(,) 후
. 전
연산자 전
+, -, *, /, %
==, !=, >=, >,⇐, <, &&, ||
&, |, ^, >>>, >>, <<, ?
instanceof
좋은 예

public boolen isAbnormalAccess (
User user, AccessLog log) {

    String message = user.getId() + "|" | log.getPrefix()
        + "|" + SUFFIX;
}
import 와일드카드

static import에만 와일드 카드 허용 [avoid-star-import]

클래스를 import할때는 와일드카드(*) 없이 모든 클래스명을 다 쓴다. static import에서는 와일드카드를 허용한다.

나쁜 예

import java.util.*;
좋은 예

import java.util.List;
import java.util.ArrayList;
탑레벨 클래스

소스파일당 1개의 탑레벨 클래스를 담기 [1-top-level-class]

탑레벨 클래스(Top level class)는 소스 파일에 1개만 존재해야 한다. ( 탑레벨 클래스 선언의 컴파일타임 에러 체크에 대해서는 Java Language Specification 7.6 참조 )

나쁜 예

public class LogParser {
}
class LogType {
}
좋은 예

public class LogParser {
// 굳이 한 파일안에 선언해야 한다면 내부 클래스로 선언
class LogType {
}
}
접근제한자

클래스 및 멤버 수정자가 있는 경우 Java 언어 사양에서 권장하는 순서로 나타냄

public protected private abstract default static final transient volatile synchronized native strictfp
예외 잡기: 생략하지 않음

아래 명시되있는 것말고 예외를 잡고 아무것도 안하는 것은 거의 있을 수 없습니다. (전형적인 반응은 로그를 남기는 것 혹은 불가능하다고 간주되면 AssertionError로 다시 던져줍니다.) 캐치 블록에서 아무것도 하지 않는 것이 정당하다면 주석을 남기는 것으로 정당화합니다.

try {
    int i = Integer.parseInt(response);
    return handleNumericResponse(i);
} catch (NumberFormatException ok) {
    // it's not numeric; that's fine, just continue
}
return handleTextResponse(response);
예외: 테스트에서 예외를 잡는 부분은 expected, 혹은 expected로 시작하는 이름을 지으면서 무시할 수 있습니다. 다음 예제는 테스트에서 예외가 나오는게 확실한 상황에서 사용되는 대중적인 형식으로 주석이 필요없습니다.

try {
    emptyStack.pop();
    fail();
} catch (NoSuchElementException expected) {
}
