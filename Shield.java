import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An actor class which protects the player.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class Shield extends Actor
{
    SimpleTimer time = new SimpleTimer();
    SimpleTimer jump = new SimpleTimer();
    SimpleTimer grace = new SimpleTimer();
    GreenfootImage summonShield = new GreenfootImage("images/shield.png");
    int xCoord = 0;
    int yCoord = 0;
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run pressed in the environment.
     */
    public Shield()
    {
        setImage(summonShield);
        summonShield.scale(100,100);
        grace.mark();
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        xCoord = world.getXCoord();
        yCoord = world.getYCoord();
        setLocation(xCoord, yCoord);
        if(grace.millisElapsed() > 3000)
        {
            world.removeObject(this);
        }
    }
}
