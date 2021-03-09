package ro.ase.acs.cta.g1094.refactor.phase1;

public enum ProductType {
	NEW(0), DISCOUNTED(0.1f), LIMITED_STOCK(0.25f), LEGACY(0.35f);

	private final float discountValue;
	
	private ProductType(float discount) {
		this.discountValue = discount;
	}
	
	public float getDiscount() {
		return this.discountValue;
	}
}
