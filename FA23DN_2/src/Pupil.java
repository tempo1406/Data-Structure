public class Pupil {
	public int rollNum;
	public int mark;

	public Pupil(int rollNum, int mark) {
		this.rollNum = rollNum;
		this.mark = mark;
	}

	public Pupil() {
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Pupil [rollNum=" + rollNum + ", mark=" + mark + "]";
	}
	
}
