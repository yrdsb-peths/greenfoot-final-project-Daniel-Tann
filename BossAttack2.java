import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second type of attack the boss uses.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class BossAttack2 extends Actor
{
    GreenfootImage attack = new GreenfootImage("images/bossBeam.png");
    SimpleTimer attackDelay = new SimpleTimer();
    int rotate = 0;
    int x = 1;
    int numTurns = 360;
    int xScale = 1200;
    int yScale = 40;
    /**
     * Act - do whatever the BossAttack2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BossAttack2()
    {
        setImage(attack);
        attack.scale(xScale,yScale);
        attackDelay.mark();
    }
    
    public void act()
    {
        if(attackDelay.millisElapsed() > 200)
        {
            if(isTouching(Person.class))
            {
                MyWorld world = (MyWorld) getWorld();
                world.loseScreen();
                removeTouching(Person.class);
            }
            if(isTouching(Shield.class))
            {
                xScale = xScale/2;
                attack.scale(xScale,yScale);
               x = x*-1;
               
               numTurns = 180;
            }
            if(rotate >= numTurns)
            {
                getWorld().removeObject(this);
            }
            turn(x);
            rotate++;
        }
    }
}
