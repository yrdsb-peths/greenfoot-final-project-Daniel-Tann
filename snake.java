import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        // Add your action code here.
        move(1);
        if(isTouching(Shield.class))
        {
            setLocation(getX(), getY()-20);
             turn(70);
        }
        if(isTouching(Person.class))
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
