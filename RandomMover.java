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
    public void moveAround() {
        
       move(4);
       if (Greenfoot.getRandomNumber(100) < 10) 
       {
           turn(Greenfoot.getRandomNumber(90) - 45); 
       }
           
       if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
       {
           turn(180);
       }
       
       if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
       {
           turn(180);
        }
    
    }
    //interface MoveRandomly {
     //   void moveAround();
   // }
}