public class Player {
    char currentPlayer;

    public Player(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

}
