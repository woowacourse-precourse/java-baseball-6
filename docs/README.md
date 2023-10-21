# 기능 명세서

---
## BaseballGame Class
메인 함수는 전체 게임 진행을 위한 기능을 제공하는 숫자야구게임 클래스인 BaseballGame 클래스를 참조하여 게임을 진행한다.  
BaseballGame 클래스는 다음과 같은 기능을 제공한다. 단, 랜덤한 숫자는 RandomNumberGenerator 클래스를 통해 생성한다.

### startGame() : public / void
주어진 게임의 형식에 맞게 게임을 실행시키는 public 함수.  
3자리 숫자가 아닌 숫자를 입력할 시 올바른 숫자를 입력하라는 메시지 출력.   
한 라운드가 종료되었을때 1이 입력되면 새로운 게임을 실행하며 2를 입력하면 게임을 종료한다(1과 2가 아닌 숫자를 입력하면 올바른 숫자를 입력하라는 메시지를 출력). 

### compareNumbers(randomNumber, inputNumber) : private / String
입력한 숫자와 생성된 숫자를 비교하는 private 함수. String 타입의 볼과 스트라이크의 개수 혹은 '낫싱'을 반환.

## RandomNumberGenerator Class 
제공된 라이브러리를 사용하여 세자리 랜덤한 숫자를 생성하는 클래스.
### generate()
랜덤한 3자리 숫자를 반환하는 함수.
