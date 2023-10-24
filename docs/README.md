# 숫자야구


## 처음 세운 계획

게임시작  <-----------------
V                        ㅣ
변수생성                   ㅣ
V                        ㅣ
숫자입력 <——-              ㅣ
V         ㅣ             ㅣ
판별 ————볼,스트라이크.      ㅣ
V   다 맞을시              ㅣ
선택 ---------진행 선택------
V 종료 선택
끝


## 만들 함수 목록
변수생성
유저입력
숫자비교


# 구조 설명

Application.java
- setComputer setCom 변수생성
- game class Baseball 생성
- Baseball.result() setCom.setRandom()리스트를 전달받아 실행

game.java
- numInput에서 유저입력을 리스트형식으로 받아옴
- 전달받은 setCom.setRandom()을 ran에 담아 judge의 judgement() 반복실행

judge.java
- numInput에서 받은 입력값을 userNum, ran으로 전달받은 리스트를 comNum에 담아 비교
- 각 자리의 요소가 같을시, Strike 1증가, 자리의 요소가 같진 않지만 내부에 같은 요소를 포함시 Ball 1증가
- if를 통해 Strike와 Ball 출력
- Strike가 3일시, result()의 반복문을 탈출할 수 있도록 3을 return

setComputer.java
- 우아한 테크 코스에서 제공한 Randoms 라이브러리 사용하여 리스트에 변수 저장
- 생성한 변수 리스트 computer return

numInput.java
- 우아한 테크 코스에서 제공한 Console 라이브러리의 readLine()을 이용하여 사용자에게 입력요청
- 입력받은 숫자를 split하여 userinput에 저장하여 return
- 사용자가 3자리 숫자가 아닌 이외의 입력( 문자, 3자리 초과의 숫자 등) 수행시, IllegalArgumentException 발생시켜 프로그램 종료.