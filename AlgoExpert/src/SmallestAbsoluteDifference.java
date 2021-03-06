import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SmallestAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a= {-1,5,10,20,28,3};
		int[] b= {26,134,135,15,17};
		Integer[] diff=smallDifference(a, b);
		System.out.println(diff[0]);
		System.out.println(diff[1]);
System.out.println("==============");
		Integer[] diff1=smallDiff(a, b);
		System.out.println(diff1[0]);
		System.out.println(diff1[1]);
	}
	
	public static Integer[] smallDifference(int[] a,int[] b) {
		Map<Integer,Integer[]> map= new LinkedHashMap<>();
		Map<Integer,Integer[]> map1= new LinkedHashMap<>();
		Date d= Calendar.getInstance().getTime();
		long start=System.currentTimeMillis();
		System.out.println(start);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				map.put(Math.abs(a[i]-b[j]), new Integer[] {a[i],b[j]});
//				System.out.println("--");
			}
		}
		int s = map.keySet().stream().sorted().findFirst().get();
		Date e= Calendar.getInstance().getTime();
		long end=System.currentTimeMillis();
		long dd=end-start;
		System.out.println(end);
		System.out.println("time tkaen =  "+(dd));
		return map.get(s);
//		System.out.println(map1);
//		return map1.entrySet().stream().findFirst().get().getValue();
	}
	
	public static Integer[] smallDiff(int[] a,int[] b) {
		long start=System.currentTimeMillis();
		System.out.println(start);
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0,j=0,diff=Integer.MAX_VALUE;
		int num1=a[0],num2=b[0];
		while(i<a.length&&j<b.length) {
			int d=Math.abs(a[i]-b[j]);
			if(d==0) {
				return new Integer[] {a[i],b[j]};
			}
			if(d<diff) {
				diff=d;
				num1=a[i];
				num2=b[j];
			}
			if(a[i]<b[j]) {
				i++;
			}else {
				j++;
			}System.out.println("--");
		}
		long end=System.currentTimeMillis();
		
		System.out.println(end);
		long dd=end-start;
		System.out.println("time tkaen =  "+(dd));
		return new Integer[] {num1,num2};
	}
	

}
