package utility;

public class Potions extends Items {
    private int healing;

    public Potions(String name, int healing){//} String description) {
        this.setName(name);
        this.healing = healing;
        //this.description = description;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
