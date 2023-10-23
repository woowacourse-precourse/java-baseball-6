
## Classes

### Application
#### main
    public static void main() throws IllegalArgumentException

### UserSession
#### game
    private Game game

#### UserSession()
    public UserSession()
- To separate the UserSession and the Game classes, don't initialize the game here.
#### run()
    public void run() throws IllegalArgumentException
- Initialize the game if not initialized.
- Repeat these steps until the run returns or IllegalArgumentException is thrown.
  - Call promptForRound
  - Call playRound method on the game.
  - Print out result in the format specified in 우테코 미션.
  - Call isWin method on the game.
    - If the result is true, call promptForNewGame.
        - TODO: 보통 우테코 미션에서, depth를 제한하는 것 같은데, 이번 미션엔 그런 말이 없네.. 제한 하지 않는 걸까?
        - If the result is 1, call setNewGame method on the game.
        - If the result is 2, return.
#### promptForRound()
    private String promptForRound() throws IllegalArgumentException
- Prompt user(print out querying String)
- Call readLine() of camp.nextstep.edu.missionutils.Console to get user input.
- Check user input and throw IllegalArgumentException if it is not valid.
  - valid: String consists of three distinct digits. For example, "123" is valid and "1", "A23", "112" are not.
#### promptForNewGame()
    private boolean promptForNewGame() throws IllegalArgumentException
- Prompt user(print out querying String)
- Call readLine() of camp.nextstep.edu.missionutils.Console to get user input.
- Check user input and throw IllegalArgumentException if it is not valid.
  - valid: "1" or "2"

### Game

#### Rules
- target: an integer in range of 100 to 999 (including), three digits should be distinct.
- strike: counts of positions at which the target and user input is the same.
- ball: counts of digits in user input which are also in the target but at different position.
#### Rounds
- round: a single round consists of getting input value, comparing it with the target, and returning strike and ball count.

#### target
    private List<Integer> target
- Elements of the target should be distinct.

#### Game()
    public Game()
- Call setNewTarget()
#### setNewGame()
    public void setNewGame()
- Call setNewTarget()
#### setNewTarget()
    private void setNewTarget()
- Initialize target randomly using pickNumberInRange() of camp.nextstep.edu.missionutils.Randoms.
- Must adhere to the Rules in definition of the target
#### playRound()
    public int[] playRound(String input) throws IllegalArgumentException
- The input parameter is String type to encapsulate the target and its related logic.
- If the input doesn't adhere to the Rules, throw IllegalArgumentException.
- Compare the target and the input according to Rules.
- Return array is two elemented array. The first is the number of strikes and the second is the number of balls.
#### isWin()
    public boolean isWin(int[] result) throws IllegalArgumentException
- Determine whether the result is considered as win in the Rules.
