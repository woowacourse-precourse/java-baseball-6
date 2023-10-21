# 기능 요구 사항
## 상대방 컴퓨터
- 3 자리 숫자 문자열을 가짐
- 1 ~ 9까지 서로 다른 임의의 수 3 개 선택 
- 플레이어 - 컴퓨터 개수 계산
  - 스트라이크
    - 3스트라이크: 게임 재시작/종료 구분
  - 볼
  - 낫싱

## 입력
- 플레이어가 추측하는 컴퓨터의 서로 다른 3 개의 숫자
- 게임 재시작/종료를 구분하는 1과 2 중 하나의 수

## 출력
- 플레이어 - 컴퓨터 개수 계산 출력
- 하나도 없는 경우(낫싱) 경우 출력
- 3개의 숫자를 모두 맞힐 경우(3스트라이크) 경우 출력
- 게임 시작 문구 출력
- 게임 재시작/종료 문구


# 구현 기능 목록
## Model
- ComputerModel
  - Field 
    - [ ] 중복되지 않은 임의의 숫자 3 개

## View
- InputView
  - Method
    - [ ] 플레이어 수 입력 
    - [ ] 게임 재시작/종료 1과 2중 하나의 수 입력 
    - camp.nextstep.edu.missionutils.Console - `readLine()` 사용
- OutputView
  - Method
    - [ ] 플레이어 - 컴퓨터 점수 출력
    - [ ] 하나도 없는 경우(낫싱) 경우 출력
    - [ ] 3개의 숫자를 모두 맞힐 경우(3스트라이크) 경우 출력
    - [ ] 게임 시작 문구 출력
    - [ ] 게임 재시작/종료 문구 출력 

## Controller
- StateController
  - Field
    - [ ] 현재 게임 진행 상태(1과 2중 하나)
  - Method
    - [ ] 게임 재시작/종료 조정
    - [ ] **잘못된 값 입력 시 `IllegalArgumentException` 발생 후 종료**
- ScoreController
  - Method
    - [ ] 플레이어 - 컴퓨터 점수 계산 
      - 숫자 포함 O, 자리 x -> 볼
      - 숫자 포함 O, 자리 O -> 스트라이크

## RandomNumber
  - Method
    - [ ] 중복되지 않은 임의의 숫자값 3 개 반환
    **camp.nextstep.edu.missionutils.Randoms - `pickNumberInRange()`**
