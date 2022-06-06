import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    SimpleTimer dragonBreath = new SimpleTimer();
    GreenfootImage boss = new GreenfootImage("images/PngItem_377031.png");
    public Dragon()
    {
        setImage(boss);
        boss.scale(100,100);
        dragonBreath.mark();
    }
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-1);
        if(isAtEdge())
        {
            turn(180);
        }
        if(dragonBreath.millisElapsed() > 10000)
        {
            MyWorld world = (MyWorld) getWorld();
            world.spawnFire(getX(), getY());
        }
    }
    
}
