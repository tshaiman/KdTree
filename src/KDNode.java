
public class KDNode {
	
	public KDNode(double key, int axis){
		Key = key;
		Axis = axis;
		elem = null;
		Left = null;
		Right = null;
	}
	public KDNode(double key ,int axis,GeoLoc e) {
		
		Key = key;
		Axis = axis;
		elem = e;
		Left  = null;
		Right = null;
	}
	
	public boolean IsLeaf(){
		return elem != null;
	}
	
	public GeoLoc elem;
	public double Key;
	public int Axis;
	public KDNode Left;
	public KDNode Right;
	
	public String toString(){
		if(elem != null)
			return elem.toString();
		return String.format("%f", Key);
	}

}
