package cz.koscak.jan.game.trains.model;

public enum RailsType {

	UPDOWN(       false, true,  false, false, false, false),
	LEFTRIGHT(    false, false, false, false, true,  false),
	CROSS(        false, true,  false, false, true,  false),
	CURVE_DR(     false, false, true,  false, false, false),
	CURVE_RU(     false, false, false, false, false, true ),
	CURVE_UL(     false, false, false, true,  false, false),
	CURVE_LD(     true,  false, false, false, false, false),
	JUNCTION_D_UR(false, true,  true,  false, false, false);
	
	private final boolean dl;
	private final boolean du;
	private final boolean dr;
	private final boolean lu;
	private final boolean lr;
	private final boolean ur;
	
	private RailsType(boolean dl, boolean du, boolean dr, boolean lu, boolean lr, boolean ur){
		this.dl = dl;
		this.du = du;
		this.dr = dr;
		this.lu = lu;
		this.lr = lr;
		this.ur = ur;
	}

	public boolean isDL() {
		return dl;
	}

	public boolean isDU() {
		return du;
	}

	public boolean isDR() {
		return dr;
	}

	public boolean isLU() {
		return lu;
	}

	public boolean isLR() {
		return lr;
	}

	public boolean isUR() {
		return ur;
	}

}
