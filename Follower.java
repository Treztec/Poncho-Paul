import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Follower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Follower extends Actor
{
    
    private int X;
    private int Y;
    
    /**
     * Act - do whatever the Follower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     followThatMouse();
    }  
    
    public void followThatMouse()
    {
         MouseInfo mi = Greenfoot.getMouseInfo();
         if(mi != null) {
             setLocation(mi.getX(), mi.getY());
            }
    
    
    }
}
