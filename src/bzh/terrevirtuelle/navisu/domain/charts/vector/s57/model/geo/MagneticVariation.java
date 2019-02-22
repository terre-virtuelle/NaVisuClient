package bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo;

import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.Geo;
import java.io.Serializable;


public class MagneticVariation extends Geo
implements Serializable
{

	public MagneticVariation(Long id)
	{
		this.id=id;
	}

	public MagneticVariation(){}

	private String dateEnd;

	public String getDateEnd()
	{
		return dateEnd;
	}

	public void setDateEnd(String value)
	{
		this.dateEnd= value;
	}

	private String dateStart;

	public String getDateStart()
	{
		return dateStart;
	}

	public void setDateStart(String value)
	{
		this.dateStart= value;
	}

	private String recordIngdate;

	public String getRecordIngdate()
	{
		return recordIngdate;
	}

	public void setRecordIngdate(String value)
	{
		this.recordIngdate= value;
	}

	private String recordingIndication;

	public String getRecordingIndication()
	{
		return recordingIndication;
	}

	public void setRecordingIndication(String value)
	{
		this.recordingIndication= value;
	}

	private String referenceYearForMagneticVariation;

	public String getReferenceYearForMagneticVariation()
	{
		return referenceYearForMagneticVariation;
	}

	public void setReferenceYearForMagneticVariation(String value)
	{
		this.referenceYearForMagneticVariation= value;
	}

	private String scaleMaximum;

	public String getScaleMaximum()
	{
		return scaleMaximum;
	}

	public void setScaleMaximum(String value)
	{
		this.scaleMaximum= value;
	}

	private String valueOfAnnualChangeInMagneticvariation;

	public String getValueOfAnnualChangeInMagneticVariation()
	{
		return valueOfAnnualChangeInMagneticvariation;
	}

	public void setValueOfAnnualChangeInMagneticVariation(String value)
	{
		this.valueOfAnnualChangeInMagneticvariation= value;
	}

	private String valueOfMagneticvariation;

	public String getValueOfMagneticVariation()
	{
		return valueOfMagneticvariation;
	}

	public void setValueOfMagneticVariation(String value)
	{
		this.valueOfMagneticvariation= value;
	}


}
