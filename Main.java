package Advance;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	float exp;
	int num;
	private static Scanner in;
	

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int poly1Count;//多项式1的个数
        int poly2Count;

        int num;//指数
        float exp;//系数
        
        ArrayList<Main> poly1=new ArrayList<Main>();
        ArrayList<Main> poly2=new ArrayList<Main>();

        in = new Scanner(System.in);
        poly1Count=in.nextInt();

        for(int i=0;i<poly1Count;i++){
        	num=in.nextInt();
        	exp=in.nextFloat();
        	//System.out.println(num+" "+exp);
        	
        	Main temp=new Main();
        	temp.num=num;
        	temp.exp=exp;
        	
        	poly1.add(temp);
        }
      //  System.out.println("数组1结束");
        
        poly2Count=in.nextInt();

        for(int i=0;i<poly2Count;i++){
        	num=in.nextInt();
        	exp=in.nextFloat();
        	//System.out.println(num+" "+exp);
        	
        	Main temp=new Main();
        	temp.num=num;
        	temp.exp=exp;
        	
        	poly2.add(temp);
        }
  //      System.out.println("数组2结束");
        
//        System.out.print(poly1.size());
//        for(int i=0;i<poly1.size();i++) {
//        	//System.out.println("结果");
//        	System.out.print(" ");
//        	System.out.print(poly1.get(i).num);
//        	System.out.print(" ");
//        	System.out.print(poly1.get(i).exp);
//        }
//        System.out.println();
//        
//        System.out.print(poly2.size());
//        for(int i=0;i<poly2.size();i++) {
//        	//System.out.println("结果");
//        	System.out.print(" ");
//        	System.out.print(poly2.get(i).num);
//        	System.out.print(" ");
//        	System.out.print(poly2.get(i).exp);
//        }
//        System.out.println();
        
        int tag1=poly1.size();
        int tag2=poly2.size();
        ArrayList <Main>cons=new ArrayList<>();
        
        Main polyTemp1;
        Main polyTemp2;
        
        while(!poly1.isEmpty()||!poly2.isEmpty()) {
        	//System.out.println("xuhan");
        	if(!poly1.isEmpty()&&!poly2.isEmpty()) {
        		polyTemp1=poly1.get(poly1.size()-1);
        		//System.out.println(polyTemp1.num);
        		//poly1.remove(poly1.size()-1);
        		
        		
        		polyTemp2=poly2.get(poly2.size()-1);

        		//System.out.println(polyTemp2.num);
        		//poly2.remove(poly2.size()-1);
        		
        		if(polyTemp1.num==polyTemp2.num) {
        			Main newPoly=new Main();
        			newPoly.num=polyTemp1.num;
        			newPoly.exp=polyTemp1.exp+polyTemp2.exp;
        			
        			poly1.remove(poly1.size()-1);
        			poly2.remove(poly2.size()-1);
        			
        			cons.add(newPoly);
        		}else if(polyTemp1.num>polyTemp2.num) {
        			cons.add(polyTemp2);
        			poly2.remove(poly2.size()-1);
        			
        		}else if(polyTemp1.num<polyTemp2.num) {
        			cons.add(polyTemp1);
        			poly1.remove(poly1.size()-1);
        			
        		}
        	}else if(poly1.isEmpty()&&!poly2.isEmpty()) {
        		for(int i=poly2.size()-1;i>=0;i--) {
        			polyTemp2=poly2.get(i);
        			cons.add(polyTemp2);
        			poly2.remove(i);
        		}
        	}else if(poly2.isEmpty()&&poly2.isEmpty()) {
        		for(int i=poly1.size()-1;i>=0;i--) {
        			polyTemp1=poly1.get(i);
        			cons.add(polyTemp1);
        			poly1.remove(i);
        		}
        	}
        }
        
        
        DecimalFormat df = new DecimalFormat("0.0");
        double d ;
        System.out.print(cons.size());
        for(int i=cons.size()-1;i>=0;i--) {
        	//System.out.println("结果");
        	System.out.print(" ");
        	System.out.print(cons.get(i).num);
        	System.out.print(" ");
        	
        	d=cons.get(i).exp;
        	
        	System.out.print(df.format(d));
        }
	}
}
