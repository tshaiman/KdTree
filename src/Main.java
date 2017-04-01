import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<GeoLoc> arr = new ArrayList<GeoLoc>();
		Random r = new Random();
		
		for(int i = 0 ; i < 100000 ; ++i) {
			arr.add(new GeoLoc(r.nextFloat() * 100,r.nextFloat() * 100));
		}
		
		KDTree tree = new KDTree();
		tree.Build(arr);
		
		GeoLoc query = new GeoLoc(r.nextFloat() * 100, r.nextFloat()*100);
		//int radius = r.nextInt() % 6;
		double radius = 0.3;
		ArrayList<GeoLoc> results =  tree.RangeSearch(query,radius);
		PrintResults("Query : " + query + " . KD-Tree Results : ",results);
				 
		 ArrayList<GeoLoc> naiveResults = new ArrayList<GeoLoc>();
		//Test Against "Naive approach"
		for(GeoLoc loc : arr) {
			//calculate distance 
			double dist = GeoLoc.Distance(loc, query);
			if(dist <= radius)
				naiveResults.add(loc);
			
		}
		PrintResults("Query : " + query + " . Naive Results : ",naiveResults);
		
		
	}
	
	private static void PrintResults(String title , ArrayList<GeoLoc> results )
	{
		System.out.println(title);
		System.out.println("==========");
		 for(GeoLoc loc : results){
			 System.out.println(loc);
		 }
	}
	
	public static void main2(String[] args) {
		
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
		
		 ArrayList<GeoLoc> results = tree.RangeSearch(new GeoLoc(6,6), 4.0);
		 for(GeoLoc loc : results){
			 //System.out.println(loc);
		 }
	
		 
		 results = tree.RangeSearch(new GeoLoc(15,10), 7.0);
		 for(GeoLoc loc : results){
			 System.out.println(loc);
		 }
	
	}
	
	
	
}
