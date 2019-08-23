package com.duan.vessel.head;

import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.vessel.shell.CylinderShell;

public class EHA extends Head {

	private static final long serialVersionUID = -2337513974950552185L;
	private double weight;
	private double inletVolume;
	private double inletHeight;
	private double outletHeight;
	
	@Override
	public double getVolumesByHeigt(double height, boolean isHorizontal) {
		double a = getLongID() / 2.0;
		double b = getShortID() / 2.0;
		if (isHorizontal) {
			if (height >= 0 && height <= getLongID()) {
				double v1 = Math.PI * b / a * (a * height * height - height * height * height / 3.0) / 2.0
						/ 1000000000.0;
				CylinderShell cylinderShell = new CylinderShell(getLongID(), 0, null, getStrLength(), isHorizontal);
				double v2 = cylinderShell.getVolumeByHeigt(height);
				return v1 + v2;
			}
			return Constant.ERROR_DOUBLE;
		} else {
			if (height >= 0 && height <= getInletHeight()) {
				double y = height - getShortID() / 2.0;
				if (height <= getInletHeight() - getStrLength()) {
					double v1 = (a * a * y + a * a * a / 3.0 - 4.0 / 3.0 * y * y * y) * Math.PI / 1000000000;
					return v1;
				} else {
					CylinderShell cylinderShell = new CylinderShell(getLongID(), 0, null, getStrLength(), false);
					double v1 = getInletVolume();
					double v2 = cylinderShell.getVolumeByHeigt(getInletHeight() - height);
					return v1 - v2;

				}

			}
			return Constant.ERROR_DOUBLE;
		}
	}

	@Override
	public double[][] getHeightsAndVolumesByLevelHeigt(double levelHeigt, boolean isHorizontal) {
		double h = levelHeigt;
		double add = levelHeigt;
		double upHeigth = isHorizontal ? getLongID() : getInletHeight();
		int i = 0;
		while (h < upHeigth) {
			i++;
			h += add;
		}
		i++;
		double[][] heightsAndVolumes = new double[i][3];
		int j = 0;
		h = levelHeigt;
		while (j < i) {
			if (h > upHeigth) {
				h = upHeigth;
			}
			heightsAndVolumes[j][0] = h;
			heightsAndVolumes[j][1] = DoubleUtils.doubleSavePointTwo(getVolumesByHeigt(h, isHorizontal));
			heightsAndVolumes[j][2] = DoubleUtils
					.doubleSavePointTwo(getVolumesByHeigt(h, isHorizontal) / getInletVolume() * 100);
			h += levelHeigt;
			j++;
		}
		return heightsAndVolumes;
	}

	@Override
	public double getWeight() {
		double w1 = getLongID() * getLongID() / 3.0 + getLongID() * getFormingThick() * 5.0 / 6.0
				+ 2.0 / 3.0 * getFormingThick() * getFormingThick()
				+ (getLongID() + getFormingThick()) * getStrLength();
		double p = getMeterial().getDensity();
		weight = p * Math.PI * getFormingThick() * w1 / 1000.0 / 1000.0;
		return weight;
	}

	@Override
	public double getInletVolume() {
		inletVolume=getVolumesByHeigt( getLongID(), true);
		return inletVolume;
	}

	@Override
	public double getInletHeight() {
		inletHeight = getStrLength() + getShortID() / 2.0;
		return inletHeight;
	}

	@Override
	public double getOutletHeight() {
		// TODO Auto-generated method stub
		outletHeight = getInletHeight() + getFormingThick();
		return outletHeight;
	}

}
