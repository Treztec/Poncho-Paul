import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class RightScrollingSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightScrollingSquare extends ScrollingSqare
{
    /**
     * Act - do whatever the RightScrollingSquare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();

        if(isTouching(Paul.class) && Greenfoot.isKeyDown(Controls.RIGHT)) {
            scroll(-5);
            scrollCharacter(-5);
        }
    }
}