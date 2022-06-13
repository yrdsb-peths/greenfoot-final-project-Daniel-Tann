import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    SimpleTimer attack = new SimpleTimer();
    SimpleTimer attack2 = new SimpleTimer();
    int x = 0;
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FinalBoss()
    {
        attack.mark();
    }
    public void act()
    {
        setLocation(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        if(attack.millisElapsed() > 5000)
        {
            x = Greenfoot.getRandomNumber(1);
            if(x == 0)
            {
                MyWorld world = (MyWorld) getWorld();
                for(int i = 0; i < 5; i++)
                {
                    world.attackTwo();
                }
            }
            if(x == 1)
            {
                MyWorld world = (MyWorld) getWorld();
                world.attackOne(getX(), getY());
            }
            attack.mark();
        }
    }
}
