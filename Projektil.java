import greenfoot.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projektil here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Projektil extends OpenVariable {

    Actor ratte;
    Actor schlange;

    /**
     * Act - do whatever the Projektil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /*
         * Projektil bewegt sich
         */
        //move(4);
        setLocation(getX(), getY() + 4);
        

        löschenR();
        
    }

    /**
     * entfernt die Eichel bei berührung mit der Ratte
     */
    private void löschenR()
    { //TODO INTERSECTING WITH ENEMY!
        ratte = getOneIntersectingObject(Ratte.class);
        schlange = getOneIntersectingObject(Schlange.class);
        
        if (ratte != null || (schlange != null)){
            if (ratte!= null)
            {  
                ((Ratte)getOneIntersectingObject(Ratte.class)).verletzten();
                getWorld().removeObject(this);
            }else{

                if (schlange!= null)
                {  
                    ((Schlange)getOneIntersectingObject(Schlange.class)).verletzten();
                    getWorld().removeObject(this);
                }
            }
        }
        
        if(getWorld() != null && getY() > getWorld().getHeight() - 4 ){
            getWorld().removeObject(this);
        }
    }
}
