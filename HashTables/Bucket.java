
public class Bucket {
	
	private Object element;
	private boolean isEmptyFromTheBegining;
	
	
	
	public Bucket(Object element, boolean isEmptyFromTheBegining) {
		this.element = element;
		this.isEmptyFromTheBegining = isEmptyFromTheBegining;
	}
	
	
	
	
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public boolean isEmptyFromTheBegining() {
		return isEmptyFromTheBegining;
	}
	public void setEmptyFromTheBegining(boolean isEmptyFromTheBegining) {
		this.isEmptyFromTheBegining = isEmptyFromTheBegining;
	}
	
	

}
