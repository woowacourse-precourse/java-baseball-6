# 미션 - 숫자 야구게임 구현목록

## 도메인

- RandomNumber
    - 멤버변수
        - 3개의 숫자를 저장할 리스트
    - 생성자
        - 매개변수없이 리스트를 초기화하는생성자
    - 메서드
        - 리스트에 중복되지않는 3개의 난수를 추가하는 메서드
        - 리스트를 리턴하는 메서드

- BallHint
    - 멤버변수
        - 스트라이크를 저장할 int
        - 볼을저장할 int
    - 메서드
        - 낫싱을 판단해 boolean 을 리턴하는 메서드
        - 스트라이크를 1증가시키는 메서드
        - 볼을 1증가시키는 메서드
        - 스트라이크를 리턴하는 메서드
        - 볼을 리턴하는 메서드
        - 스트라이크와 볼을 초기화하는 메서드

- BallInput
    - 멤버변수
        - 사용자의 입력을 저장할 숫자형 리스트
        - 최대 입력값을 제한하는 숫자형 상수
    - 생성자
        - 리스트를 초기화하는 매개변수 없는 생성자
    - 메서드
        - 사용자의 입력을 저장하는 메서드
        - 사용자의 입력을 검증하는 메서드
        - 사용자의 입력을 초기화하는 메서드
        - 리스트를 반환하는 메서드

## 프로그램 로직

- BaseballGame
    - 멤버변수
        - RandomNumber
        - BallHint
        - BallInput

    - 생성자
        - 매개변수 없이 멤버변수를 초기화하는 생성자

    - 메서드
        - RandomNumber, BallHint, BallInput 변수들을 각각 초기화하는 메서드
        - 사용자의 입력값을 BallInput에 저장하는 메서드
        - RandumNumber를 가져오는 메서드
        - RandumNumber와 BallInput을 비교해 BallHint에 저장하는메서드
        - 게임을 초기화하는 메서드
        - Ballhint를 출력하는 메서드
        - 정답을 맞췄는지 boolean으로 리턴하는 메서드

## UserInterface

- 멤버변수
    - BaseballGame
- 생성자
    - BaseballGame을 주입받는 생성자
- 메서드
    - 프로그램을 시작하는메서드
    - 게임을 시작하는메서드

## Application

BaseballGame을 UserInterface에 주입해서 실행한다