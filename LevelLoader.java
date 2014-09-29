import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LevelLoader  
{

    private final List<WorldBlock> blocks = new ArrayList<WorldBlock>();

    public LevelLoader(String filename) {
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
            while(s.hasNextLine()) {
                String line = s.nextLine().trim();
                if(line.matches("\\w+\\s+\\d+\\s+\\d+")) {
                    Scanner t = new Scanner(line);
                    String type = t.next();
                    int wx = t.nextInt();
                    int wy = t.nextInt();
                    blocks.add(new WorldBlock(type,wx,wy));
                }
            }
        }
        catch(FileNotFoundException e) {
            throw new IllegalArgumentException("File not found!");
        }
        finally {
            s.close();
        }
    }

    public List<WorldBlock> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

}
