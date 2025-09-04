package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Cannon extends Circle{
	final static public double RAD = 10;
	final static double X_WIN = 300;
	final static double Y_WIN = 500;
	private double dx = 0 , dy = 1;
	private Timeline move;
	// RAD : 캐논의 반지름 , X_WIN : 화면의 가로사이즈 , Y_WIN : 화면의 세로 사이즈
	// dx , dy : 캐논의 x이동방향, y이동방향
	// move : 매 키프레임마다 캐논의 움직임을 표현
	
	
	public Cannon() {
		super(150, 300, RAD, Color.WHITE);
		// Circle생성자 작동 x위치,y위치,반지름, 색깔 설정
		
		
		move = new Timeline(
				new KeyFrame(Duration.millis(10), e-> move()));
		move.setCycleCount(Timeline.INDEFINITE);
	    move.play();
	    // move에 키프레임 설정 및 매 프레임마다 작동할 함수 설정, 무한 반복하게 해서 플레이
		
	}
	

	private void move() {
		if(getCenterX() < RAD || getCenterX() > X_WIN - RAD ) {
			dx = -dx;
		}
		// 만약 캐논이 왼쪽 벽이나 오른쪽 벽에 부딪친다면 x 이동방향을 반대로 한다.
		if(getCenterY() < RAD) {
			dy = -dy;
		}
		// 만약 캐논이 위쪽 벽에 부딪친다면 y 이동방향을 반대로 한다.
		
		
		if(getCenterY() > Y_WIN - RAD) {
			move.stop();
			setFill(Color.BLACK);
		}
		// 만약 캐논이 아래쪽 벽에 부딪친다면 캐논을 없애고(배경이 검은색이라 캐논을 검은색으로 하면 안보임), 동작을 멈춘다.
		
		
		
		setCenterX(getCenterX() + dx); 
		setCenterY(getCenterY() + dy); 
		// 매 프레임마다 현재 x,y에다가 dx, dy를 더해 캐논의 위치를 정한다.
	}
	
	void setDx(double val) {
		this.dx = val;
	}
	void setDy(double val) {
		this.dy = val;
	}
	//캐논의 dx, dy설정 함수
	

}
