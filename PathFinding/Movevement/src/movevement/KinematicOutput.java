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
public class KinematicOutput {

    private Vector velocity;
    private double rotation;

    public KinematicOutput() {
        this.velocity = new Vector();
        this.rotation = 0.0;
    }

    public KinematicOutput(Vector velocity, double rotation) {
        this.velocity = velocity;
        this.rotation = rotation;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public double getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "KinematicOutput{" + "velocity=" + velocity + ", rotation=" + rotation + '}';
    }

    
}
