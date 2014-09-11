import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class SpaceMan extends Animal
{
    private int Delay = 50;
    private int Speed = 4;
    private double vSpeed = 0.0;
    private double acceleration = .5;
    private int jSpeed = -16;
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
    private static final int SHOOT_DELAY = 8;
    private boolean canShoot= true;
    private int delayCounter;
     public static final int BG_SCROLL_RATE =1;
    public static final int FG_SCROLL_RATE = 2;
    private int time = 0;
     private boolean lPass = false;
    private boolean RPass = false;
    private boolean jnum = true;
    private GreenfootImage bullet = new GreenfootImage("haloFire.png");
    private GreenfootImage RRun1 = new GreenfootImage("hRRun1.png");
    private GreenfootImage RRun2 = new GreenfootImage("hRRun2.png");
    private GreenfootImage RRun3 = new GreenfootImage("hRRun3.png");
    private GreenfootImage RRun4 = new GreenfootImage("hRRun4.png");
    private GreenfootImage RRun5 = new GreenfootImage("hRRun5.png");
    private GreenfootImage RRun6 = new GreenfootImage("hRRun6.png");
    private GreenfootImage RRun7 = new GreenfootImage("hRRun7.png");
    private GreenfootImage RRun8 = new GreenfootImage("hRRun8.png");
    private GreenfootImage RRun9 = new GreenfootImage("hRRun9.png");
    private GreenfootImage LRun1 = new GreenfootImage("hLRun1.png");
    private GreenfootImage LRun2 = new GreenfootImage("hLRun2.png");
    private GreenfootImage LRun3 = new GreenfootImage("hLRun3.png");
    private GreenfootImage LRun4 = new GreenfootImage("hLRun4.png");
    private GreenfootImage LRun5 = new GreenfootImage("hLRun5.png");
    private GreenfootImage LRun6 = new GreenfootImage("hLRun6.png");
    private GreenfootImage LRun7 = new GreenfootImage("hLRun7.png");
    private GreenfootImage LRun8 = new GreenfootImage("hLRun8.png");
    private GreenfootImage LRun9 = new GreenfootImage("hLRun9.png");

    
    /**
     * Act - do whatever the SpaceMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Cut here
        ((Background)getWorld()).counter.setValue(getY());
        // Cut here
        checkFall();

        checkKeys();
        //ifFallenDisapear();
        AnimationCounter ++;
        checkForCeiling();
        checkForLeftWalls();
        checkForRightWalls();
         scrollWithSquare();
           scrollWithLSquare();
           setLocation(getX() ,  (int)(getY() + vSpeed));
        
          if(vSpeed != 0.0) {
           vSpeed = vSpeed + acceleration;
          
        } else {
            vSpeed = 0.0;
        }
    }
   public void scroll(int s){
       for(Ground g: (List<Ground>)getWorld().getObjects(Ground.class)){
            g.setLocation(g.getX() + s, g.getY());
      }
      
    }
       public void scrollLCharecter(int s){
       for(SpaceMan g: (List<SpaceMan>)getWorld().getObjects(SpaceMan.class)){
            g.setLocation(g.getX() - s, g.getY());
      }
      
    }
       public void scrollRCharecter(int s){
       for(SpaceMan g: (List<SpaceMan>)getWorld().getObjects(SpaceMan.class)){
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
           RPass = true;
         
        }
       if(isTouching(ScrollingSqare.class) && lPass == true ) {
           scroll(-4);
           scrollLCharecter(4);
          
           } else{
         
        }
         
        }
        public void scrollWithLSquare(){
           int spriteWidth = getImage().getWidth();
           int xDistance = (int) (spriteWidth / -4);
           Actor LeftWall = getOneObjectAtOffset(xDistance, 0, ScrollingSqare.class);
          if(LeftWall == null) {
            lPass = true;
            RPass = false;
          
           }
           if(isTouching(ScrollingSqare.class) && RPass == true){
             scroll(4);
             scrollRCharecter(4);
            } else {
             
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
    
    /**
     * checks if charecter is on the ground
     */
    public boolean onGround() {
      int spriteHeight = getImage().getHeight();
      int lookForGround = (int)(spriteHeight/2) ;
        
        Actor under = getOneObjectAtOffset( 0, lookForGround+5 , Ground.class);
        if (under == null) {
           
            return false;
            
        } else {
            
            moveToGround(under);
            vSpeed = 0.0;
                
             return true;
        }
  
    }

    /**
     * sets charecter to edge of the ground
     */
    public void moveToGround(Actor under) {
       int groundHeight = getImage().getHeight();
        int newY = under.getY() - (groundHeight + getImage().getHeight())/2;
       setLocation(getX(), newY);
       
    }
    
     /**
      * checks if charecter fell
      */
        public void checkFall() {
      if(onGround() == true) {
         vSpeed = 0;
     //         jumping = false;
        }
         else{
        
        fall();
         checkForCeiling();
        onGround();
      } 
        

    }
   
     /**
      * code to set charecter to fall
      */
      public void fall() {
        setLocation( getX(), (int)(getY()+ vSpeed ));
        vSpeed = vSpeed + acceleration;
//        jumping = true;
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
      * controls for charecter
      */
        
     
     private boolean keyDown = false;
      private boolean keyDown2 = false;
        public void checkKeys() {
            if(Greenfoot.isKeyDown("0")) {
                System.out.printf("(%d,%d)%n",getX(),getY());
            }
        if(Greenfoot.isKeyDown("a")) 
       {
        
        turnLeft();
        move(-Speed);
      
        lface = true;
        rface = false;
        if(!Greenfoot.isKeyDown("a")) {
              setImage(LRun1);
              frame = 1;
            }
           
       }
        if(Greenfoot.isKeyDown("d"))
        {
            
          turnRight();
          move(Speed);
         
          rface =true;
          lface =false;
          if(!Greenfoot.isKeyDown("d")) {
              setImage(RRun1);
              frame = 1;
            }
          
       }
         
       if(!keyDown && Greenfoot.isKeyDown("w") && onGround()) { 
         
       jump(); 
       keyDown = true;
       
      
    }else if(keyDown && !Greenfoot.isKeyDown("w")) {
     keyDown = false;
    }
  
      if(!keyDown2 && Greenfoot.isKeyDown(" ")){
      
        if(rface == true) {  
       shootRight();
       
    
      } else {
       shootLeft();
    
    
    }
  
    
 }
}
  
   /**
    * jumping mechanism
    */
    public void jump() {
       if(vSpeed == 0.0){ 
           vSpeed = jSpeed;
      
    System.out.println("*** "+getY());
    }
    }
     /**
      * sets charecters movements to the left
      */
     public void turnLeft() {
           
    
       if(AnimationCounter % 4 == 0){
      moveLeft();
      }
    }

      /**
       * animation of moving left
       */
     public void moveLeft() {
      if(frame == 1) {
              setImage(LRun1);
            }
            else if(frame == 2) {
              setImage(LRun2);
            }
            else if(frame == 3) {
              setImage(LRun3);
            }
            else if(frame == 4) {
              setImage(LRun4);
            }
            else if(frame == 5) {
              setImage(LRun5);
            }
            else if(frame == 6) {
              setImage(LRun6);
            }
            else if(frame == 7) {
              setImage(LRun7);
            }
            else if(frame == 8) {
                setImage(LRun8);
            }
            else if(frame == 9) {
                setImage(LRun9);
            
      
              frame = 1;
              return;
            }
           frame ++;  
    }
  
    /**
     * sets charecters movement to the right
     */
   
   public void turnRight() {
       
        if(AnimationCounter % 4 == 0){
        moveRight();
    }
        
    }
   
   /**
    * animation of moving to the right
    */
   public void moveRight() {
          if(frame == 1) {
              setImage(RRun1);
            }
            else if(frame == 2) {
              setImage(RRun2);
            }
            else if(frame == 3) {
              setImage(RRun3);
            }
            else if(frame == 4) {
              setImage(RRun4);
            }
            else if(frame == 5) {
              setImage(RRun5);
            }
            else if(frame == 6) {
              setImage(RRun6);
            }
           else if(frame == 7) {
              setImage(RRun7);
            }
          else if(frame == 8) {
                setImage(RRun8);
            }
            else if(frame == 9) {
                setImage(RRun9);
            
              frame = 1;
              return;
            }
           frame ++;
        }
           
              
                
}
