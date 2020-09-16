
public class RpsRunner {
    public static void main(String[] args) {
        Game game = new Game(new UserCommunication());
        game.start();
    }
}
