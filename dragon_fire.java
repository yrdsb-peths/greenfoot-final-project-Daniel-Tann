import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dragon_fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dragon_fire extends Actor
{
    GreenfootImage part_one = new GreenfootImage("images/Fire.png");
    int x = 0;
    int y = 0;
    int fire = 1;
    /**
     * Act - do whatever the dragon_fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public dragon_fire()
    {
        setImage(part_one);
        part_one.scale(100,50);
    }
    public void act()
    {
        if(fire == 1)
        {
            coords();
            fire--;
        }
        move(-1);
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
