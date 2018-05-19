/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seek;

import aiforgame.Kinematic;
import aiforgame.KinematicOutput;
import aiforgame.SteeringOutput;
import aiforgame.Vector;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Seek {
    private Kinematic character;
    private Kinematic target;
    private double  maxSpeed;

    public Seek() {
    }

    public Seek(Kinematic character, Kinematic target, double maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    //SET
    public void setCharacter(Kinematic character) {
        this.character = character;
    }

    public void setTarget(Kinematic target) {
        this.target = target;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //GET
    public Kinematic getCharacter() {
        return character;
    }

    public Kinematic getTarget() {
        return target;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
    
    //FEATURE
    public KinematicOutput getStreering() {
        KinematicOutput kinematicOutput = new KinematicOutput();
        Vector newVelocity = Vector.subtract(this.target.getPosition(), this.character.getPosition());
        newVelocity.nomalize();
        newVelocity.mulConst(maxSpeed);
        kinematicOutput.setVelocity(newVelocity);
        
        this.character.setOrientation(this.character.getNewOrientation(this.character.getOrientation(), newVelocity));
        this.character.setRotation(0);
        
        return kinematicOutput;
    }
   
    public static void main(String[] args) {
        Kinematic character = new Kinematic();
        character.setPosition(new Vector(0, 0));
        character.setOrientation(0);
        character.setRotation(0);
        character.setVelocity(new Vector(0, 0));
        
        Kinematic target = new Kinematic();
        target.setOrientation(0);
        target.setPosition(new Vector(30, 30));
        target.setVelocity(new Vector(1, 1));
        target.setRotation(0);
        
        Seek seek = new Seek(character, target, 5);
        KinematicOutput kinematicOutput = seek.getStreering();
        
        for (int i = 0; i < 5; ++i) {
            character.update(kinematicOutput, i);
            System.out.println(character.toString());
        }
    }
    
}
