import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ScrollingSqare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ScrollingSqare extends Actor
{
    
    
    /**
     * Act - do whatever the ScrollingSqare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(isTouching(Paul.class)) {
           //System.out.println("Hi There");            
        }
    }
    
    protected void scroll(int s){
        for(ScrollsOnScreen g: (List<ScrollsOnScreen>)getWorld().getObjects(ScrollsOnScreen.class)){
            g.setLocation(g.getX() + s, g.getY());
        }
        
//         for(Sand sa : (List<Sand>) getWorld().getObjects(Sand.class)) {
//             sa.setLocation(sa.getX() + s, sa.getY());
//         }
    }

    protected void scrollCharacter(int s){
        for(Paul g: (List<Paul>)getWorld().getObjects(Paul.class)){
            g.setLocation(g.getX() + s, g.getY());
        }   
    }
}
