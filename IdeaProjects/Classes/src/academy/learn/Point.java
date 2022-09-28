package academy.learn;

public class Point {
    private  int x;
    private  int y;

    public Point(){

    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public double distance(){
        double xA,yB;
        double xB=0,yA=0;
        xA=this.x;
        yB=this.y;

        return Math.sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
    }
    public double distance(int x,int y){
        int xA,yB;
        int xB=0,yA=0;
        xA=x;
        yB=y;
        return Math.sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
    }
     public double distance(Point point){
        double xA,yB;
        double xB=0,yA=0;
        xA=this.x;
        yB=this.y;
        //double answer=(double) point;

        return Math.sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
    }
}
