# 1주차 미션: 숫자 야구 게임 구현 기능 목록

# Model

## ✅ 컴퓨터 수 생성 기능

- ✅ getComputerRandomNumber 메서드 구현
    - ✅ 서로 다른 수로 이루어진 random 3자리의 숫자 리스트 생성

## ✅ 스트라이크 개수 확인 기능

- ✅ getStrikeCount 메서드 구현
    - 플레이가 입력한 숫자 리스트를 파라미터로 받아와 Strike의 개수 반환

## ✅ 볼 개수 확인 기능

- ✅ getBallCount 메서드 구현
    - 플레이어가 입력한 숫자 리스트를 파라미터로 받아와 Ball의 개수 반환

## ✅ 낫싱 확인 기능

- ✅ checkNothing 메서드 구현
    - 플레이어가 입력한 숫자 리스트를 파라미터로 받아와 낫싱 여부 반환

## ✅ 게임 성공 확인 기능

- ✅ checkSuccess 메서드 구현
    - 플레이어가 입력한 숫자 리스트를 파라미터로 받아와 게임 성공 여부 반환

# View

## ✅ 플레이 결과 출력 기능

- ✅ displayGetPlayResult
    - ✅ 플레이어가 입력한 숫자 리스트를 파라미터로 받아와 스트라이크, 볼, 낫싱 확인 및 결과 출력

## ✅ 게임 시작 메시지 출력 기능

- ✅ displayNewGameMessage 메서드 구현
    - ✅ 게임이 시작 될 때 안내 메시지 출력

## ✅ 게임 종료 메시지 출력 기능

- ✅ displayExitMessage 메서드 구현
    - 게임이 종료될 때 메시지 구현

## ✅ 게임 재시작/종료 여부 확인 메시지 출력 기능

- ✅ displayAskRestartOrExitGame 메서드 구현
    - 재시작 여부 확인 메시지 구현

## ✅ 숫자 입력 메시지 출력 및 입력 기능

- ✅ getInputNumberMessage 메서드 구현
    - 플레이어에게 숫자를 입력 받고 리턴

## ✅ 재시작 여부 입력 메시지 출력 및 입력 기능

- ✅ getInputRestartMessage 메서드 구현
    - 플레이어에게 재시작 여부를 입력 받고 리턴

# Controller

## ✅ 플레이어 수 입력

- ✅ getPlayerInputNumber 메서드 구현
    - 서로 다른 3자리의 수를 입력 받아 숫자 리스트 생성

## ✅ 입력한 수 검증

- ✅ validateUserInput 메서드 구현
    - String형식의 숫자를 받아와 잘못된 값을 입력할 경우 IllegalArgumentException 발생후 종료
- ✅ validateInputIsNumber 메서드 구현
    - 입력한 값들이 다 숫자인지 검증
- ✅ validateInputLength 메서드 구현
    - 입력한 값들의 숫자 자릿수가 3인지 검증
- ✅ validateInputWithDifferentDigit 메서드 구현
    - 입력한 값들의 숫자가 자릿수가 다른지 검증

## ✅ 게임 시작 기능

- ✅ playGame 메서드 구현
    - 프로그램 시작
- ✅ oneGame 메서드 구현
    - 야구 게임 경기 한번

## ✅ 게임 종료 기능

- ✅ oneGame 메서드 내 조건문 구현
    - break 종료

## ✅ 게임 재시작/종료 선택 기능

- ✅ oneGame 메서드 내 조건문 구현
    - 플레이어가 입력한 값을 받아옴

- ✅ validateRestartInput 메서드 구현
    - 플레이어가 입력한 값을 검증 
