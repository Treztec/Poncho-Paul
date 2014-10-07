/**
 * Represents a block existing at a particular set of world coordinates.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldBlock  
{
    private final SpawnableObject block;
    private final int wx, wy;

    /**
     * Create a {@code WorldBlock} object from a {@code SpawnableObject}
     * and x and y coordinates.
     * @param block the SpawnableObject
     * @param wx the x coordinate
     * @param wy the y coordinate
     */
    public WorldBlock(SpawnableObject block, int wx, int wy) {
        this.block = block;
        this.wx = wx;
        this.wy = wy;
    }

    public WorldBlock(String btype, int wx, int wy) {
        this.wx = wx;
        this.wy = wy;   

        try {
            Class c = Class.forName(btype);
            Object obj = c.newInstance();
            if(obj instanceof SpawnableObject) {
                block = (SpawnableObject)obj;
            }
            else {
                throw new IllegalArgumentException("Illegal block type: non-SpawnableObject.");
            }
        }
        catch(ClassNotFoundException e) {
            throw new IllegalArgumentException("Illegal block type: class non-existent.");
        }
        catch(InstantiationException e) {
            throw new IllegalArgumentException("Illegal block type: non-instantiable type.");
        }
        catch(IllegalAccessException e) {
            throw new IllegalArgumentException("Illegal block type: illegal access exception thrown.");
        }
        catch(SecurityException e) {
            throw new IllegalArgumentException("Illegal block type: security exception thrown.");
        }
    }

    public SpawnableObject getBlock() {
        return block;
    }

    /**
     * Returns the x coordinate of the block.
     * @return the x coordinate of the block
     */
    public int getWorldX() {
        return wx;
    }

    public int getWorldY() {
        return wy;
    }
}
