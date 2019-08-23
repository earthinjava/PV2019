package com.duan.vessel;

import com.duan.module.opening.bean.Openging;

public class GB150 {

	public static boolean isPressMeetingGB150(double press) {
		if (press > 0) {
			if (press >= 0.1 && press <= 35) {
				return true;
			}
			return false;
		} else {
			if (press < -0.02) {
				return true;
			}
			return false;
		}
	}

	/**
	 * 判断补强圈是否超出GB150计算范围
	 * 
	 * @param open
	 * @return
	 */
	public static boolean isOpeningOutOfSpecGB150(Openging open) {
		if(!isPressMeetingGB150(open.getDesignCondition().getDesignPress())) {
			return false;
		}
		double di = open.getShell().getInterDia();
		double dop = open.getPipe().getInterDia() + 2 * (open.getPipe().getC1() + open.getPipe().getC2());
		if (di <= 1500) {
			if (dop <= di / 2 && dop <= 520) {
				return false;
			} else {
				return true;
			}
		} else {
			if (dop <= di / 3 && dop <= 1000) {
				return false;
			} else {
				return true;
			}
		}
	}
}
