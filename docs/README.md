# Appliction

## 코드 설명

1. main(String[] args)

    메인 프로그램입니다. 다른 다양한 기능을 활용해 목적을 달성합니다.


2. randomCreate()
        
    1~9 사이 랜덤한 수를 뽑아 int로 return 합니다.


3. comCreate()

    중복 되지 않는 3개의 랜덤 값을 받아 array로 리턴합니다. 이 과정에서 radomCreate()가 이용됩니다.


4. List<Integer> userNum()

    유저로부터 3개의 값을 받아옵니다. 3개의 값은 int만 가능하고, 3개가 아닐 시 error가 납니다. 


5. countStrike(List<Integer> com, List<Integer> user)

    컴퓨터의 값과 유저의 값을 비교해 스트라이크가 맞은 횟수를 정수로 리턴합니다. 


6. countBall(List<Integer> com, List<Integer> user)

    컴퓨터의 값과 유저의 값을 비교해 볼의 횟수 (전체 일치하는 수 - 스트라이크 )를 정수로 리턴합니다. 이 과정에서 countStrike()가 이용됩니다.


7. judgement(List<Integer> com, List<Integer> user)

     countStrike()와 countBall에서 나온 결과를 가지고 게임의 결과를 String으로 리턴합니다.


8. playagain()

     게임이 끝날 시 게임의 재시작 여부를 확인합니다. boolean으로 리턴합니다.
***
