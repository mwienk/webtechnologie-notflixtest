package util;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlAttribute;

@XmlRootElement
public class ExceptionWrapper {
	
	private String message;

	@XmlAttribute
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ExceptionWrapper() {
		
	}
	
	public ExceptionWrapper(Exception e) {
		this.message = e.getMessage();
	}
}
