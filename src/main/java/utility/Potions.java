package utility;

public class Potions extends Items {
    private int healing;

    public Potions(String name, int healing) {
        this.name = name;
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
