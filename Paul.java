import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Paul here.
 * 
 * @author  William Trent 
 * @version v1.1
 */
public class Paul extends Animal {

    private static final double GRAVITY = 0.6;
    private static final int MOVE_SPEED = 5;
    private static final int JUMP_SPEED = -10;

    private int Delay = 50;
    //private int Speed = 4;
    private double vSpeed = 0.0;
    private double acceleration = .5;
    private int jSpeed = -5;
    private int AnimationCounter = 0;
    private boolean jumping;
    private boolean hitGround = false;
    private int kSpeed = 6;
    private int frame = 0;
    private int wCount = 0;
    private long timeMillis;
    private int num = 17;
    private boolean lface;
    private boolean rface = true;
    private static final int SHOOT_DELAY = 27;
    private boolean canShoot = true;
    private int delayCounter;
    public static final int BG_SCROLL_RATE =1;
    public static final int FG_SCROLL_RATE = 2;
    private int time = 0;
    //private boolean lPass = false;
    //private boolean RPass = false;
    private boolean jnum = true;

    private static final GreenfootImage bullet = new GreenfootImage("haloFire.png");
    private static final GreenfootImage[] rFrames = {
            new GreenfootImage("hRRun1.png"),
            new GreenfootImage("hRRun2.png"),
            new GreenfootImage("hRRun3.png"),
            new GreenfootImage("hRRun4.png"),
            new GreenfootImage("hRRun5.png"),
            new GreenfootImage("hRRun6.png"),
            new GreenfootImage("hRRun7.png"),
            new GreenfootImage("hRRun8.png"),
            new GreenfootImage("hRRun9.png")
        };

    private static final GreenfootImage[] lFrames = {
            new GreenfootImage("hLRun1.png"),
            new GreenfootImage("hLRun2.png"),
            new GreenfootImage("hLRun3.png"),
            new GreenfootImage("hLRun4.png"),
            new GreenfootImage("hLRun5.png"),
            new GreenfootImage("hLRun6.png"),
            new GreenfootImage("hLRun7.png"),
            new GreenfootImage("hLRun8.png"),
            new GreenfootImage("hLRun9.png"),
        };

    private double velocity = 0;

    private Direction direction = Direction.RIGHT;
    private int frameNum = 0;
    private boolean lPass, rPass;
    private int Speed = MOVE_SPEED;

    public void advanceFrame() {
        frameNum++;
        frameNum = frameNum % 36;
        if(direction == Direction.RIGHT) {
            setImage(rFrames[frameNum / 4]);
        }
        else {
            setImage(lFrames[frameNum / 4]);
        }
    }

    public boolean isOnGround() {
        return getOneObjectAtOffset(0,getImage().getHeight()/2+1, Ground.class) != null;
    }

    public void act() {
        handleMotion();
        if(!isOnGround()) {
            setLocation(getX(), (int)(getY()+velocity));
            velocity = velocity + GRAVITY;
        }
        else {
            Ground g = (Ground)getOneObjectAtOffset(0,getImage().getHeight()/2+1, Ground.class);
            setLocation(getX(), g.getY()-g.getImage().getHeight()/2-getImage().getHeight()/2+1);
            velocity = 0;

            scrollWithSquare();
            scrollWithLSquare();

        }
        checkForRightWalls();
        checkForLeftWalls();
        checkForCeiling();
        checkKeys();
    }

