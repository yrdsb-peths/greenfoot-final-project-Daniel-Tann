import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main actor class for the wizard enemy.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class enemy extends Actor
{
    GreenfootImage wizard = new GreenfootImage("images/wizard.png");
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer cast = new SimpleTimer();
    SimpleTimer teleport = new SimpleTimer();
    SimpleTimer damageCoolDown = new SimpleTimer();
    int wizardHp = 4;
    int x = 2000;
    public enemy()
    {
        setImage(wizard);
        cast.mark();
        teleport.mark();
        wizard.scale(100,100);
    }
    public void act()
    {
        if(teleport.millisElapsed() > 1000)
        {
            setLocation(Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(200));
            teleport.mark();
        }
        if(cast.millisElapsed() > x)
        {
            MyWorld world = (MyWorld) getWorld();
            world.spawnEnergyBall(getX(), getY());
            for(int i = 0; i < 5; i++)
            {
                world.spawnEnergyBall(getX(), getY());
            }
            cast.mark();
        }
        if(isTouching(banana.class) && damageCoolDown.millisElapsed() > 500)
        {
            removeTouching(banana.class);
            wizardHp--;
            MyWorld world = (MyWorld) getWorld();
            world.wizardHpDecrease();
            x-=100;
            if(wizardHp <= 0)
            {
                world.removeObject(this);
            }
            damageCoolDown.mark();
        }
        // Add your action code here.
    }
    
    
}
