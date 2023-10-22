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

## ● domain

- Computer : 컴퓨터 객체
    - createComputerNumber() : 컴퓨터의 랜덤 숫자를 생성 및 저장하는 함수

- Player : 플레이어 객체
    - createPlayerNumber() : 플레이어의 숫자를 초기화하는 함수

## ● service

- ProgressService : 게임 진행을 돕는 객체
    - getInput() : 플레이어로부터 숫자를 입력받고 검증하는 함수
    - resetGame() : 게임을 초기화하는 함수
    - getResultMessage() : 결과 메시지를 반환하는 함수
    - isGameClear() : 게임 클리어인지 판별하는 함수(3스트라이크인지 확인)
    - getResultGameStatus() : 게임 재시작 또는 종료 여부를 반환하는 함수
    - checkGameStatus() : 게임 종료 여부를 판별하는 함수
    - converseStringToListInteger() : String 타입을 Integer 타입의 List로 변환하는 함수


- CountService : 사용자가 입력한 숫자에 대한 볼/스트라이크 카운트를 계산하는 객체
    - resetCount : 저장된 카운트를 초기화하는 함수
    - getResultCount() : 결과 카운트를 반환하는 함수
    - getBallCount() : 볼 카운트를 반환하는 함수
    - getStrikeCount() : 스트라이크 카운트를 반환하는 함수
    - checkLocateSame() : 컴퓨터의 숫자와 플레이어의 숫자 각각의 자리가 같은지 판별하는 함수
    - checkLocateDifferent() : 컴퓨터의 숫자와 플레이어의 숫자 각각의 자리가 다른지 판별하는 함수
    - isNothing() : 낫싱인지 판별하는 함수

## ● controller

- GameProgress : 게임 진행을 위한 객체
    - startGame() : 게임을 시작하는 함수
    - restartGame() : 게임을 재시작하는 함수

## ● constant

- Constant : 상수를 관리하는 객체
    - validationAll() : 플레이어가 입력한 값을 전체 검증하는 함수

## ● validation

- NumberValidation : 주어진 입력이 올바른지 검증하는 객체
    - validationAll() : 플레이어가 입력한 값을 전체 검증하는 함수
    - validateDuplicate() : 중복을 검증하는 함수
    - validateRangeAndType() : 1과 9 사이의 수인지 검증하는 함수
    - validateGameStatus() : 주어진 입력값이 1 또는 2인지 검증하는 함수
