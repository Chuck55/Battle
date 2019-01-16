package utility;

public class Weapons extends Items {
   private int attackDamage;
   private int addedCrit;

    public Weapons(String name, int damage, int addedCrit) {
        this.name = name;
        attackDamage = damage;
        this.addedCrit = addedCrit;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAddedCrit() {
        return addedCrit;
    }

    public void setAddedCrit(int addedCrit) {
        this.addedCrit = addedCrit;
    }
}


