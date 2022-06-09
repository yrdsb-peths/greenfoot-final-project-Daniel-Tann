import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class appleSpin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class appleSpin extends Actor
{
    int x = 1;
    /**
     * Act - do whatever the appleSpin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-x);
        turn(1);
        x++;
    }
}
