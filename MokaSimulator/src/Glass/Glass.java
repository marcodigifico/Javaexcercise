package Glass;

public abstract class Glass {

	int capacity;
	int content;

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean emptyGlass() {

		if (this.content == 0) {

			return true;

		} else {
			return false;
		}
	}

}