    private boolean keyDown = false;
    private boolean keyDown2 = false;
    public void checkKeys() {
        if(Greenfoot.isKeyDown(Controls.DEBUG1)) {
            System.out.printf("(%d,%d)%n",getX(),getY());
        }
        if(!keyDown2 && Greenfoot.isKeyDown(Controls.SHOOT)){

            switch(direction) {
                case RIGHT:
                    shootRight();
                    break;
                case LEFT:
                    shootLeft();
                    break;
            }
}

// Deprecate Code
//         if(direction == Direction.RIGHT) {  
//             shootRight();
// 
//         } else {
//             shootLeft();
// 
//         }
    
}

public void handleMotion() {
if(Greenfoot.isKeyDown(Controls.RIGHT)) {
direction = Direction.RIGHT;
setLocation(getX()+Speed, getY());
advanceFrame();
rface =true;
lface =false;            
}
if(Greenfoot.isKeyDown(Controls.LEFT)) {
direction = Direction.LEFT;
setLocation(getX()-MOVE_SPEED, getY());
advanceFrame();
lface = true;
rface = false;
}
if(Greenfoot.isKeyDown(Controls.UP) && isOnGround()) {
velocity = JUMP_SPEED;
setLocation(getX(),(int)(getY()+velocity));
}
}

public void scroll(int s){
for(Ground g: (List<Ground>)getWorld().getObjects(Ground.class)){
g.setLocation(g.getX() + s, g.getY());
}

}

public void scrollLCharacter(int s){
for(Paul g: (List<Paul>)getWorld().getObjects(Paul.class)){
g.setLocation(g.getX() - s, g.getY());
}

}

public void scrollRCharacter(int s){
for(Paul g: (List<Paul>)getWorld().getObjects(Paul.class)){
g.setLocation(g.getX() + s, g.getY());
}

}

public boolean isTouching(Class c) {
return getOneIntersectingObject(c) != null;
}

public void scrollWithSquare(){

int spriteWidth = getImage().getWidth();
int xDistance = (int) (spriteWidth / 4);
Actor rightWall = getOneObjectAtOffset(xDistance, 0, ScrollingSqare.class);
if(rightWall == null) {
lPass = false;
rPass = true;

}
if(isTouching(ScrollingSqare.class) && lPass == true ) {
scroll(-4);
s0......
crollLCharacter(5);

} else{

}

}

public void scrollWithLSquare(){
int spriteWidth = getImage().getWidth();
int xDistance = (int) (spriteWidth / -4);
Actor LeftWall = getOneObjectAtOffset(xDistance, 0, ScrollingSqare.class);
if(LeftWall == null) {
lPass = true;
rPass = false;

}
if(isTouching(ScrollingSqare.class) && rPass == true){
scroll(4);
scrollRCharacter(5);
} else {

}
}

/**
 * it checks if right wall is activated, and implements the code if it fits conditions set by charecters enviroment
 */
public boolean checkForRightWalls() {
int spriteWidth = getImage().getWidth();
int xDistance = (int) (spriteWidth / 2);
Actor rightWall = getOneObjectAtOffset(xDistance, 0, Ground.class);
if(rightWall == null) {
return false;
} else {
stopByRightWall(rightWall);
return true;
}

}

/**
 * gets location of right wall, stops charecter at position and sets him 5 pixels back
 */
public void stopByRightWall(Actor rightWall) {
int rightWallWidth = rightWall.getImage().getWidth();
int newX = rightWall.getX() - (rightWallWidth + getImage().getWidth())/2;
scroll(Speed);
}

/**
 * checks if left wall is activated, implements conditions in order to apply or not apply left wall code
 */
public boolean checkForLeftWalls() {
int spriteWidth = getImage().getWidth();
int xDistance = (int) (spriteWidth / -2);
Actor LeftWall = getOneObjectAtOffset(xDistance, 0, Ground.class);
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
scroll(-Speed);
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

Actor ceiling = getOneObjectAtOffset(0, yDistance, Ground.class);
if(ceiling != null) {
vSpeed = 0;
bopHead(ceiling);
return true;

}else{
return false;

}

}

public void shootRight() {
if(canShoot == true) {
int spriteWidth = getImage().getWidth();
int gunTop = (int) spriteWidth/2;
RightBullet b = new RightBullet();
getWorld().addObject(b, getX() + gunTop + 13, getY() - 17);
delayCounter = 0;
canShoot = false;
return;
}
if(!canShoot && ++delayCounter> SHOOT_DELAY) {
canShoot = true;
}
}

public void shootLeft() {
if(canShoot == true) {
int spriteWidth = getImage().getWidth();
int gunTop = (int) spriteWidth/2;
leftBullet lb = new leftBullet();
getWorld().addObject(lb, getX() - gunTop - 13, getY() - 17);
delayCounter = 0;
canShoot = false;
return;
}
if(!canShoot && ++delayCounter> SHOOT_DELAY) {
canShoot = true;}
}
}
