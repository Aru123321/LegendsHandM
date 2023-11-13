//interface class for heroData and monsterData
package characters;

import java.util.ArrayList;

public interface FileDataInput<T extends Being> {

    ArrayList<T> readBeingFromFile(String filePath);
}
