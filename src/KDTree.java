import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KDTree {
	public static final int K = 2;
	public static final int XSplit = 0;
	public static final int YSplit = 1;
	public static final double delta = 0.000001;
	private KDNode root;
	
	
	public void Build(List<GeoLoc> points)
	{
		this.root = BuildKDTree(points, 0);
	}
	
	
	public void Insert(GeoLoc point)
	{
		//InsertToKDTree(root, point, 0);
	}
	
	public ArrayList<GeoLoc> RangeSearch(GeoLoc point,double radius)
	{
		Query q = new Query(point,radius);
		ArrayList<GeoLoc> results = new ArrayList<GeoLoc>();
		//build the range for the entire map
		Rect2D range = new Rect2D(0, 1000, 1000, 0);
		RangeSearch(root,q,range,results);
		return results;
	}
	
	
	
	private void RangeSearch(KDNode tree, Query q,Rect2D range, ArrayList<GeoLoc> results) 
	{
		//Leaf Node = > we must check it 
		if(tree.elem != null)
		{
			if(q.IsCloseToCity(tree.elem))
				results.add(tree.elem);
			return;
		}
		
		//1. case 1 : the range is entirely inside the query , add all points of the tree
		if(q.Contains(range))
		{
			GetAllNodes(tree, results);
			return;
		}
		
		//Create 2 Rectangles for each side and see if there is an intersection
		Rect2D lower = null,higher = null;
		if(tree.Axis == 0) //left / right
		{
			lower = new Rect2D(range.lt,new GeoLoc(tree.Key, range.rb.Y));
			higher = new Rect2D(new GeoLoc(tree.Key+delta,range.lt.Y),range.rb);
		}
		else //bottom / up
		{
			lower = new Rect2D(new GeoLoc(range.lt.X,tree.Key),range.rb);
			higher = new Rect2D(range.lt,new GeoLoc(range.rb.X,tree.Key+delta));
		}
		
		//for each new range , if it intersect , go that direction
		if(lower.Intersects(q.rect))
		{
			RangeSearch(tree.Left,q,lower,results);
		}
		if(higher.Intersects(q.rect))
		{
			RangeSearch(tree.Right,q,higher,results);
		}
	}
	
		
	private void GetAllNodes(KDNode tree,ArrayList<GeoLoc> results)
	{
		if(tree == null)
			return;
		if(tree.IsLeaf())
			results.add(tree.elem);
		else
		{
			GetAllNodes(tree.Left,results);
			GetAllNodes(tree.Right,results);
		}
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
		double key ;
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
