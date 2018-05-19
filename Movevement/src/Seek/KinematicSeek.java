/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//thuat toán di chuyển, la đi giữa 2 điểm.
//điều khiển nhân vật zi1 muc tiêu và cho ra một kinematicoutput
package Seek;

import movevement.Kinematic;
import movevement.KinematicOutput;
import movevement.Vector;

/**
 *
 * @author macos
 */
public class KinematicSeek {
//đuổi là chuyển động điều, nên chỉ dùng vận tốc
    private Kinematic character;//nhan vat
    private Kinematic target;//muc tieu dí theo
    private double maxSpeed; //van toc toi da

    public KinematicSeek() {
        this.character = new Kinematic();
        this.target = new Kinematic();
        this.maxSpeed = 0.0;
    }

    public KinematicSeek(Kinematic character, Kinematic target, double maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }
//lay p trừ nhau ra v, trả về vi trí
    public KinematicOutput getSteering() {
        KinematicOutput kinematicOutput = new KinematicOutput();
//tru là là phép cộng nhân thêm hang = -1 vào thì ra trừ
        kinematicOutput.setVelocity(Vector.add(target.getPosition(), Vector.mulConst(character.getPosition(), -1)));
        kinematicOutput.getVelocity().normalize();
        kinematicOutput.getVelocity().mulConst(this.maxSpeed);
        
        this.character.setOrientation(Kinematic.getNewOrientation(this.character.getOrientation(), this.character.getVelocity()));
        this.character.setRotation(0);
        
        return kinematicOutput;
    }

    public Kinematic getCharacter() {
        return character;
    }

    public Kinematic getTarget() {
        return target;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setCharacter(Kinematic character) {
        this.character = character;
    }

    public void setTarget(Kinematic target) {
        this.target = target;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public static void main(String[] args) {
        Kinematic character = new Kinematic();
        character.setPosition(new Vector(0,0));
        character.setVelocity(new Vector(0,0));
        character.setRotation(0);
        character.setOrientation(0);
        
        Kinematic target = new Kinematic();
        target.setPosition(new Vector(15,15));
        target.setVelocity(new Vector(0,0));
        target.setRotation(0);
        target.setOrientation(0);
        
        KinematicSeek kinematicSeek = new KinematicSeek(character, target, 2);
        KinematicOutput kinematicoutout = kinematicSeek.getSteering();
        
        for (int i = 0; i < 5; ++i) {
            character.update(kinematicoutout, i);
            System.out.println(character);
        }

    }
    

}
