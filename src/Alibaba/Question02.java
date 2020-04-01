package Alibaba;


/**
 * 编程题No.2
 * @hurusea
 * @create2020-04-01 15:31
 */
public class Question02 {
    private int[] a;
    private int[] b;
    private int[] c;
    private int m, n;

    public Question02(int[] a, int[] b, int[] c, int m, int n) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.m = m;
        this.n = n;
    }

    public int getminspend() {
        int minspend[][]=new int[m][n];
        for (int i = 0; i <m; i++) {
            minspend[i][0]=0;
        }
        for (int i = 0; i <m; i++) {
            if (i>c[0]){
                minspend[0][i]=0;
            }else{
                minspend[0][i]=b[0];
            }
        }
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <m; j++) {
                if (j<c[i]){
                    minspend[i+1][j]=minspend[i][j];

                }else{
                    minspend[i+1][j]=min(minspend[i][j],minspend[i+1][j]);
                }
            }

        }
        for (int i = 0; i <b.length ; i++) {
            for (int j = 0; j <m; j++) {
                System.out.println(minspend[i][j]+",");
            }
            System.out.println();
        }
        return minspend[b.length-1][m];
    }

    public int min(int a,int b){
        if(a<b){
            return a;
        }else{
            return b;
        }
    }

    public static void main(String[] args) {
        int m =3;
        int n =3;
        int a[]={1,2,3};
        int b[]={2,3,4};
        int c[]={1,2,3};
        Question02 question02 = new Question02(a, b, c, m, n);
        question02.getminspend();
    }
}
