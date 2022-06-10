import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class slimeJuice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class slimeJuice extends Actor
{
    SimpleTimer dissolve = new SimpleTimer();
    GreenfootImage juices = new GreenfootImage("images/residue.png");
    /**
     * Act - do whatever the slimeJuice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public slimeJuice()
    {
        juices.mirrorVertically();
        dissolve.mark();
        setImage(juices);
        juices.scale(50,50);
    }
    public void act()
    {
        //removeTouching(Person.class);
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
        if(dissolve.millisElapsed() > 5000)
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }
    }
}
