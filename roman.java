package projekt;

import java.util.List;

public class roman extends kniha{
	private String zaner;
	
	public roman(String nazov, List<String> autori, int rokVydania, String zaner) {
		super(nazov, autori, rokVydania, zaner);
		this.zaner = zaner;
	}

	public String getZaner() {
		return zaner;
	}

	public void setZaner(String zaner) {
		this.zaner = zaner;
	}
	
	

}