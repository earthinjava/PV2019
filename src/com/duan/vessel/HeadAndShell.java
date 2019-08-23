package com.duan.vessel;

import java.io.Serializable;

import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.vessel.head.Head;
import com.duan.vessel.shell.CylinderShell;

public class HeadAndShell implements Serializable {

	private static final long serialVersionUID = 5868898822755714440L;
	private Head head;
	private CylinderShell cylinderShell;
	private boolean isHorizontal;
	private double mediumDensity;

	public HeadAndShell() {
	}

	public HeadAndShell(Head head, CylinderShell cylinderShell, double mediumDensity) {
		this.head = head;
		this.cylinderShell = cylinderShell;
		this.isHorizontal = cylinderShell.isHorizontal();
		this.mediumDensity = mediumDensity;
	}

	public double getVolumesByHeigt(double height) {
		if (isHorizontal) {
			return cylinderShell.getVolumeByHeigt(height) + 2.0 * head.getVolumesByHeigt(height, isHorizontal);
		} else {
			if (height <= head.getInletHeight()) {
				return head.getVolumesByHeigt(height, isHorizontal);
			} else if (height <= head.getInletHeight() + cylinderShell.getLength()) {
				return head.getInletVolume() + cylinderShell.getVolumeByHeigt(height - head.getInletHeight());
			} else if (height <= head.getInletHeight() * 2.0 + cylinderShell.getLength()) {
				double h1 = height - cylinderShell.getLength() - head.getInletHeight();
				double h2 = head.getInletHeight() - h1;
				double vUp = head.getVolumesByHeigt(h2, isHorizontal);
				double vDown = head.getInletVolume() - vUp;
				return vDown + cylinderShell.getTotalVolume() + head.getInletVolume();
			} else {
				return Constant.ERROR_DOUBLE;
			}

		}
	}

	public Double[][] getMessByLevelHeigt(double levelHeigt) {
		double h = levelHeigt;
		double add = levelHeigt;
		double upHeigth = isHorizontal ? cylinderShell.getInterDia()
				: head.getInletHeight() * 2.0 + cylinderShell.getLength();
		int i = 0;
		while (h < upHeigth) {
			i++;
			h += add;
		}
		i++;
		Double[][] heightsAndVolumes = new Double[i][6];
		int j = 0;
		h = levelHeigt;
		while (j < i) {
			if (h > upHeigth) {
				h = upHeigth;
			}
			heightsAndVolumes[j][0] = h;
			heightsAndVolumes[j][1] = DoubleUtils.doubleSavePointFive(getVolumesByHeigt(h));
			heightsAndVolumes[j][2] = DoubleUtils.doubleSavePointTwo(getVolumesByHeigt(h) * mediumDensity);
			heightsAndVolumes[j][3] = DoubleUtils.doubleSavePointTwo(getVolumesByHeigt(h) / getTotalVolume() * 100);
			heightsAndVolumes[j][4] = DoubleUtils.doubleSavePointTwo(1000.0 * 9.8 * h / 1000.0 / 1000.0);
			heightsAndVolumes[j][5] = DoubleUtils.doubleSavePointTwo(mediumDensity * 9.8 * h / 1000.0 / 1000.0);
			h += levelHeigt;
			j++;
		}
		return heightsAndVolumes;
	}

	public double getWeight() {
		// TODO Auto-generated method stub
		return cylinderShell.getWeight() + 2.0 * head.getWeight();
	}

	public double getTotalVolume() {
		// TODO Auto-generated method stub
		return cylinderShell.getTotalVolume() + 2.0 * head.getInletVolume();
	}

	public double getLoadWeigth() {
		return mediumDensity * getTotalVolume();
	}

	public double getLength() {
		// TODO Auto-generated method stub
		return head.getOutletHeight() * 2 + cylinderShell.getLength();
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public CylinderShell getCylinderShell() {
		return cylinderShell;
	}

	public void setCylinderShell(CylinderShell cylinderShell) {
		this.cylinderShell = cylinderShell;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	public double getMediumDensity() {
		return mediumDensity;
	}

	public void setMediumDensity(double mediumDensity) {
		this.mediumDensity = mediumDensity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
