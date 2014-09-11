import greenfoot.*;
import greenfoot.Actor;
/**
 * Write a description of class RandomMover here.
 * 
 * @author William Trent 
 * @version 9/9/2014
 */

//Commented out due to bug
public class RandomMover extends Actor
{
    public static void moveAround(Actor a) {
        
       a.move(4);
       if (Greenfoot.getRandomNumber(100) < 10) 
       {
           a.turn(Greenfoot.getRandomNumber(90) - 45); 
       }
           
       if (a.getX() <= 5 || a.getX() >= a.getWorld().getWidth() - 5)
       {
           a.turn(180);
       }
       
       if (a.getY() <= 5 || a.getY() >= a.getWorld().getHeight() - 5)
       {
           a.turn(180);
        }
    
    }
    
    public void moveAround() {
        moveAround(this);
    }
    
    
    //interface MoveRandomly {
     //   void moveAround();
   // }
}