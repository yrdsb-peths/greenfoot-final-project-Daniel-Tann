import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    SimpleTimer time = new SimpleTimer();
    SimpleTimer jump = new SimpleTimer();
    SimpleTimer grace = new SimpleTimer();
    GreenfootImage summonShield = new GreenfootImage("images/shield.png");
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
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()+80,getY());
            time.mark();
        }
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()-80, getY());
            time.mark();
        }
        //Moving Normally
        if(Greenfoot.isKeyDown("a"))
        {
            move(-1);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(1);
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
        if(grace.millisElapsed() > 3000)
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }
    }
}
