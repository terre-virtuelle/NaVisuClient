package bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo;

import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.Geo;
import java.io.Serializable;


public class TidalStreamNon_harmonicPrediction extends Geo
implements Serializable
{

	public TidalStreamNon_harmonicPrediction(Long id)
	{
		this.id=id;
	}

	public TidalStreamNon_harmonicPrediction(){}

	private String objectName;

	public String getObjectName()
	{
		return objectName;
	}

	public void setObjectName(String value)
	{
		this.objectName= value;
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

	private String scaleMaximum;

	public String getScaleMaximum()
	{
		return scaleMaximum;
	}

	public void setScaleMaximum(String value)
	{
		this.scaleMaximum= value;
	}

	private String status;

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String value)
	{
		this.status= value;
	}

	private String tideMethodOftidalPrediction;

	public String getTideMethodOfTidalPrediction()
	{
		return tideMethodOftidalPrediction;
	}

	public void setTideMethodOfTidalPrediction(String value)
	{
		this.tideMethodOftidalPrediction= value;
	}

	private String tidetimeAndHeightDifferences;

	public String getTideTimeAndHeightDifferences()
	{
		return tidetimeAndHeightDifferences;
	}

	public void setTideTimeAndHeightDifferences(String value)
	{
		this.tidetimeAndHeightDifferences= value;
	}

	private String objectNameInNationalLanguage;

	public String getObjectNameInNationalLanguage()
	{
		return objectNameInNationalLanguage;
	}

	public void setObjectNameInNationalLanguage(String value)
	{
		this.objectNameInNationalLanguage= value;
	}


}
