public class Player {
    public enum PlayerType {
        X, O;
    }
    PlayerType currentPlayer;

    public Player(PlayerType currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }

}
