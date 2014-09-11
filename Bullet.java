import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bullet extends Animal
{
 
    protected abstract void advance();

    /**
     * Act - do whatever the leftBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        advance(); // move forward in the correct direction

        if(canSee(Ground.class) || atWorldEdge()) {
            getWorld().removeObject(this);
            return;   
        }

        bImpact();
        takeExplosionTimer();
    } 
    private int ExplosionTimer = 0;
    private boolean isExplosion = false;

    public void bImpact(){

        for(Spree s : (List <Spree>)getWorld().getObjects(Spree.class)) {
            if(intersects(s)) {
                setImage("bulletImpact.png");  
                isExplosion = true;
            }

        }

    }

    public void takeExplosionTimer() {
        if(isExplosion == true){
            ExplosionTimer++;

        }
        if(ExplosionTimer == 1){
            ExplosionTimer = 0;
            getWorld().removeObject(this);

        }

    }
}
