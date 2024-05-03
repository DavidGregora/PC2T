package projekt;

import java.util.List;

public class ucebnica extends kniha{
	private int rocnik;
	
	public ucebnica(String nazov, List<String> autori, int rokVydania, int rocnik) {
		super(nazov, autori, rokVydania, ZanerRomanu.ROMANTICKY);
		this.rocnik = rocnik;
	}
	
	
	
    public int getRocnik() {
		return rocnik;
	}



	public void setRocnik(int rocnik) {
		this.rocnik = rocnik;
	}



	@Override
    public String getInfo() {
    	return super.getInfo() + "\nRocnik: " +rocnik;
    }

}
