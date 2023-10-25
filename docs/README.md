 # Class
 1. 숫자를 입력 받을 Player Class 구현 
 2. 랜덤숫자를 생성할 Computer Class 구현 
 3. 게임을 진행할 gameManager Class 구현 
 4. 각 Computer와 player,  gameManager를 생성하고 셋팅해주는 Game 클래스 구현

## Player Class
- 기본 생성자
- 입력받은 숫자를 저장할 setter
- 저장된 숫자를 받아올 Getter

## Couputer Class
- 기본 생성자 ,생성시 랜덤 숫자를 생성해준다.
- 랜덤으로 숫자를 생성해주는 generateNumber
- 저장된 숫자를 받아올 getter
- 랜덤 숫자를 변경하기 위한 changeNumber

## GameManager Class
- computer 객체와 player객체를 private으로 가지고 있다.
- computer와 player 객체를 설정하는 GameManager 생성자
- 스트라이크와 볼을 카운트 해주는 count_msg
- 스트라이크, 볼을 판정해주는 judge
- Console.readline으로 받은 입력값이 valid한지 판별하는 isValid
- 게임을 진행하는 startGame
    - 숫자 입력메소드, 입력값 검증, 판정, 메세지 출력하는 메소드를 각각 호출하여 게임 진행

## Game Class
- Player 객체와 Computer 객체 생성후 gameManager생성자에 대입하여, 세팅
- gameManager.startGame 을 호출하는 start

