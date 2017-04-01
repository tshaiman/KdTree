import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<GeoLoc> arr = new ArrayList<GeoLoc>();
		
		arr.add(new GeoLoc(11,10));
		arr.add(new GeoLoc(4,7));
		arr.add(new GeoLoc(15,3));
		arr.add(new GeoLoc(16,10));
		arr.add(new GeoLoc(7,13));
		arr.add(new GeoLoc(14,11));
		arr.add(new GeoLoc(9,4));
			
		KDTree tree = new KDTree();
		tree.Build(arr);
		
		
	
	}
	
}
