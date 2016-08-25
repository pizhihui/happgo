public class Test {
    int x, y;
    Test(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static void main(String[] args) {
        Test pt1, pt2;
        pt1 = new Test(3, 3);
        pt2 = new Test(4, 4);
        System.out.print(pt1.x + pt2.x);
        for(int  i=1;i<=10;i++)
        {
        	if (i<5)
        		continue;
        	System.out.println("大数据实战班");
        }
        System.out.println(""+'a'+1);
    }
}

