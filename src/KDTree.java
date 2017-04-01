import java.util.Collections;
import java.util.List;

public class KDTree {
	public static final int K = 2;
	public static final int XSplit = 0;
	public static final int YSplit = 1;
	private KDNode root;
	
	
	public void Build(List<GeoLoc> points)
	{
		this.root = BuildKDTree(points, 0);
	}
	
	
	public void Insert(GeoLoc point)
	{
		//InsertToKDTree(root, point, 0);
	}
	
	
	
	//Recursion Insert list
	private KDNode BuildKDTree(List<GeoLoc> points,int depth){
		int n = points.size();
		if ( n == 0)
			return null;
		//choose the splitting axis
		int axis =  depth % K;
		//sort the points by splitting Axis
		Collections.sort(points,new GeoComperator(axis));
		
		KDNode node = null;
		float key ;
		//create new Node where the splitting point is in the middle
		if(points.size() == 1) 
		{
			GeoLoc point = points.get(0);
			node = new KDNode(point.Key(axis),axis,point);
		}
		else 
		{
			int medIndex = (n-1)/2;
			GeoLoc mediator = points.get(medIndex);
			key = mediator.Key(axis);
			node = new KDNode(key,axis);
			//KDNode node = new KDNode<GeoLoc>(points.get(n/2));
			node.Left = BuildKDTree(points.subList(0, medIndex+1), depth+1); // include the med index in the left side
			node.Right = BuildKDTree(points.subList(medIndex+1, n), depth+1);
		}
		return node;
	}
}
