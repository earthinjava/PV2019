package com.duan.module.heatexchanger.beu.bean.structural;

import java.io.Serializable;

public class TubeBox implements Serializable{
	
	private static final long serialVersionUID = 1881624321593238210L;
	private TubeBoxDivisionPlate tubeBoxDivisionPlate;

	public TubeBoxDivisionPlate getTubeBoxDivisionPlate() {
		return tubeBoxDivisionPlate;
	}

	public void setTubeBoxDivisionPlate(TubeBoxDivisionPlate tubeBoxDivisionPlate) {
		this.tubeBoxDivisionPlate = tubeBoxDivisionPlate;
	}
}
