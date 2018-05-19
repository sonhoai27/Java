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
public class SteeringOutput {
    private Vector linear;
    private double angular;

    public SteeringOutput(Vector linear, double angular) {
        this.linear = linear;
        this.angular = angular;
    }

    public SteeringOutput() {
        this.linear = linear;
        this.angular = angular;
    }

    public Vector getLinear() {
        return linear;
    }

    public void setLinear(Vector linear) {
        this.linear = linear;
    }

    public double getAngular() {
        return angular;
    }

    public void setAngular(double angular) {
        this.angular = angular;
    }

}
