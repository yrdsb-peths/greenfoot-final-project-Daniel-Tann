import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlimeMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeMonster extends Actor
{
    GreenfootImage slimeRight = new GreenfootImage("images/slime.png");
    GreenfootImage slimeLeft = new GreenfootImage("images/slime.png");
    String facing = "left";
    /**
     * Act - do whatever the SlimeMonster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SlimeMonster()
    {
        slimeRight.mirrorHorizontally();
        setImage(slimeLeft);
        slimeLeft.scale(100,100);
        slimeRight.scale(100,100);
        
    }
    public void act()
    {
        if(facing.equals("left"))
        {
            move(-1);
        }
        if(facing.equals("right"))
        {
            move(1);
        }
        if(getX() == 0)
        {
            setImage(slimeRight);
            facing = "right";
        }
        if(getX() == 599)
        {
            setImage(slimeLeft);
            facing = "left";
        }
        if(isTouching(Shield.class))
        {
            setLocation(getX(), 20);
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
    }
}
