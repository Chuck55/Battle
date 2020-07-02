package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseRoute {
    public void printLocation(ParentVariable defeated) throws IOException;

    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException;
}
