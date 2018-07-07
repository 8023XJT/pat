package Advance;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Pat1002 {
	float exp;//直接将Pat1002表示多项式的每一项，exp表示系数
	int num;//num表示指数
	private static Scanner in;
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int poly1Count;//多项式1的个数
        int poly2Count;

        int num;//指数
        float exp;//系数
        
        ArrayList<Pat1002> poly1=new ArrayList<Pat1002>();//第一个多项式
        ArrayList<Pat1002> poly2=new ArrayList<Pat1002>();//第二个

        in = new Scanner(System.in);
        poly1Count=in.nextInt();//记录多项式的项数

        for(int i=0;i<poly1Count;i++){//循环构造多项式的每一项，再将其加入到poly1中
        	num=in.nextInt();//读入两个数
        	exp=in.nextFloat();
        	
        	
        	Pat1002 temp=new Pat1002();
        	temp.num=num;
        	temp.exp=exp;
        	
        	poly1.add(temp);
        }
   
        
        poly2Count=in.nextInt();

        for(int i=0;i<poly2Count;i++){//构造poly2
        	num=in.nextInt();
        	exp=in.nextFloat();
        	//System.out.println(num+" "+exp);
        	
        	Pat1002 temp=new Pat1002();
        	temp.num=num;
        	temp.exp=exp;
        	
        	poly2.add(temp);
        }
 
        
        ArrayList <Pat1002>cons=new ArrayList<>();//poly1和poly2的sum多项式
        
        Pat1002 polyTemp1;//记录poly1栈顶项
        Pat1002 polyTemp2;
        
        while(!poly1.isEmpty()||!poly2.isEmpty()) {//当两栈都为空时结束
        	if(!poly1.isEmpty()&&!poly2.isEmpty()) {//两栈都不空
        		polyTemp1=poly1.get(poly1.size()-1);
        		polyTemp2=poly2.get(poly2.size()-1);
      		
        		if(polyTemp1.num==polyTemp2.num) {//如果两栈栈顶的项的指数相等则将其相加
        			Pat1002 newPoly=new Pat1002();
        			newPoly.num=polyTemp1.num;
        			newPoly.exp=polyTemp1.exp+polyTemp2.exp;
        			
        			poly1.remove(poly1.size()-1);
        			poly2.remove(poly2.size()-1);
        			
        			cons.add(newPoly);
        		}else if(polyTemp1.num>polyTemp2.num) {//不等的话，则将小的那个压栈
        			cons.add(polyTemp2);
        			poly2.remove(poly2.size()-1);
        			
        		}else if(polyTemp1.num<polyTemp2.num) {
        			cons.add(polyTemp1);
        			poly1.remove(poly1.size()-1);
        			
        		}
        	}else if(poly1.isEmpty()&&!poly2.isEmpty()) {//如果有一个多项式（栈）为空的话，则将另一个多项式完全加入到cons后面
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
        
        for(int i=cons.size()-1;i>=0;i--) {//去掉系数为1的项
        	if(cons.get(i).exp==0) cons.remove(i);
        }
        
        
        DecimalFormat df = new DecimalFormat("0.0");//转换格式，保留小数掉后一位
        double d ;
        
        
        
        System.out.print(cons.size());
        for(int i=cons.size()-1;i>=0;i--) {//将结果按格式输出
        	System.out.print(" ");
        	System.out.print(cons.get(i).num);
        	System.out.print(" ");
        	d=cons.get(i).exp;
        	System.out.print(df.format(d));
        }
	}
}
