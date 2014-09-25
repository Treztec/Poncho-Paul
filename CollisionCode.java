import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CollisionCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionCode extends Actor
{
    
    protected int vSpeed;
    protected boolean jumping;
    
    /**
     * Act - do whatever the CollisionCode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
//     public static boolean checkForRightWalls(Actor a) {
//         int spriteWidth = a.getImage().getWidth();
//         int xDistance = spriteWidth / 2;
//         Actor rightWall = a.getOneObjectAtOffset(xDistance, 0, SolidObject
//         .class);
//         if(rightWall == null) {
//             return false;
//         } else {
//             stopByRightWall(rightWall);
//             return true;
//         }
// 
//     }
    
//     public void checkForRightWalls() {
//         checkForRightWalls(this);
//     }
    
    /**
     * gets location of right wall, stops charecter at position and sets him 5 pixels back
     */
    public void stopByRightWall(Actor rightWall) {
        int rightWallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (rightWallWidth + getImage().getWidth())/2;
        setLocation(newX, getY());
        //scroll(Speed);
    }

    /**
     * checks if left wall is activated, implements conditions in order to apply or not apply left wall code
     */
    public boolean checkForLeftWalls() {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int) (spriteWidth / -2);
        Actor LeftWall = getOneObjectAtOffset(xDistance, 0, SolidObject.class);
        if(LeftWall == null) {
            return false;
        } else {
            stopByLeftWall(LeftWall);
            return true;
        }

    }

    /**
     * code to stop charecter by left walls and set them back 5 pixels
     */
    public void stopByLeftWall(Actor LeftWall) {
        int LeftWallWidth = LeftWall.getImage().getWidth();
        int newX = LeftWall.getX() - (LeftWallWidth + getImage().getWidth())/-2;
        setLocation(newX, getY());
        //scroll(-Speed);
    }

    /**
     * if there is a celing then charecter is stoped
     */
    public void bopHead(Actor ceiling) {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = true;
    }

    /**
     * charecter checks for ceiling, using bophead() to stop charecter from traversing ceiling
     */
    public boolean checkForCeiling() {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int) (spriteHeight / -2);

        Actor ceiling = getOneObjectAtOffset(0, yDistance, SolidObject.class);
        if(ceiling != null) {
            vSpeed = 0;
            bopHead(ceiling);
            return true;

        }else{
            return false;

        }

    }
    
}
