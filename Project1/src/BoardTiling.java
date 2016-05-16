import java.util.Scanner;

public class BoardTiling {
	
	static int original_size = 0;
	private int size;
	private int location_x;
	private int location_y;
	public BoardTiling(int size , int location_x , int location_y){
		this.size = size;
		this.location_x = location_x;
		this.location_y = location_y;
		original_size = size;
		double boxX = (location_x*(1.0/original_size) + (location_x-1)*(1.0/original_size))/2.0;
		double boxY = (location_y*(1.0/original_size) + (location_y-1)*(1.0/original_size))/2.0;
		
		int temp_size = original_size;
		StdDraw.filledSquare(boxX,boxY ,(1.0/original_size)/2.0);
		
		
		formation_L(temp_size, 0.5, 0.5, boxX, boxY);
	}

	public static void formation_L(double size, double cenX, double cenY, double boxX, double boxY) {
		int quadrant = getQuadrant(cenX, cenY, boxX, boxY);
		if(size == 1){
			return;
		}
		
		draw_L(quadrant, cenX, cenY);

		if(quadrant == 1){
			
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY - (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX + (1.0/original_size)/2.0 ,cenY - (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , boxX ,boxY );
		}
		if(quadrant == 2){
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX + (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY - (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , boxX ,boxY );
		}
		if(quadrant == 3){
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX + (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX + (1.0/original_size)/2.0 ,cenY - (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , boxX ,boxY );
		}
		if(quadrant == 4){
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX + (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY + (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY + (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX - (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , cenX - (1.0/original_size)/2.0 ,cenY - (1.0/original_size)/2.0 );
			formation_L(size/2 , cenX + (size/4.0)*(1.0/original_size) , cenY - (size/4.0)*(1.0/original_size) , boxX ,boxY );
		}

	}

	public static int getQuadrant(double cenX , double cenY , double x, double y) {
		int quadrant = 0;
		if (x > cenX && y > cenY) {
			
			quadrant = 1;
			
		} else if (x < cenX && y > cenY) {
			
			quadrant = 2;
			
		} else if (x < cenX && y < cenY) {
			
			quadrant = 3;
			
		} else if (x > cenX && y < cenY) {
			
			quadrant = 4;
			
		} 
		return quadrant;
	}

	public static void draw_L(int quadrant, double location_x, double location_y) {
		double temp = 1.0/original_size;
		if (quadrant == 1) {
			StdDraw.line(location_x, location_y, location_x, location_y + temp);
			StdDraw.line(location_x, location_y + temp, location_x - temp, location_y + temp);
			StdDraw.line(location_x - temp, location_y + temp, location_x - temp, location_y - temp);
			StdDraw.line(location_x - temp, location_y - temp, location_x + temp, location_y - temp);
			StdDraw.line(location_x + temp, location_y - temp, location_x + temp, location_y);
			StdDraw.line(location_x + temp, location_y, location_x, location_y);
		}
		if (quadrant == 2) {
			StdDraw.line(location_x, location_y, location_x, location_y + temp);
			StdDraw.line(location_x, location_y + temp, location_x + temp, location_y + temp);
			StdDraw.line(location_x + temp, location_y + temp, location_x + temp, location_y - temp);
			StdDraw.line(location_x + temp, location_y - temp, location_x - temp, location_y - temp);
			StdDraw.line(location_x - temp, location_y - temp, location_x - temp, location_y);
			StdDraw.line(location_x - temp, location_y, location_x, location_y);
		}
		if (quadrant == 3) {
			StdDraw.line(location_x, location_y, location_x, location_y - temp);
			StdDraw.line(location_x, location_y - temp, location_x + temp, location_y - temp);
			StdDraw.line(location_x + temp, location_y - temp, location_x + temp, location_y + temp);
			StdDraw.line(location_x + temp, location_y + temp, location_x - temp, location_y + temp);
			StdDraw.line(location_x - temp, location_y + temp, location_x - temp, location_y);
			StdDraw.line(location_x - temp, location_y, location_x, location_y);
		}
		if (quadrant == 4) {
			StdDraw.line(location_x, location_y, location_x, location_y - temp);
			StdDraw.line(location_x, location_y - temp, location_x - temp, location_y - temp);
			StdDraw.line(location_x - temp, location_y - temp, location_x - temp, location_y + temp);
			StdDraw.line(location_x - temp, location_y + temp, location_x + temp, location_y + temp);
			StdDraw.line(location_x + temp, location_y + temp, location_x + temp, location_y);
			StdDraw.line(location_x + temp, location_y, location_x, location_y);
		}
	}

}
