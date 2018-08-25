package tw.org.iii.mytest;

public class java84 {
	public static void main(String[] args) {
		Player p1 = new Player();
		System.out.println(p1.getDir());
		p1.setDir(Direction.LEFT);
		System.out.println(p1.getDir());
		
		//switch中只能放:以下六種型別
		//byte,short,int,short,String,enum
		switch(p1.getDir()) {
		case STOP:
			System.out.println("A");break;
		case LEFT:
			System.out.println("B");break;
		case RIGHT:
			System.out.println("C");break;
		case UP:
			System.out.println("D");break;
		case DOWN:
			System.out.println("E");break;
		}
		
		if(p1.getDir() == Direction.LEFT) {
			System.out.println("go left");
		}else {
			System.out.println("go other");		
		}

	}
}

//列舉
//這個Direction類別,總共只有5個物件實體,不會變動
//使用時也無須用new產生物件實體(因宣告時早已存在)
enum Direction {//方向就只有5種
	STOP,LEFT,RIGHT,UP,DOWN
}

class Player {
	private Direction dir; //0:stop,1,2,3,4
	
	private final static int STATE_NEW = 1;
	private final static int STATE_SLEEP = 2;
	private final static int STATE_RUNNING = 3;
	private final static int STATE_DIE = 4;
	//或直接定義在類別內,此方法比列舉更常用
	private int state = STATE_SLEEP;
	
	void setDir(Direction dir) {
		System.out.println("state="+state);
		this.dir = dir;
	}
	
	Direction getDir() {
		return dir;
	}
}
