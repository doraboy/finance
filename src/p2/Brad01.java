package p2;

public class Brad01 {//public對一份原始碼來說,只能有一個public最外面類別
	void m1() {
		Brad02 obj2 = new Brad02();
	}
}

class Brad02 {
	public void m1() {//雖然這邊是public,理論上要大家都看的到
		//但是本方法是在Brad02內,Brad02是"沒寫"屬性,不同package看不到
		//所以不同package的類別連p2.Brad02都看不到了
		//當然也無法識別其內部public m1()方法
	}
}
