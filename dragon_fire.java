import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class which allows the Dragon actor to shoot fire.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class dragon_fire extends Actor
{
    GreenfootImage part_one = new GreenfootImage("images/Fire.png");
    int x = 0;
    int y = 0;
    int fire = 1;
    SimpleTimer turn = new SimpleTimer();
    /**
     * Act - do whatever the dragon_fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public dragon_fire()
    {
        setImage(part_one);
        part_one.scale(100,50);
        turn.mark();
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
           turn(70);
        }
        if(isTouching(dragon_fire.class) && getY() > 50 && turn.millisElapsed() > 500)
        {
            turnTowards(Greenfoot.getRandomNumber(600),0);
            turn.mark();
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
