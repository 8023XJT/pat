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

    scanf("%d%d",&a,&b);//����a������
    sum=a+b;

    if(sum<0) printf("-");
    sum=abs(sum);

    while((sum/1000)!=0){//sum����1000ȡ���Ƿ����0
        temp=sum%1000;//������λ��ȡ����ע�����ǰ�漸λΪ0ʱ��int�ͻ�ʡȥ0������char����

        tag=tag+3;//����λ�������
        ch[tag]=',';//����λ�Ƕ���

        tag--;//֮���ǵ���λ
        ch[tag]='0'+temp/100;//temp����100��ȡ������Ϊ��λ
        temp=temp%100;//tempģ100����Ϊʮλ�͸�λ


        tag--;//�ڶ�λ
        ch[tag]='0'+temp/10;//ʮλ
        temp=temp%10;//ģ10����ֻʣ��λ

        tag--;//��һλ
        ch[tag]='0'+temp;//��λ

        tag=tag+4;//��tagָ�����λ��������յĵ�һλ

        sum=sum/1000;
    }

    printf("%d",sum);
    for(int i=tag-1;i>=0;i--){

        printf("%c",ch[i]);
    }

    return 0;
}
