import java.util.Comparator;

public class GeoComperator implements Comparator<GeoLoc>
{
	private int axis; // 0 = > By X , 1 => By Y
	
	
	public GeoComperator(int splitAxis){
		axis = splitAxis;
	}
	@Override
	public int compare(GeoLoc g1, GeoLoc g2) {
		double diff=  g1.X - g2.X;
		if (axis == KDTree.YSplit)
			diff = g1.Y - g2.Y;
		
		return diff < 0 ? -1 : diff > 0 ? 1 : 0;
	}
	
}
