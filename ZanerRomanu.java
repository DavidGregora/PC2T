package projekt;

public enum ZanerRomanu {
	DETEKTIVNY,
    HISTORICKY,
    PSYCHOLOGICKY,
    ROMANTICKY,
    SCI_FI;
	
	@Override
    public String toString() {
        return this.name();
    }


}
