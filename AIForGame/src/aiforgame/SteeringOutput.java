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
public class SteeringOutput {
    private Vector linear;
    private double angular;

    public SteeringOutput() {
    }

    public SteeringOutput(Vector linear, double angular) {
        this.linear = linear;
        this.angular = angular;
    }

    public Vector getLinear() {
        return linear;
    }

    public double getAngular() {
        return angular;
    }

    public void setLinear(Vector linear) {
        this.linear = linear;
    }

    public void setAngular(double angular) {
        this.angular = angular;
    }
    
}
