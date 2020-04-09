package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-08 18:00
 */
public class Huawei3 {
    private int[][] map = new int[9][9];
    private boolean[][] mark = new boolean[9][9];
    private int top;
    private int index;
    private List<Cell> cellList;
    private boolean done;
    public void init() {
        cellList = new ArrayList<Cell>();
        top = 0;
        index = 0;
        done = false;
        try (Scanner scanner = new Scanner(System.in)){
            for (int i = 0; i <map.length; i++) {
                String nextLine = scanner.nextLine();
                for (int j = 0; j <map.length; j++) {
                    map[i][j]=nextLine.charAt(2*j+1)-'0';
                    if (map[i][j]>0){
                        top++;
                        mark[i][j]=true;
                    }else{
                        mark[i][j]=false;
                        cellList.add(new Cell(i,j));
                    }
                }
            }
        }
    }

    public void cal() {
        if(top>=81){
            done=true;
            show();
            return;
        }
        Cell cell = cellList.get(index);
        top++;
        index++;
        for (int i = 1; i <=9&&!done; i++) {
            if (legal(cell,i)){
                mark[cell.x][cell.y]=true;
                map[cell.x][cell.y]=i;
                cal();
                mark[cell.x][cell.y]=false;
            }
        }
        index--;
        top--;
    }
    private boolean legal(Cell cell,int v){
        return legalX(cell,v)&&legalY(cell,v)&&legalSquare(cell,v);

    }

    private boolean legalX(Cell cell,int v){
        for (int y = 0; y <map.length; y++) {
            if (mark[cell.x][y]==true&&map[cell.x][y]==v){
                return false;
            }
        }
        return true;
    }

    private boolean legalY(Cell cell,int v){
        for (int x = 0; x <map.length; x++) {
            if (mark[x][cell.y]==true&&map[x][cell.y]==v){
                return false;
            }
        }
        return true;
    }

    private boolean legalSquare(Cell cell,int v){
        int x = cell.x/3*3;
        int y = cell.y/3*3;
        for (int i = x; i <x+3; i++) {
            for (int j = y; j <y+3; j++) {
                if(mark[i][j]==true&&map[i][j]==v){
                    return false;
                }
            }
        }
        return true;
    }

    public void show() {
        for (int i = 0; i <map.length; i++) {
            System.out.print("{");
            for (int j = 0; j <map[i].length-1; j++) {
                System.out.print(map[i][j]+",");
            }
            System.out.print(map[i][map.length-1]+"}");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Huawei3 huawei3 = new Huawei3();
        huawei3.init();
        huawei3.cal();
    }

}

class Cell{
    int x;
    int y;
    int v;

    public Cell(int x,int y){
        this(x,y,0);
    }

    public Cell(int x, int y, int v) {
        super();
        this.x = x;
        this.y = y;
    }
}
