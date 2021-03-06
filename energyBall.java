import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class which allows the wizard enemy to shoot an energy ball. 
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class energyBall extends Actor
{
    int fire = 1;
    SimpleTimer expand = new SimpleTimer();
    /**
     * Act - do whatever the energyBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public energyBall()
    {
        expand.mark();
    }
    public void act()
    {
        if(fire == 1)
        {
            coords();
            fire--;
        }
        move(-1);
        if(isTouching(Shield.class))
        {
            setLocation(getX(), getY()-20);
           turn(180);
        }
        if(expand.millisElapsed() > 900)
        {
            MyWorld world = (MyWorld) getWorld();
            world.spawnEnergyBall(getX(), getY());
            expand.mark();
        }
       
        if(isTouching(Person.class) && getNeighbours(600, true, Shield.class).size() < 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.loseScreen();
            removeTouching(Person.class);
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            fire++;
        }   
    }
    public void coords()
    {
        turnTowards(Greenfoot.getRandomNumber(600),0);
    }
}
