import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Game", 80);
    Label objective = new Label("Objective: Eliminate all targets and survive",30);
    Label proceed = new Label("Press <>Space<>", 40);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel,300,200);
        addObject(proceed, 300, 340);
        addObject(objective, 300, 270);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Controls controls = new Controls();
            Greenfoot.setWorld(controls);            
           
        }
    }
}
