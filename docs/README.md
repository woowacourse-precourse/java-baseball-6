## 기능 요구 사항
1. Player와 Computer가 숫자야구게임을 한다.
2. Player에게 세 자리 수를 입력받는다.
    * 아래 예외상황 예외처리 IllegalArgumentException -> 게임종료
        * 1 ~ 9까지의 자연수
        * 세 자리 수
        * 중복이 없는 수
3. Computer는 게임에 필요한 숫자를 제시한다.(라이브러리에서 제공하는 랜덤함수)
    * 아래 예외상황일때 다시 생성
        * 1 ~ 9까지의 자연수
        * 세 자리 수
        * 중복이 없는 수
4. Game Host는 Player와 Computer에게 숫자를 입력받는다.
5. 게임조건에 부합하는 결과를 Player에게 보여준다
    * Strike : 같은 자리, 같은 숫자
    * Ball : 다른 자리, 같은 숫자
    * Nothing : 다른 자리, 다른 숫자
    * 3스트라이크일 경우 게임 종료 or 게임다시 시작 기능을 제공한다.






* 현실세계에선 어떻게 기획되어야 할지 `관계`를 생각한다.
    * game host, computer, player 각 요소들끼리 관계
* 프로그램이 시작 ~ 종료 static 영역에
* 정규식이 아니고 char의 영역으로 체크하면 더 정확할듯
* final을 써야할때 ?
* static은 ?