package game.sonh;

public class SteeringOutput {
	private vector linear;
	private double angular;
	
	public SteeringOutput(){
		
	}
	public SteeringOutput(vector linear, double angular) {
		
		this.linear = linear;
		this.angular = angular;
	}
	
	
	public double getAngular() {
		return angular;
	}
	public void setAngular(double angular) {
		this.angular = angular;
	}
	public vector getLinear() {
		return linear;
	}
	public void setLinear(vector linear) {
		this.linear = linear;
	}
}
