package com.duan.module.opening.bean;

import java.awt.Component;
import java.io.Serializable;

import com.duan.utils.JOptionPaneUtils;
import com.duan.vessel.designCondition.DesignCondition;
import com.duan.vessel.pipe.Pipe;
import com.duan.vessel.shell.Shell;

public class Openging implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private DesignCondition designCondition;
	private Shell shell;
	private Pipe pipe;
	private ReinforcementPlate reinforcementPlate;
	private Ae ae;
	private Ar ar;

	public ReinforcementPlate getReinforcementPlate() {
		return reinforcementPlate;
	}

	public void setReinforcementPlate(ReinforcementPlate reinforcementPlate) {
		this.reinforcementPlate = reinforcementPlate;
	}

	public DesignCondition getDesignCondition() {
		return designCondition;
	}

	public void setDesignCondition(DesignCondition designCondition) {
		this.designCondition = designCondition;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Pipe getPipe() {
		return pipe;
	}

	public void setPipe(Pipe pipe) {
		this.pipe = pipe;
	}

	public boolean isNeedCal() {
		double press = designCondition.getDesignPress();
		double od = pipe.getOutDia();
		double t = pipe.getNThick();
		double c1 = pipe.getC1();
		if (press > 2.5 || od > 89) {
			return true;
		} else {
			if (od <= 38 && t + c1 - 1 >= 3.5) {
				return false;
			}
			if (od <= 48 && t + c1 - 1 >= 4) {
				return false;
			}
			if (od <= 65 && t + c1 - 1 >= 5) {
				return false;
			}
			if (od <= 89 && t + c1 - 1 >= 6) {
				return false;
			}
			return true;
		}

	}

	public boolean isPlateCanUsed(Component messComponent) {
		double sn = shell.getNThick();
		double sr = reinforcementPlate.getThickness();
		double press = shell.getDesignCondition().getDesignPress();
		double temp = shell.getDesignCondition().getDesignTemp();		
		if (sr > 1.5 * sn) {
			JOptionPaneUtils.warningMess(messComponent, "补强圈厚度超过筒体厚度1.5倍,不可使用加强圈！");
			return false;
		}
		if (sn > 38) {
			JOptionPaneUtils.warningMess(messComponent, "筒体厚度超过38mm,不可使用加强圈！");
			return false;
		}
		if (press > 6.4) {
			JOptionPaneUtils.warningMess(messComponent, "设计压力超过6.4Mpa,不可使用加强圈！");
			return false;
		}
		if (temp > 350) {
			JOptionPaneUtils.warningMess(messComponent, "设计温度超过350℃,不可使用加强圈！");
			return false;
		}
		return true;
	}

	public Ae getAe() {
		return ae;
	}

	public void setAe(Ae ae) {
		this.ae = ae;
	}

	public Ar getAr() {
		return ar;
	}

	public void setAr(Ar ar) {
		this.ar = ar;
	}

}
