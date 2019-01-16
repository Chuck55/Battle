package BattleStuff;

import com.rpg.MainCharacter;
import com.rpg.Monster;
import com.rpg.ParentVariable;

public interface BattleBase {
    void choiceMove(MainCharacter newPastor, Monster monster);

    void printScores(MainCharacter newPastor, Monster monster);

    void checkHealth(ParentVariable defeated, Monster monster);

    void printVoiceline(boolean VL1, boolean VL2, boolean VL3, int totalHealth, Monster monster);
    void attack(MainCharacter newPastor, Monster mon);
}
