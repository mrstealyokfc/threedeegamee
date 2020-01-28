package mer;

import java.util.HashMap;
import java.util.Map;

public class Paddle {
	boolean isHumanControled;
	float xPos=0.95f,yPos=0.9f,yAcc=0f,yVel=-0.01f;
	
	public Paddle(float xPos){
		this.xPos=xPos;
	}
	public void setControl(String control) {
		if(control.equals("human")) {
			isHumanControled=true;
		}
		if(control.equals("computer")) {
			isHumanControled=false;
		}
	}
	
	public void move() {
		if(yPos>1||yPos<-0.6) {
			yVel*=-0.96f;
		}
		if(yPos>1) {
			yPos=1f;
		}
		if(yPos<-0.6) {
			yPos=-0.6f;
		}
		yVel+=yAcc;
		yPos+=yVel;
		if(!isHumanControled) {
			AIMove();
		}
		
	}
	public void AIMove() {
		
	}
	public void input(float dir) {
		if(isHumanControled) {
			yAcc=dir;
		}
	}
	
	public float[] getPaddleArray(){
		float[] paddle=new float[12];
		//1
		paddle[0]=xPos;
		paddle[1]=yPos;
		paddle[2]=yPos;
		
		paddle[3]=xPos-0.05f;
		paddle[4]=yPos;
		paddle[5]=yPos;
		
		paddle[6]=xPos-0.05f;
		paddle[7]=yPos-0.4f;
		paddle[8]=yPos;
		
		paddle[9]=xPos;
		paddle[10]=yPos-0.4f;
		paddle[11]=yPos;
		return paddle;
	}
	public int[] getPaddleIndex(){
		int[] connections= {
			0,1,2,0,2,3	
		};
		return connections;
	}
}
