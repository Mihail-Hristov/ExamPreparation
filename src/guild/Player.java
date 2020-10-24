package guild;

public class Player {
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String clazz;
    private String rank = "Trial";
    private String description = "n/a";

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Player %s: %s", this.name, this.clazz)).append(System.lineSeparator());
        result.append(String.format("Rank: %s", this.rank)).append(System.lineSeparator());
        result.append(String.format("Description: %s", this.description));

        return result.toString();
    }

}
