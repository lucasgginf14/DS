package e2.Items;

public abstract class Item {

    private final String codeName;

    public String getCodeName() {
        return codeName;
    }

    public Item(String codeName) {
        this.codeName = codeName;
    }
}