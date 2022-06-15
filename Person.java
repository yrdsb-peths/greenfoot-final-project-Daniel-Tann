import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main actor class the player plays.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class Person extends Actor
{
    SimpleTimer time = new SimpleTimer();
    SimpleTimer jump = new SimpleTimer();
    SimpleTimer shoot = new SimpleTimer();
    SimpleTimer gracePeriod = new SimpleTimer();
    SimpleTimer shieldCoolDown = new SimpleTimer();
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Person()
    {
        time.mark();
        jump.mark();
        shoot.mark();
        shieldCoolDown.mark();
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        MyWorld world = (MyWorld) getWorld();
        world.updateCoord(getX(), getY());
        if(getX() > 599)
        {
            setLocation(598, getY());
        }
        if(getX() < 1)
        {
            setLocation(2, getY());
        }
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
        if(jump.millisElapsed() > 3000 && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-380);
            jump.mark();
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
        if(shoot.millisElapsed() > 1000)
        {
            if(mouse != null)
            {            
                if(mouse.getButton() == 1)
                {
                    shoot.mark();
                    world.spawnLaser(getX(), getY());
                }
            }
        }
        if(Greenfoot.isKeyDown("e") && shieldCoolDown.millisElapsed() > 3500)
        {
            world.spawnShield(getX(),getY());
            shieldCoolDown.mark();
        }
        if(getNeighbours(600, true, snake.class).size() < 1 && getNeighbours(600, true, Dragon.class).size() < 1 && getNeighbours(600, true, enemy.class).size() < 1 && getNeighbours(600, true, SlimeMonster.class).size() < 1)
        {
            if(isTouching(Portal.class))
            {
                setLocation(50, 380);
                world.nextWorld();
                
            }
           
        }
        if(isTouching(star.class))
        {
            gracePeriod.mark();
            removeTouching(star.class);
            world.hitBoss();
        }
        if(gracePeriod.millisElapsed() > 3000)
        {
            world.deHitBoss();
        }
        
            
    }
   
}
