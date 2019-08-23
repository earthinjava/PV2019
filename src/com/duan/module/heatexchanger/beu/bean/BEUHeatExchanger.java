package com.duan.module.heatexchanger.beu.bean;

import java.io.Serializable;

import com.duan.module.heatexchanger.beu.bean.designCondition.HeatDesignConditions;
import com.duan.module.heatexchanger.beu.bean.structural.Baffle;
import com.duan.module.heatexchanger.beu.bean.structural.TubeBoxDivisionPlate;
import com.duan.module.heatexchanger.beu.bean.structural.TubeBundle;
import com.duan.module.heatexchanger.beu.bean.structural.TubePlate;
import com.duan.module.heatexchanger.beu.bean.structural.TubePlateGasket;
import com.duan.module.heatexchanger.beu.bean.structural.UHeatTube;
import com.duan.vessel.head.Head;
import com.duan.vessel.shell.Shell;

public class BEUHeatExchanger implements Serializable{
	
	private static final long serialVersionUID = 5816339412846941409L;
	// �������
	private HeatDesignConditions heatDesignConditions;
	// �ǳ�Ͳ��
	private Shell shellSideCylinder;
	// �ǳ̷�ͷ
	private Head shellSideHead;
	// �ǳ̸���
	private Baffle baffle;
	// ���ȹ���
	private TubeBundle tubeBundle;
	// �ܰ�
	private TubePlate tubePlate;
	// ���ȹ�
	private UHeatTube uHeatTube;
	//�������
	private TubeBoxDivisionPlate tubeBoxDivisionPlate;

	
	
	public HeatDesignConditions getHeatDesignConditions() {
		return heatDesignConditions;
	}

	public void setHeatDesignConditions(HeatDesignConditions heatDesignConditions) {
		this.heatDesignConditions = heatDesignConditions;
	}

	public Shell getShellSideCylinder() {
		return shellSideCylinder;
	}

	public void setShellSideCylinder(Shell shellSideCylinder) {
		this.shellSideCylinder = shellSideCylinder;
	}

	public Head getShellSideHead() {
		return shellSideHead;
	}

	public void setShellSideHead(Head shellSideHead) {
		this.shellSideHead = shellSideHead;
	}

	public Baffle getBaffle() {
		return baffle;
	}

	public void setBaffle(Baffle baffle) {
		this.baffle = baffle;
	}

	public TubeBundle getTubeBundle() {
		return tubeBundle;
	}

	public void setTubeBundle(TubeBundle tubeBundle) {
		this.tubeBundle = tubeBundle;
	}

	public TubePlate getTubePlate() {
		return tubePlate;
	}

	public void setTubePlate(TubePlate tubePlate) {
		this.tubePlate = tubePlate;
	}

	public TubePlateGasket getTubePlateGasket() {
		return tubePlateGasket;
	}

	public void setTubePlateGasket(TubePlateGasket tubePlateGasket) {
		this.tubePlateGasket = tubePlateGasket;
	}

	public UHeatTube getUHeatTube() {
		return uHeatTube;
	}

	public void setUHeatTube(UHeatTube uHeatTube) {
		this.uHeatTube = uHeatTube;
	}

	public TubeBoxDivisionPlate getTubeBoxDivisionPlate() {
		return tubeBoxDivisionPlate;
	}

	public void setTubeBoxDivisionPlate(TubeBoxDivisionPlate tubeBoxDivisionPlate) {
		this.tubeBoxDivisionPlate = tubeBoxDivisionPlate;
	}

	// �ܰ��Ƭ
	private TubePlateGasket tubePlateGasket;

}
