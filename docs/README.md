#[우아한테크코스] 백엔드 프리코스 1주차 미션 - 숫자 야구

##기능 요구 사항
###게임 개요
- 1~9의 서로 다른 수로 이루어진 세 자릿수를 맞추는 게임
- HINT (힌트를 이용하여 상대방(컴퓨터)의 수를 맞추면 승리)
    - 같은 수가 같은 자리에 있는 경우 = 스트라이크
    - 같은 수가 다른 자리에 있는 경우 = 볼
    - 세 자리의 수와 같은 수가 없으면 낫싱
###[입력]
- (게임 시작 시) 서로 다른 세 자리의 수 
- (게임 종료 후) 재시작/종료 구분하는 1과 2 중 하나의 수
###[출력]
- (게임 시작 시 문구) 숫자 야구 게임을 시작합니다.
- (게임 진행 중 문구) 숫자를 입력해주세요 : 
- (입력한 수에 대한 결과) O볼 O스트라이크 / 낫싱
- (숫자를 맞추는 경우) 3스트라이크 
- (게임 종료 시 문구) 3개의 숫자를 모두 맞히셨습니다! 게임 종료
- (게임 재시작/종료 결정 문구) 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

##프로그래밍 요구 사항
- JDK 17 버전에서 실행 가능
- 프로그램 실행 시작점은 Application의 main()
- build.gradle 파일 변경 불가, 외부 라이브러리 사용 안함
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수
- 프로그램 종료 시 `System.exit()` 호출 안함
- `ApplicationTest`의 모든 test 성공
### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용
- Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberRange()`를 활용
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

##[ JAVA setting ]
- JAVA version: openjdk-17 (Oracle OpenJDK version 17.0.1)
- [File] - [Project Structure...] - [Project] 에서 'SDK' version, 'Language Level' = 17
- [File] - [Project Structure...] - [Modules] 에서 'Language Level' = 17
- [IntelliJ IDEA] - [Preferences] 에서 Gradle 검색, 'Gradle JVM' = 17