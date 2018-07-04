#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(){
    int a;
    int b;
    int sum;
    int tag=0;

    int temp;
    char ch[20];

    scanf("%d%d",&a,&b);//输入a，两数
    sum=a+b;

    if(sum<0) printf("-");
    sum=abs(sum);

    while((sum/1000)!=0){//sum除以1000取整是否大于0
        temp=sum%1000;//将此三位数取出，注意如果前面几位为0时，int型会省去0，故用char数组

        tag=tag+3;//将各位倒序输出
        ch[tag]=',';//第四位是逗号

        tag--;//之后是第三位
        ch[tag]='0'+temp/100;//temp除以100后取整，则为百位
        temp=temp%100;//temp模100余数为十位和个位


        tag--;//第二位
        ch[tag]='0'+temp/10;//十位
        temp=temp%10;//模10，则只剩个位

        tag--;//第一位
        ch[tag]='0'+temp;//个位

        tag=tag+4;//将tag指向第四位，即数组空的第一位

        sum=sum/1000;
    }

    printf("%d",sum);
    for(int i=tag-1;i>=0;i--){

        printf("%c",ch[i]);
    }

    return 0;
}
