import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main actor class for the snake enmy.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class snake extends Actor
{
    SimpleTimer spawn = new SimpleTimer();
    /**
     * Act - do whatever the snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public snake()
    {
        spawn.mark();
    }
    public void act()
    {
        move(1);
        if(isTouching(Shield.class))
        {
            setLocation(getX(), getY()-20);
             turn(70);
        }
        if(isTouching(Person.class) && getNeighbours(600, true, Shield.class).size() < 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.loseScreen();
            removeTouching(Person.class);
        }
        if(isAtEdge())
        {
            turn(70);
        }
        if(spawn.millisElapsed() > 10000)
        {
            MyWorld world = (MyWorld) getWorld();
            world.mitosis();
            spawn.mark();
        }
        
    }
}
