import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossAttack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossAttack2 extends Actor
{
    GreenfootImage attack = new GreenfootImage("images/bossBeam.png");
    int rotate = 0;
    /**
     * Act - do whatever the BossAttack2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BossAttack2()
    {
        setImage(attack);
        attack.scale(1200,40);
    }
    
    public void act()
    {
        if(rotate == 360)
        {
            getWorld().removeObject(this);
        }
        turn(1);
        rotate++;
        
    }
}
