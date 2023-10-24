# 🚀 기능 목록

1. 컴퓨터 숫자 랜덤 생성 기능
2. 플레이어 입력 값 검증 기능
3. 카운트 계산 기능

- 볼 카운트 계산
- 스트라이크 카운트 계산

4. 결과 메시지 반환 기능

- 볼, 스트라이크, 낫싱

5. 프로그램 종료 조건 검증 기능

- 재시작, 종료

---

# 📚 클래스 설계 목록

## ● constant

- Constant : 상수를 관리하는 객체

## ● message

- CountMessage : 카운트 메시지와 관련된 객체
    - getMessage() : 메시지를 반환하는 함수
    - toString() : 메시지를 연결해 반환하는 함수

## ● validation

- NumberValidation : 주어진 입력이 올바른지 검증하는 객체
    - validationAll() : 플레이어가 입력한 값을 전체 검증하는 함수
    - validateDuplicate() : 중복을 검증하는 함수
    - validateLength() : 길이를 검증하는 함수
    - validateRangeAndType() : 1과 9 사이의 수인지 검증하는 함수
    - validateIsInArray() : 해당 숫자가 배열 안에 있는지 검증하는 함수
    - validateComputerDuplicate() : 컴퓨터 랜덤 숫자가 중복되었는지 검증하는 함수
    - validateGameStatus() : 주어진 입력값이 1 또는 2인지 검증하는 함수

## ● service

- ProgressService : 게임 진행을 돕는 객체
    - resetGame() : 게임을 초기화하는 함수
    - getComputerNumber() : 컴퓨터의 3개의 숫자 모두 중복되지 않을 때까지 생성을 반복하는 함수
    - createComputerNumber() : 컴퓨터의 랜덤 숫자를 1자리씩 생성하는 함수
    - getResultMessage() : 결과 메시지를 반환하는 함수
    - isGameClear() : 게임 클리어인지 판별하는 함수(3스트라이크인지 확인)
    - getResultGameStatus() : 게임 재시작 또는 종료 여부를 반환하는 함수
    - checkGameStatus() : 게임 종료 조건을 판별하는 함수

- CountService : 사용자가 입력한 숫자에 대한 볼/스트라이크 카운트를 계산하는 객체
    - resetCount : 저장된 카운트를 초기화하는 함수
    - getResultCount() : 결과 카운트를 반환하는 함수
    - getBallCount() : 볼 카운트를 반환하는 함수
    - getStrikeCount() : 스트라이크 카운트를 반환하는 함수
    - isNothing() : 낫싱인지 판별하는 함수

## ● controller

- GameProgress : 게임 진행을 위한 객체
    - getInput() : 플레이어로부터 숫자를 입력받고 검증하는 함수
    - startGame() : 게임을 시작하는 함수
    - restartGame() : 게임을 재시작하는 함수

## ● view

- InputView : 플레이이로부터 입력을 받기위한 객체

---

# ✏️ 요구사항 체크 리스트

## 🎯 기능 요구 사항

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한 결과를 출력한다.
- 이와 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다. ✅
- 프로그램 실행의 시작점은 Application의 main()이다. ✅
- build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다. ✅
- Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다. ✅
- 프로그램 종료 시 System.exit()를 호출하지 않는다. ✅
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다. ✅
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다. ✅

## 🎯 과제 진행 요구 사항

- 미션은 java-baseball-6 저장소를 Fork & Clone해 시작한다. ✅
- 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다. ✅
- 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다. ✅