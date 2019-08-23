package com.duan.module.heatexchanger.sprialPlate.bean;

import java.io.Serializable;

import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;

/**
 * ��������bean
 * 
 * @author Administrator
 *
 */
public class PreThermalCalculation implements Serializable{
	
	private static final long serialVersionUID = 8147216721827288335L;
	// �������
	private SPHEDesignConditions designConditions;
	// �²�����ϵ��
	private double temperatureDifferenceCorrectionFactor;
	// �²�����ϵ��ȡֵͼ��ַ
	private static final String temperatureDifferenceCorrectionFactorFigPathString = "src/img/SprialPlateHeatExchanger/temperatureDifferenceCorrectionFactorFig.png";
	// ��ѡ����ϵ��ֵͼ��ַ
	private static final String preSprialPlateHeatExchangerKFigPathString = "src/img/SprialPlateHeatExchanger/SprialPlateHeatExchangerKFig.png";
	// �����²������ϵ���ľ�����
	private double logarithmicTemperatureDifference;
	// ������ʽ�Ƿ�Ϊ˳��:trueΪ˳�� falseΪ����
	private boolean isDownStream;
	// ��������ϵ��
	private double preHeatTransferCoefficient;
	// �����������0.2����20%
	private double surfaceAllowanceOfHeatTransfer;
	// ���㻻�����
	private double preHeatTransferArea;
	// ������ w
	private double heat;

	public PreThermalCalculation(SPHEDesignConditions designConditions) {
		// TODO Auto-generated constructor stub
		this.designConditions = designConditions;
		heat = designConditions.getHotDesignCondition().getHeat();
		isDownStream = designConditions.isDownStream();
	}

	// ������㻻�����
	private void calPreHeatTransferArea() {
		calLogarithmicTemperatureDifference();
		preHeatTransferArea = heat / logarithmicTemperatureDifference / preHeatTransferCoefficient;
		preHeatTransferArea = preHeatTransferArea * (1 + surfaceAllowanceOfHeatTransfer);
	}

	// �������ƽ���²�
	private void calLogarithmicTemperatureDifference() {
		double dt1;
		double dt2;
		// �ж��Ƿ�Ϊ˳��
		if (isDownStream) {
			dt1 = designConditions.getHotDesignCondition().getInletTemp()
					- designConditions.getColdDesignCondition().getInletTemp();
			dt2 = designConditions.getHotDesignCondition().getOutletTemp()
					- designConditions.getColdDesignCondition().getOutletTemp();
		} else {
			dt1 = designConditions.getHotDesignCondition().getOutletTemp()
					- designConditions.getColdDesignCondition().getInletTemp();
			dt2 = designConditions.getHotDesignCondition().getInletTemp()
					- designConditions.getColdDesignCondition().getOutletTemp();
		}
		if (dt1 == dt2) {
			logarithmicTemperatureDifference = dt1;
		} else {
			logarithmicTemperatureDifference = (dt1 - dt2) / (Math.log(dt1 / dt2))
					* temperatureDifferenceCorrectionFactor;
		}

	}

	// ��ö����²�
	public double getLogarithmicTemperatureDifference() {
		calLogarithmicTemperatureDifference();
		return logarithmicTemperatureDifference;
	}

	// �趨���軻��ϵ��
	public void setPreHeatTransferCoefficient(double preHeatTransferCoefficient) {
		this.preHeatTransferCoefficient = preHeatTransferCoefficient;
	}

	// �趨�����������
	public void setSurfaceAllowanceOfHeatTransfer(double surfaceAllowanceOfHeatTransfer) {
		this.surfaceAllowanceOfHeatTransfer = surfaceAllowanceOfHeatTransfer;
	}

	// ���Ԥ�㻻�����
	public double getPreHeatTransferArea() {
		calPreHeatTransferArea();
		return preHeatTransferArea;
	}

	// ��û���ϵ������ͼƬ��ַ
	public static String getTemperatureDifferenceCorrectionFactorFigPathString() {
		return temperatureDifferenceCorrectionFactorFigPathString;
	}

	// ��û���ϵ��ͼƬ��ַ
	public static String getPreSprialPlateHeatExchangerKFigPathString() {
		return preSprialPlateHeatExchangerKFigPathString;
	}

	// �趨�²��޶�ϵ��
	public void setTemperatureDifferenceCorrectionFactor(double f) {
		// TODO Auto-generated method stub
		temperatureDifferenceCorrectionFactor = f;
	}

	// ��ö����²��޶�ϵ��
	public double getTemperatureDifferenceCorrectionFactor() {
		return temperatureDifferenceCorrectionFactor;
	}

	// �����������
	public SPHEDesignConditions getDesignConditions() {
		return designConditions;
	}

	// �Ƿ�Ϊ˳��
	public boolean isDownStream() {
		return isDownStream;
	}
}
