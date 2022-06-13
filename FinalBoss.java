import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    SimpleTimer teleport = new SimpleTimer();
    SimpleTimer attack = new SimpleTimer();
    SimpleTimer attack2 = new SimpleTimer();
    SimpleTimer star = new SimpleTimer();
    int x = 0;
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FinalBoss()
    {
        attack.mark();
        teleport.mark();
        star.mark();
    }
    public void act()
    {
        if(teleport.millisElapsed() > 2000)
        {
            setLocation(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));            
            teleport.mark();
        }
        if(attack.millisElapsed() > 5000)
        {           
            if(x % 2 == 1)
            {
                MyWorld world = (MyWorld) getWorld();
                for(int i = 0; i < 10; i++)
                {
                    world.attackTwo();
                }
            }
            if(x % 2 == 0)
            {
                MyWorld world = (MyWorld) getWorld();
                world.attackOne(getX(), getY());
            }
            x++;
            attack.mark();
        }
        if(star.millisElapsed() > 7000)
        {
            MyWorld world = (MyWorld) getWorld();        
            world.summonStar();
            star.mark();
        }
    }
}
