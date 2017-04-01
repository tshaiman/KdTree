
public class Rect2D {
	public GeoLoc lt; //left top
	public GeoLoc rb; //right bottom
	
	Rect2D(GeoLoc leftTop,GeoLoc rightBottom){
		lt = leftTop;
		rb = rightBottom;
	}
	Rect2D(double lx,double ly, double rx,double ry){
		lt = new GeoLoc(lx,ly);
		rb = new GeoLoc(rx,ry);
	}
	Rect2D(GeoLoc leftTop,float w,float h){
		lt = leftTop;
		rb = new GeoLoc(lt.X + w, lt.Y - h);
	}
	
	public boolean Intersects(Rect2D rect)
	{
		if (rb.X < rect.lt.X || rect.rb.X < lt.X ||  lt.Y < rect.rb.Y || rect.lt.Y < rb.Y)
			return false;
		return true;
	}
	
	public boolean Contains(Rect2D rect)
	{
		return (rect.lt.X >= lt.X && rect.rb.X <= rect.rb.X && rect.lt.Y <= lt.Y &&  rect.rb.Y > rb.Y);
	}
		
}
