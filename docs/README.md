# 미션 - 숫자 야구 게임

## 🚀 숫자 야구 게임 어플리케이션의 책임
- 숫자 야구 게임을 실행한다.

## 🖇 객체들의 역할과 책임
## 🗒 구현해야하는 객체, 기능 목록
Application
숫자 야구 게임 어플리케이션을 실행시키는 역할

GameManager
- 숫자 야구 게임의 진행을 담당하는 역할
- 타겟 숫자 생성 및 게이머 입력 값과 비교하여 결과 반환 역할
- 비교 결과가 3스트라이크일 때 게임 진행 여부를 묻고 진행 또는 종료 역할

AppConfig
- 게임 진행에 필요한 객체의 인스턴스를 생성하는 역할

Util

RandomNumberGenerator
-무작위 3자리 숫자 생성 역할

BallStrikeCalculator
-볼, 스트라이크 계산 및 결과 문자열 생성 역할

validation

InputValidator (인터페이스)
-입력값의 적절성을 검사하는 역할

GameInputValidator
-게임을 진행하기 위한 입력값의 적절성을 검사하고 예외를 발생시키는 역할

PlayOrStopInputValidator
-게임 진행 여부를 결정하는 입력값의 적절성을 검사하고 예외를 발생시키는 역할
