/**
 * Represents a block existing at a particular set of world coordinates.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldBlock  
{
    private final SolidObject block;
    private final int wx, wy;

    public WorldBlock(SolidObject block, int wx, int wy) {
        this.block = block;
        this.wx = wx;
        this.wy = wy;
    }

    public WorldBlock(String btype, int wx, int wy) {
        if(btype.equals("Sand")) {
            this.block = new Sand();
            this.wx = wx;
            this.wy = wy;   
        }
        else if(btype.equals("Ground")) {
            this.block = new Ground();
            this.wx = wx;
            this.wy = wy;   

        }
        else {
            throw new IllegalArgumentException("Illegal block type.");
        }
    }

        public SolidObject getBlock() {
            return block;
        }

        public int getWorldX() {
            return wx;
        }

        public int getWorldY() {
            return wy;
        }
    }
