# 미션 - 숫자 야구 수행 기록

## [기능 목록]

- `IllegalArgumentException` 예외 처리
- pickNumber 메소드: 상대방(컴퓨터)이 랜덤으로 숫자를 뽑는다.
- inputNumber 메소드: 플레이어가 숫자 3개 입력
- stringToIntegerList 메서드: 문자열을 정수형 리스트로 변경
- digitOneToNine 메서드: 입력된 3자리 숫자가 1~9 정수 검사
- inputLastNumber 메서드: 재시작 또는 프로그램 종료를 위한 마지막 플레이어 입력
- stringToInteger 메서드: 문자열을 정수형으로 변경
- digitOneOrTwo 메서드: 입력된 1자리 숫자가 1 or 2 정수 검사
- restartOrClose 메서드: 입력이 재시작 or 프로그램 종료일 때 동작
- changeNumbers 메서드: 플레이어 or 상대방(컴퓨터)가 입력한 3자리 숫자 변경
- changeScore 메서드: 스트라이크와 볼 수 변경
- countStrike 메서드: 스트라이크 수 카운팅
- isStrike 메서드: 스트라이크가 맞는지 확인
- countBall 메서드: 볼 수 카운팅
- isBall 메서드: 볼이 맞는지 확인
- currentBall 메서드: 지금 비교하는 값이 볼인지 확인
- printToResult 메서드: 스트라이크 수와 볼 수를 확인해 결과 출력

### [23.10.19]

- 프리코스 메일 확인
- 주의사항 숙지

### [23.10.21]

- Java 17 개발 환경 세팅
- Git 연동
    - 통신 방법 변경 HTTPS → SSH
- 개발 환경 세팅 중 발생한 이슈 해결
    - Java 버전 변경 및 `asdf` 패키지 관리 툴 사용
    - 터미널 재실행시 `java -version` 찾지 못함... JAVA_HOME 설정으로 해결

### [23.10.22]

- Git bare clone 수행
- 기능 목록 1차 작성
- 프로그램 전체 흐름 중 50% 구현
    - 클린코드 고려 안함 (수정 필요)
    - 메서드 복잡도 고려 안함 (수정 필요)
- Java 코드 컨벤션 적용
- 유용한 플러그인 적용
    - CodeMetrics
    - GitToolBox
    - Rainbow Brackets

### [23.10.23]

- 프로그램 전체 흐름 중 100 % 구현
    - `./gradlew clean test` 모두 통과
- 클래스 분리
    - `Application` 클래스의 모든 기능이 모여있어 1차 분리
    - 클래스별 필요 변수, 메서드 설계
- 메서드 복잡성이 높아 단순화 시작
    - 클린코드 방법 조사 및 1차 반영

### [23.10.24]

- (우테코 이전 기수 프로젝트 참고)
- 패키지 분리
    - 클래스를 역할 분리해보니 패키지로 나눌 수 있어보임
    - 해당 클래스가 어떤 목적을 가지고 사용될것인지 생각하게 됨
- 메서드 복잡성 줄이기
    - indent depth 1 을 고려하며 작업해보니 메서드를 분리하게 됨
    - 자연스럽게 메서드 당 하나의 일을 하게 됨
    - 메서드가 늘어나면서 기능 목록이 추가 됨
    - 메서드 당 하나의 일만 수행해 가독성이 높아짐
    - 자연스럽게 클린코드를 반영할 수 있음
    - 원시타입을 Wrapping
- commit 메시지 수정
    - 메서드(기능)별 커밋 기록