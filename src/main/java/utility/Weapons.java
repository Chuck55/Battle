package utility;

public class Weapons extends Items {
   private int attackDamage;
   private int addedCrit;

    public Weapons(String name, int damage, int addedCrit){//} String description) {
        this.setName(name);
        attackDamage = damage;
        this.addedCrit = addedCrit;
        //this.description = description;
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


