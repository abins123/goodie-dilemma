import java.util.*;
import java.io.*;
public class assignment {
			//static int pos=-1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);//cd creating scanner object
		String path1="C:\\Users\\lenovo\\Desktop\\HP\\input.txt";//path of input file
		String path2="C:\\Users\\lenovo\\Desktop\\HP\\output.txt";//path of output file

		 FileReader file=new FileReader(path1);//filereader object
		 BufferedReader bf=new BufferedReader(file);//buffer reader object
		 FileWriter output=new FileWriter(path2,true);//filewriter object
		 BufferedWriter bw=new BufferedWriter(output);//buffer reader object
		
		int price[]=new int [10];//price array
		String goodies[]=new String[10];//goodies array
		String st=bf.readLine();
		
		for(int i=0;i<10;i++)
		{  
			if((st=bf.readLine())!=null){
			StringTokenizer stn=new StringTokenizer(st,":");
			String s1=stn.nextToken();
			//System.out.println(s1);
			int p1=Integer.parseInt(stn.nextToken());
			//System.out.println(p1);
			goodies[i]=s1;
			price[i]=p1;
			}
			
		}
		
		arrange(price,goodies);
		
		System.out.println("Enter number of Employees");
		int n=sc.nextInt();
		
		int val=find(price,n);
		bw.write("Enter number of Employees "+Integer.toString(n));
		bw.newLine();
		bw.write("Here the goodies that are selected for distribution are :");
		bw.newLine();
		for(int j=val;j<val+n;j++)
		{
			
			
			bw.write(goodies[j]+":");
			String str1=Integer.toString(price[j]);
			bw.write(str1);
			bw.newLine();
			
		}
		int d=price[val+n-1]-price[val];
		bw.write("And the diffrent between the chosen goodie with highest price and the lowest price is "+Integer.toString(d));
		bw.close();
	
		
	}

	private static int find(int[] price,int n) {
		// TODO Auto-generated method stub
		
		int b=Integer.MAX_VALUE;
		int pos=-1;
		for(int i=0;i<price.length-n+1;i++)
		{
			int n1=price[i+n-1]-price[i];
			if(b>n1)
			{
				pos=i;
				b=n1;
			}
		}
		return pos;
	}

	private static void arrange(int[] price, String[] goodies) {
		// TODO Auto-generated method stub
		int n=price.length;
		for(int i=0;i<n-1;i++)
		{
			int min_idx=i;
			for(int j=i+1;j<n;j++)
			  if(price[j]<price[min_idx])
				  min_idx=j;
			
			
			int temp=price[min_idx];
			price[min_idx]=price[i];
			price[i]=temp;
			
			String temp1=goodies[min_idx];
			goodies[min_idx]=goodies[i];
			goodies[i]=temp1;
			
		}
	}
	

}