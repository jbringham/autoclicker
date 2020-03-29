package reference;
import java.awt.Point;

/**
 * 
 * @author jakeb
 *
 */
public class Instruction {
	private String type;
	private Point point;
	private int time;
	
	/**
	 * Creates an instruct with a type (forced to caps), 
	 * possible point and time amount. 
	 * Here are the forms of the extra args:
	 * 1. (Time)
	 * 2. (x, y)
	 * 3. (Time, x, y)
	 * @param type Type of instruction (could be made into enum)
	 * @param args Variadic argument array of strings
	 */
	public Instruction(String type, String[] args) {
		this.type = type.toUpperCase(); //could make it an enum but fuck it
		
		int[] nums = new int[args.length];
		
		for(int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		
		switch(args.length) {
		case 1:
			this.time = nums[0];
			break;
		case 2:
			this.point = new Point(nums[0], nums[1]);
			break;
		case 3:
			this.time = nums[0];
			this.point = new Point(nums[1], nums[2]);
			break;
		}
	}
	
	/**
	 * Gets the type of the instruction
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the point of the instruction.
	 * @return
	 */
	public Point getPoint() {
		return point;
	}
	
	/**
	 * Gets the x value of the point.
	 * @return x value of the point
	 */
	public int getXPoint() {
		return (int)point.getX();
	}
	
	/**
	 * Gets the y value of the point.
	 * @return y value of the point
	 */
	public int getYPoint() {
		return (int)point.getY();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * 
	 */
	public String toString() {
		if(point != null) {
			return String.format("%s, (%f, %f), %s", type, point.getX(), point.getY(), time);
		} else {
			return String.format("%s, %s", type, time);
		}
	}
}
