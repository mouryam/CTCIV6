package practice.mPractice;
import java.util.*;



public class OverlapRectangles{
	static class Point {
		public int x, y;
		public Point(int x, int y) {
		this.x = x;
		this.y = y;
		}
	}
	static class Rectangle{
		public Point topleft, bottomRight;
		public Rectangle(Point top, Point bottom){
			this.topleft = top;
			this.bottomRight = bottom;
		}
	}

	public static void main(String[] args){
		Rectangle uno = new Rectangle(new Point(0, 10), new Point(10, 0));
		Rectangle dos = new Rectangle(new Point(5, 5), new Point(15, 0));
		System.out.println("Overlap? --- "+checkOverlap(uno, dos));
	}
	
	public static boolean checkOverlap(Rectangle uno, Rectangle dos){
		if(uno.topleft.x < dos.bottomRight.x || dos.topleft.x < uno.bottomRight.x){
			return true;
		}
		if(uno.bottomRight.y< dos.topleft.y || dos.bottomRight.y < uno.topleft.y){
			return true;
		}
		return false;
	}

}