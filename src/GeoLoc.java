
public class GeoLoc {
	public float X ;
	public float Y;
	
	public GeoLoc(float x , float y  ){
		X = x;
		Y = y;
	}
	
	public int Compare(GeoLoc other,int axis){
		float diff=  X - other.X;
		if (axis == KDTree.YSplit)
			diff = Y - other.Y;
		
		return diff > 0 ? 1 : diff < 0 ? -1 : 0;
	}
	
	public String toString(){
		return String.format("{X = %f, Y = %f }",	X ,Y);
	
	}
	
	public float Key(int axis) {
		return axis == KDTree.XSplit ? X : Y;
	}
	
	public static double Distance(GeoLoc l1 ,GeoLoc l2){
		double dx = l1.X - l2.X;
		double dy = l1.Y - l2.Y;
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	
	
	
	
}

