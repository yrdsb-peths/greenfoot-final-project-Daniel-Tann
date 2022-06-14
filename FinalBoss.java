import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    SimpleTimer teleport = new SimpleTimer();
    SimpleTimer turn = new SimpleTimer();
    SimpleTimer attack = new SimpleTimer();
    SimpleTimer attack2 = new SimpleTimer();
    SimpleTimer star = new SimpleTimer();
    SimpleTimer hitCD = new SimpleTimer();
    int x = 0;
    int bossHp = 5;
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FinalBoss()
    {
        attack.mark();
        teleport.mark();
        star.mark();
        turn.mark();
        hitCD.mark();
    }
    public void act()
    {
        if(isTouching(banana.class))
        {
            MyWorld world = (MyWorld) getWorld();
            if(world.returnHitBoss() == true && hitCD.millisElapsed() > 1000)
            {
                world.bossHpDecrease();
                bossHp--;
                hitCD.mark();
                if(bossHp == 0)
                {
                    world.removeObject(this);
                    world.winScreen();
                }
            }
        }
        if(teleport.millisElapsed() > 2000)
        {
            setLocation(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(200));            
            teleport.mark();
        }
        if(turn.millisElapsed() > 4500)
        {
            turn(90);
            turn.mark();
        }
        if(attack.millisElapsed() > 5000)
        {           
            if(x % 2 == 1)
            {
                MyWorld world = (MyWorld) getWorld();
                for(int i = 0; i < 7; i++)
                {
                    world.attackTwo();
                }
            
            }
            if(x % 2 == 0)
            {
                MyWorld world = (MyWorld) getWorld();
                world.attackOne(getX(), getY());
            }
            x++;
            attack.mark();
            turn.mark();
        }
        if(star.millisElapsed() > 7000 && getNeighbours(600, true, star.class).size() < 1)
        {
            MyWorld world = (MyWorld) getWorld();        
            world.summonStar();
            star.mark();
        }
    }
}
