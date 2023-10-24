# 우테코 프리코스 1주차 미션 - 숫자 야구

__🔴 문제 : 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. (숫자야구)__

## 🚀 기능 요구 사항

## __플레이어 클래스(Player)__

- [x] 정답을 맞출때까지 세 자리 숫자를 입력하는 기능
    - player 메소드
        - readLine을 활용하여 사용자에게 숫자 입력받음
        - ExceptionUtil 클래스 호출로 오류체크
        - 문자열로 입력받은 숫자를 정수형 List로 바꿔서 리턴
- [x] 게임이 종료된 이후 재시작할건지 종료할건지 입력하는 기능
    - newGame 메소드
        - readLine을 활용하여 사용자에게 1 또는 1를 입력받음
        - ExceptionUtil 클래스 호출로 오류체크
        - 2일 경우 true를 리턴하여 프로그램 종료

## __컴퓨터(상대방) 클래스(Computer)__

- [x] 정답 숫자인 세 자리 숫자를 랜덤 생성하는 기능
    - generateNumber 메소드
        - `camp.nextstep.edu.missionutils.Randoms` 라이브러리 사용하여 3개의 랜덤 숫자 생성
- [x] 겹치는 숫자가 있는지 확인하는 기능
    - countOverlap 메소드
        - contains 함수 이용하여 1~9 숫자가 player List에 존재 할 경우 카운트
- [x] 스트라이크가 몇 개인지 세는 기능
    - countStrike 메소드
        - 같은 자릿수에 존재하는 숫자가 같을 경우 카운트
- [x] 볼이 몇 개인지 세는 기능
    - countBall 메소드
        - countOverlap 메소드 결과에서 countStrike 결과를 빼서 리턴
- [x] 결과를 판별해서 출력해주는 기능(스트라이크, 볼, 낫싱)
    - printResult 메소드
        - 각 조건에 따른 낫싱, 볼, 스트라이크 출력
- [x] 플레이어가 입력한 숫자가 정답인지 확인하는 기능
    - run 메소드
        - countStrike 메소드 호출하여 3일 경우 정답이므로 종료
