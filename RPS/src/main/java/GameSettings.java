public class GameSettings {
    private final String name;
    private final int noOfRounds;

    public GameSettings(String name, int noOfRounds) {
        this.name = name;
        this.noOfRounds = noOfRounds;
    }

    public String getName() {
        return name;
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }
}
