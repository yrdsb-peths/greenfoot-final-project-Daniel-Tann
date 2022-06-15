import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world to show the user what the controls are.
 * 
 * @author (Daniel Tan)
 * @version (June 2022)
 */
public class Controls extends World
{
    SimpleTimer check = new SimpleTimer();
    Label guide = new Label("Controls", 80);
    Label wasd = new Label("Moving Horizontally: A,D", 35);
    Label dash = new Label("Dash: shift + A,D", 35);
    Label jump = new Label("Jump: W - Gravity Exists",35);
    Label shoot = new Label("Shoot: Aim and left click on target", 35);
    Label proceed = new Label("Press <>Space<>", 40);
    Label shield = new Label("Shield: E (Can Deflect MOST attacks)", 35);
    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        check.mark();
        addObject(guide, 300, 100);
        addObject(wasd,200,300);
        addObject(dash,140,340);
        addObject(jump,190,380);
        addObject(shoot,270,260);
        addObject(proceed, 300,150);
        addObject(shield,270,220);
    }
    public void act()
    {
        if(check.millisElapsed() > 500)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                MyWorld gameWorld = new MyWorld();
                Greenfoot.setWorld(gameWorld);            
            }
        }
    }
    
}
