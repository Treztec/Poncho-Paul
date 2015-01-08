import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthMeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthMeter extends Actor
{

    public static final int INIT_HEARTS = 3;
    public static final int MAX_HEARTS = 20;
    public static final GreenfootImage HEART_IMG =
        new GreenfootImage("heartsmall.png");

    private final GreenfootImage baseMeter;
    private double meterAmount; // range from 0.0 - 1.0
    
    
    public HealthMeter() {
        meterAmount = ((double)INIT_HEARTS)/MAX_HEARTS;
        GreenfootImage baseMeter = new GreenfootImage(MAX_HEARTS*HEART_IMG.getWidth(), HEART_IMG.getHeight());
          
        setImage(bg);
        
}
