package beans;

public class Product {
	private String CODE;
	private String NAME;
	private float FRICE;

	public Product(String CODE, String NAME, float FRICE) {
		this.CODE = CODE;
		this.NAME = NAME;
		this.FRICE = FRICE;
	}

	public Product() {

	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public float getFRICE() {
		return FRICE;
	}

	public void setFRICE(float FRICE) {
		this.FRICE = FRICE;
	}
}
