
public class KDNode {
	
	public KDNode(float key, int axis){
		Key = key;
		Axis = axis;
		elem = null;
		Left = null;
		Right = null;
	}
	public KDNode(float key ,int axis,GeoLoc e) {
		
		Key = key;
		Axis = axis;
		elem = e;
		Left  = null;
		Right = null;
	}
	
	public GeoLoc elem;
	public float Key;
	public int Axis;
	public KDNode Left;
	public KDNode Right;
	
	public String toString(){
		if(elem != null)
			return elem.toString();
		return String.format("%f", Key);
	}

}
