import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {7,6,4,-1,1,2};
		List<List<Integer>> r=getFourNo(a, 16);
		r.forEach(i->{
			i.forEach(s->System.out.println(s));
		});
	}
	
	public static List<List<Integer>> getFourNo(Integer[] a,int sum){
		
		HashMap<Integer,List<List<Integer>>> map= new HashMap<>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		int s=0;
		int rem=0;
		
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				s=a[i]+a[j];
				rem=sum-s;
				if(map.containsKey(rem)) {
					List<Integer> list1=new ArrayList<Integer>();
					for(List<Integer> m : map.get(rem)) {
						list1.addAll(m);
						list1.add(a[i]);
						list1.add(a[j]);
						list.add(list1);
					}
					
				}
			}
			for(int j=i-1;j>=0;j--) {
				s=a[i]+a[j];
				List<Integer> l= new ArrayList<Integer>(Arrays.asList(a[i],a[j]));
				if(map.get(s)==null) {
					map.put(s, new ArrayList(l));
				}else {
					map.get(s).add(l);
				}
			}
		}
		
		
		
		return  list;
	}
	
	

}
