package game.sonh;

public class KinematicOutput {

	private vector velocity;
	private double rotation;
	
	public KinematicOutput(){
		
	}
	public KinematicOutput(vector velocity, double rotation) {
		this.velocity = velocity;
		this.rotation = rotation;
	}



	public vector getVelocity() {
		return velocity;
	}
	public void setVelocity(vector velocity) {
		this.velocity = velocity;
	}
	public double getRotation() {
		return rotation;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	@Override
	public String toString() {
		return "KinematicOutput [velocity=" + velocity + ", rotation="
				+ rotation + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KinematicOutput other = (KinematicOutput) obj;
		if (Double.doubleToLongBits(rotation) != Double
				.doubleToLongBits(other.rotation))
			return false;
		if (velocity == null) {
			if (other.velocity != null)
				return false;
		} else if (!velocity.equals(other.velocity))
			return false;
		return true;
	}
	
	
	
}
