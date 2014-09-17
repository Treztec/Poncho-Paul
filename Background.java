import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    public Counter counter;

    /**
     * Constructor for objects of class background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1, false); 

        prepare();
    }

    public void endGame()
    {
        GameOver gameover = new GameOver();
        addObject(gameover, 560, 298);
        Greenfoot.stop();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground, 38, 574);
        ground.setLocation(30, 567);
        Ground ground2 = new Ground();
        addObject(ground2, 301, 200);
        Ground ground3 = new Ground();
        addObject(ground3, 587, 213);
        Ground ground4 = new Ground();
        addObject(ground4, 799, 231);
        Ground ground5 = new Ground();
        addObject(ground5, 837, 302);
        Ground ground6 = new Ground();
        addObject(ground6, 713, 388);
        Ground ground7 = new Ground();
        addObject(ground7, 511, 366);
        Ground ground8 = new Ground();
        addObject(ground8, 328, 335);
        Ground ground9 = new Ground();
        addObject(ground9, 211, 324);
        Ground ground10 = new Ground();
        addObject(ground10, 151, 260);
        Ground ground11 = new Ground();
        addObject(ground11, 418, 93);
        Ground ground12 = new Ground();
        addObject(ground12, 593, 105);
        Ground ground13 = new Ground();
        addObject(ground13, 806, 116);
        Ground ground14 = new Ground();
        addObject(ground14, 922, 159);
        Ground ground15 = new Ground();
        addObject(ground15, 946, 199);
        Ground ground16 = new Ground();
        addObject(ground16, 1005, 282);
        Ground ground17 = new Ground();
        addObject(ground17, 1005, 340);
        Ground ground18 = new Ground();
        addObject(ground18, 902, 384);
        Ground ground19 = new Ground();
        addObject(ground19, 716, 338);
        Ground ground20 = new Ground();
        addObject(ground20, 622, 295);
        Ground ground21 = new Ground();
        addObject(ground21, 556, 325);
        Ground ground22 = new Ground();
        addObject(ground22, 464, 269);
        Ground ground23 = new Ground();
        addObject(ground23, 485, 214);
        Ground ground24 = new Ground();
        addObject(ground24, 482, 201);
        ground9.setLocation(95, 567);
        ground8.setLocation(161, 567);
        ground7.setLocation(320, 536);
        ground7.setLocation(226, 567);
        ground21.setLocation(292, 567);
        ground22.setLocation(358, 567);
        ground6.setLocation(495, 520);
        ground6.setLocation(423, 567);
        ground20.setLocation(489, 567);
        ground19.setLocation(619, 527);
        ground19.setLocation(555, 567);
        ground18.setLocation(621, 567);
        ground5.setLocation(687, 567);
        ground4.setLocation(753, 567);
        ground24.setLocation(918, 510);
        ground24.setLocation(818, 567);
        ground17.setLocation(926, 560);
        ground17.setLocation(884, 567);
        ground16.setLocation(950, 567);
        ground15.setLocation(1038, 556);
        ground15.setLocation(1014, 567);
        ground14.setLocation(1080, 567);
        ground23.setLocation(619, 529);
        ground3.setLocation(511, 363);
        ground3.setLocation(668, 286);
        ground23.setLocation(509, 292);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(593, 105);
        ground12.setLocation(646, 116);
        removeObject(ground12);
        removeObject(ground3);
        removeObject(ground23);
        removeObject(ground2);
        removeObject(ground10);
        removeObject(ground11);
        removeObject(ground13);
//         ScrollingSqare scrollingsqare = new ScrollingSqare();
//         addObject(scrollingsqare, 551, 200);
//         scrollingsqare.setLocation(554, 326);
//         scrollingsqare.setLocation(553, 410);
//         scrollingsqare.setLocation(556, 428);
//         scrollingsqare.setLocation(99, 440);
//         ScrollingSqare scrollingsqare2 = new ScrollingSqare();
//         addObject(scrollingsqare2, 1006, 436);
        // Cut here
        counter = new Counter();
        addObject(counter, 937, 59);
        // Cut here
//        scrollingsqare2.setLocation(877, 424);
        RightScrollingSquare rightscrollingsquare = new RightScrollingSquare();
        addObject(rightscrollingsquare, 1020, 417);
        rightscrollingsquare.setLocation(1043, 425);
//        scrollingsqare2.setLocation(926, 419);
//        removeObject(scrollingsqare2);
        rightscrollingsquare.setLocation(1008, 417);
//        scrollingsqare.setLocation(280, 414);
//         removeObject(scrollingsqare);
        LeftScrollingSquare leftscrollingsquare = new LeftScrollingSquare();
        addObject(leftscrollingsquare, 216, 487);
        leftscrollingsquare.setLocation(183, 518);
        leftscrollingsquare.setLocation(47, 530);
        Paul paul = new Paul();
        addObject(paul, 513, 482);
        paul.setLocation(529, 507);
    }
}