import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    GreenfootImage boss = new GreenfootImage("images/PngItem_377031.png");
    public Dragon()
    {
        setImage(boss);
        boss.scale(100,100);
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
    }
}
