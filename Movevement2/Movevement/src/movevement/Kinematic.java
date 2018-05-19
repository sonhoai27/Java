/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movevement;

/**
 *
 * @author macos
 */


public class Kinematic {
    private Vector position;
    private double orientation;
    private Vector velocity;
    private double rotation;
    
    public Kinematic() {
        this.position = new Vector();
        this.orientation = 0.0;
        this.velocity = new Vector();
        this.rotation = 0.0;
    }
    
    public Kinematic(Vector position, double orientation, Vector velocity, double rotation) {
        this.position = position;
        this.orientation = orientation;
        this.velocity = velocity;
        this.rotation = rotation;
    }

    public Vector getPosition() {
        return position;
    }

    public double getOrientation() {
        return orientation;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public double getRotation() {
        return rotation;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
  
    public void update(KinematicOutput kinematicOutput, double time) {
        this.position.add(Vector.mulConst(this.velocity, time));
        this.orientation += this.rotation * time;
        
        this.velocity = kinematicOutput.getVelocity();
        this.rotation = kinematicOutput.getRotation();
    }
    
    public void update(SteeringOutput steeringOutput, double time) {
        Vector temp = Vector.mulConst(velocity, time);
        temp.add(Vector.mulConst(steeringOutput.getLinear(), time * time * 0.5));
        
        this.position.add(temp);
        this.orientation += this.rotation * time + 0.5 * steeringOutput.getAngular() * time * time;
        this.velocity.add(Vector.mulConst(steeringOutput.getLinear(), time));
        this.rotation += steeringOutput.getAngular() * time;
    }
    
    public static double getNewOrientation(double currentOrientation, Vector velocity) {
        if (velocity.length() > 0) {
            return Math.atan2(-velocity.getX(), velocity.getY());
        }
        
        return currentOrientation;
    }

    @Override
    public String toString() {
        return "Kinematic{" + "position=" + position + ", orientation=" + orientation + ", velocity=" + velocity + ", rotation=" + rotation + '}';
    }

   

    
    public static void main(String[] args) {
        Kinematic character = new Kinematic();
        KinematicOutput kinematicOutput = new KinematicOutput();
        
        character.setPosition(new Vector(0, 0));
        character.setOrientation(0);
        character.setRotation(0);
        character.setVelocity(new Vector(1, 1));
        
        kinematicOutput.setVelocity(new Vector(1, 1));
        kinematicOutput.setRotation(0);
        
        for (int i = 0; i < 5; ++i) {
            character.update(kinematicOutput, i);
            System.out.println(character.toString());
        }
    }
}
