import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class secondLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class secondLevel extends World
{

    /**
     * Constructor for objects of class secondLevel.
     * 
     */
    public secondLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Person p = new Person();
        addObject(p, 50, 380);
    }
}
