구현해야할 기능 목록

1.comArrayList

2.humanArrayList

3.리스트의 숫자들을 비교하면서 ball, strike count하기


구현 과정

1.computer가 만드는 randomnumber

2.human이 입력하는 숫자

3.Console pakage의 readline함수가 String을 받는 것을 확인 

4.처음에 별생각 없이 Integer로 형변환 결과 형변환하면 숫자가 ASCII 코드의 숫자로 바뀌는 것을 확인

5.내장라이브러리의 Integer, Character 이용하여 변환

6.randomnumber로 어떤게 출력되는지 확인

7.if문으로 각각의 상황에 맞게 적용

8.컴퓨터의 랜덤넘버를 출력하여 어떤 randomNumber가 생성되었는지 확인

9.1을 눌렀을 때 다시시작할때 랜덤넘버가 똑같은걸로 다시 생성되는 것을 확인

10.생각보다 실행속도가 너무 느림

11.다시시작할때 새로운 randNumber로 바꾸기 적용완료

12.생성된 randomNumber확인하는 for문 주석처리

13.숫자가 아닌 문자를 입력하였을때 예외처리 구현환

14.테스트 결과 둘다 Faild로 나옴 다시 구현

15.테스트 결과가 계속 fail이 나와서 test 코드를 확인해보니 random으로 생성되는 숫자와는 다르게 일정한 입력값이 있음을 확인 따라서 무한루프를 빠져나오지 못한 것으로 판단 

16.예외 테스트는 생각나는 예외마다 계속 추가해서 테스트해보았지만 왜 안되는지 모르겠음