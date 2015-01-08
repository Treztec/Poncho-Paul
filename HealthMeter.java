import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
        
    public static final Color TRANSPARENT = new Color(0,0,0,0);

    private final GreenfootImage baseMeter;
    private double meterAmount; // range from 0.0 - 1.0
    
    
    public HealthMeter() {
        meterAmount = ((double)INIT_HEARTS)/MAX_HEARTS;
        baseMeter = new GreenfootImage(MAX_HEARTS*HEART_IMG.getWidth(), HEART_IMG.getHeight());
        for(int i=0; i<MAX_HEARTS; i++) {
            baseMeter.drawImage(HEART_IMG,HEART_IMG.getWidth()*i, 0);
        }
        redraw();
    }
        
    public void redraw() {
        GreenfootImage img = new GreenfootImage(baseMeter);
        int pixelWidth = (int)(meterAmount*img.getWidth());
        for(int x=pixelWidth; x < img.getWidth(); x++) {
            for(int y=0; y < img.getHeight(); y++) {
                img.setColorAt(x, y, TRANSPARENT);
            }
        }
        setImage(img);
    }
    
    public double getAmount () {
        return meterAmount;
    }
    
    public void setAmount(double meterAmount) {
        this.meterAmount = meterAmount;
        redraw();
    }
    
    public void setHeartAmount(double amount) {
        setAmount(amount/MAX_HEARTS);
    }
    
}
