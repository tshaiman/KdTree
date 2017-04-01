
public class Query {
	Rect2D rect;
	double rad;
	GeoLoc originCenter;
	
	public Query(GeoLoc point , double radius)
	{
		rad = radius;
		originCenter = point;
		rect = new Rect2D(point.X - radius,point.Y + radius,point.X + radius, point.Y - radius);
	}
	
	public boolean Contains(Rect2D range)
	{
		return rect.Contains(range);
	}
	
		
	public boolean IsCloseToCity(GeoLoc point)
	{
		double distance = GeoLoc.Distance(originCenter, point);
		return distance <= rad;
	}
}
