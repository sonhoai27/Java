package game.sonh;

public class Kinematic {
	//dai diện cho chuyển động
	
	//seek dí theo
	//postion lá vector để chuyển sang vận tốc oa - ob = oa +bo = ba = vector v.toc
	
	
	//phương thức khởi tạo là public vì: đứng nào đó bất kỳ cũng có quyền tạo mới kinematic
	//doi tuong không the tính toán, mà các phuong thức chỉ mới tính toán dc.
	
	//phuong thuc thuoc đối tượng thì có thể thay đổi nhưng phương thức thuộc lớp không thay đổi.
	
//	x = x0 +at*t/2
//			v = v0 + a*t
	
	private vector position;
	private double oritation;
	private vector velocity;
	private double rotation;
	
	public Kinematic(){
		
	}
	
	public Kinematic(vector position, double oritation, vector velocity,
			double rotation) {
		super();
		this.position = position;
		this.oritation = oritation;
		this.velocity = velocity;
		this.rotation = rotation;
	}
	
	
	public double getRotation() {
		return rotation;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	public vector getVelocity() {
		return velocity;
	}
	public void setVelocity(vector velocity) {
		this.velocity = velocity;
	}
	public double getOritation() {
		return oritation;
	}
	public void setOritation(double oritation) {
		this.oritation = oritation;
	}
	public vector getPosition() {
		return position;
	}
	public void setPosition(vector position) {
		this.position = position;
	}
	
	
	public void update(KinematicOutput kinematicOutput, double time){
		position.add(vector.mulConst(velocity, time));
		oritation += rotation*time;
		
		velocity = kinematicOutput.getVelocity();
		
		rotation = kinematicOutput.getRotation();
	}
	
	public void update(SteeringOutput steeringOutput, double time){
		position.add(vector.mulConst(velocity, time))
		.add(vector.mulConst(steeringOutput.getLinear(), 0.5*time));
		
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(oritation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		temp = Double.doubleToLongBits(rotation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((velocity == null) ? 0 : velocity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kinematic other = (Kinematic) obj;
		if (Double.doubleToLongBits(oritation) != Double
				.doubleToLongBits(other.oritation))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
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

	@Override
	public String toString() {
		return "Kinematic [position=" + position + ", oritation=" + oritation
				+ ", velocity=" + velocity + ", rotation=" + rotation + "]";
	}
	
	
}
