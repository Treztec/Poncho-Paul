import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Spree extends BadGuys
{
    private int numTurn = 2;
    private int Speed = 3;  
    private int vSpeed = 0;
    private int acceleration = 2;
    private int jSpeed = 1;
    private int SpriteHeight = getImage().getHeight();
    private int SpriteWidth = getImage().getHeight();
    private int LookForGroundDistance = (int) SpriteHeight/2;
    private int LookForEdge = (int) SpriteWidth/2;
    private int turnApp = 1;
    /**
     * Act - do whatever the Spree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkFall();
        ifFallenDisapear();
        AI();
       // Destroy();
        Edge();
        
    }
    public void Edge() {
        if(atWorldEdge()) {
            getWorld().removeObject(this);
        }
    }
    /*public void Destroy() {
        if(isTouching(SpaceMan.class)) {
           eat(SpaceMan.class);
           
        }
    }
    */
    
  

    public void AI() { 
       Actor ground = getOneObjectAtOffset(LookForEdge, LookForGroundDistance, Ground.class);
       if(ground == null) {
           Speed *= -1;
           LookForEdge *= -1;
                  if(ground == null) {
        numTurn = numTurn - 1;
    }
    if(numTurn == 1 )
    {
    leftFace();
    }
    if(numTurn == 0 ) {
    rightFace();
    numTurn = 2;
    }

           
        }else {
            move(Speed);
        }
} 
 

public void touchDeath()
{
    ((Background)getWorld()).endGame();
}    
       

        
    public void ifFallenDisapear() {
        if(atWorldEdge()) {
            getWorld().removeObject(this);
        }
    }
      public void checkFall() {
      if(onGround()) {
         vSpeed = 0;
        }else{
          fall();
        }
  }
    public boolean onGround() {
       Actor under = getOneObjectAtOffset( 1, getImage().getHeight() / 2 , Ground.class);
   return under != null;
  
}
  public void fall() {
        setLocation( getX(), getY()+ vSpeed );
        vSpeed = vSpeed + acceleration;

    }
    public void leftFace() {
        setImage("mouseLeft.png");
    }
    public void rightFace() {
        setImage("mouseRight.png");
    }
}

