/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiforgame;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Kinematic {

    private Vector position;
    private double orientation;
    private Vector velocity;
    private double rotation;

    public Kinematic() {
    }

    public Kinematic(Vector position, double orientation, Vector velocity, double rotation) {
        this.position = position;
        this.orientation = orientation;
        this.velocity = velocity;
        this.rotation = rotation;
    }

    //GET
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

    //SET
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

    public void update(KinematicOutput kinematic, double time) {
        this.position.add(Vector.mulConst(velocity, time));
        this.orientation += this.orientation * time;

        this.velocity = kinematic.getVelocity();
        this.rotation = kinematic.getRotation();
    }

    public void update(SteeringOutput steering, double time) {
        this.position.add(Vector.add(Vector.mulConst(velocity, time), Vector.mulConst(steering.getLinear(), time * time * 0.5)));
        this.orientation += this.rotation * time + 0.5 * steering.getAngular() * time * time;
        this.velocity.add(Vector.mulConst(steering.getLinear(), time));
        this.rotation += steering.getAngular() * time;
    }
    
    public double getNewOrientation(double orientation, Vector velocity) {
        if (this.velocity.lenght() > 0) {
            return Math.atan2(velocity.getX(), velocity.getY());
        }
        
        return orientation;
    }

    @Override
    public String toString() {
        return "AIForGame{" + "position=" + position + ", orientation=" + orientation + ", velocity=" + velocity + ", rotation=" + rotation + '}';
    }

    public static void main(String[] args) {
//       Vector position = new Vector(0, 0);
//       Vector velocity = new Vector(1, 1);
//       Kinematic kimematic = new Kinematic(position, 0, velocity, 0);
//       
//       KinematicOutput kinematicOutput = new KinematicOutput(new Vector(2, 2), 0);
//       
//       for (int i = 0; i < 5; ++i) {
//           kimematic.update(kinematicOutput, i);
//           System.out.println(kimematic.toString());
//       }

        Vector position = new Vector(0, 0);
        Vector velocity = new Vector(1, 1);
        Kinematic kimematic = new Kinematic(position, 0, velocity, 0);

        SteeringOutput steeringOutput = new SteeringOutput(new Vector(2, 2), 1);

        for (int i = 0; i < 5; ++i) {
            kimematic.update(steeringOutput, i);
            System.out.println(kimematic.toString());
        }
    }

}
