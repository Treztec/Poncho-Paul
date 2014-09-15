import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeathBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeathBlock extends Animal
{
    /**
     * Act - do whatever the DeathBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if(isTouching(Paul.class)){
        touchDeath();
    }
    }    

    public void touchDeath()
    {
    ((Background)getWorld()).endGame();
    }    


}
