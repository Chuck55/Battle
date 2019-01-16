package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;

import java.io.FileNotFoundException;

public interface BaseRoute {
    public void printLocation(ParentVariable defeated);

    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException;
}
