## 요구사항 정리

### 숫자 야구 게임!

1. 컴퓨터가 랜덤한 숫자 3가지를 생성
    - 숫자는 1 < n < 9
2. 사용자가 랜덤 생성된 정수 3개와 순서까지 맞추는 게임
    1. 사용자는 여러번의 기회가 주워지고 맞추지 못했을 경우 힌트가 주어진다.
        - 숫자만 맞았을 경우 → 볼
        - 숫자와 순서까지 맞았을 경우 → 스트라이트
        - 맞는게 없을 경우 낫싱
            - 예) 상대방(컴퓨터)의 수가 425일 때
                - 123을 제시한 경우 : 1 스트라이크
                - 456을 제시한 경우 : 1볼 1스트라이크
                - 789를 제시한 경우 : 낫싱
3. 숫자를 다 맞추었을 경우 게임 종료
    1. 이 후에 게임 재시작 or 프로그램 종료 선택 가능

### 예외처리!

- 사용자가 잘못된 입력을 할 경우 `IllegalArgumentException` 애플리케이션은 종료된다.
    - 잘 못 입력된 값 = 숫자를 제외한 문자, 특수문자, 띄어쓰기…?
        - 제시된 입력 값은 띄어쓰기가 없으니 띄어쓰기가 있을 경우 예외처리
        - 3자리까지 입력 가능
        - 게임 종료 후 1 or 2를 제외한 값

## 기타 주의 사항

- JDK 17 버전에서 실행 가능해야 한다.
- `Application`의`main()`
- `build.gradle`파일을 변경x
- 외부 라이브러리 x
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)가이드를 준수하며 프로그래밍한다.
- `System.exit()`를 호출x
- `ApplicationTest`의 모든 테스트가 성공해야 한다.**테스트가 실패할 경우 0점 처리한다.**
- 파일, 패키지 이름을 수정 불가 (프로그래밍 요구 사항 제외)
- `camp.nextstep.edu.missionutils`에서 제공하는`Randoms`및`Console`API를 사용하여 구현
    - Random =`camp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()`
    - 사용자 입력 =`camp.nextstep.edu.missionutils.Console`의`readLine()`

---

## 기능 정리

- 게임 시작시 초기화
    - 랜덤 숫자 3자리 생성 - `Randoms.pickNumberInRange()` 사용
- 입력 기능과 출력 기능
    - 입력 → `Console.readLine()` 사용
    - 출력 종류
        - 숫자 야구 게임을 시작합니다.\n
        - 숫자를 입력해주세요 : 123
        - 1볼 1스트라이크\n
        - 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n
        - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n
- 숫자가 맞는지 판별과 힌트 생성
- 예외 처리
    - 입력 값에 대한 유효성 → 예외 발생
        - 사용자 허용 입력 값
            - 3자리 정수
            - 1 or 2
- 시스템 종료
    - 사용자 선택 또는 예외처리로 인한 시스템 종료
    - `Cosole.close()` 호출
    - 종료 시 출력 값에 대한 요구 없음…?

---

## 클래스 정리

Application

- main

BaseBallGame

- start
- round
- close

Process

- getFormat
- isCorrectBall
- getCurrentHint

Ball

- createRandomBall
- makeHint

Hint

- isStrike
- toString

View

- getInput
- print
- println

ViewType (enum)

### Utils 정리

**Randoms**

- pickNumberInList
    - 인자로 받은 List안에 들어있는 숫자 중 하나 선택하여 반환
- pickNumberInRange
    - 인자로 받은 숫자 범위 내에서 숫자 하나를 선택
- pickUniqueNumbersInRange
    - start < n < end 범위 내에서 숫자 count개를 선택
    - 선택된 숫자는 고유함. -> 중복된 숫자가 없음을 뜻함