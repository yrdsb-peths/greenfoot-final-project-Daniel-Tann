import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer cast = new SimpleTimer();
    public enemy()
    {
        cast.mark();
    }
    public void act()
    {
        if(cast.millisElapsed() > 2000)
        {
            setLocation(Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(200));
            MyWorld world = (MyWorld) getWorld();
            world.spawnEnergyBall(getX(), getY());
            for(int i = 0; i < 10; i++)
            {
                world.spawnEnergyBall(getX(), getY());
            }
            cast.mark();
        }
        
        // Add your action code here.
    }
    
    
}
