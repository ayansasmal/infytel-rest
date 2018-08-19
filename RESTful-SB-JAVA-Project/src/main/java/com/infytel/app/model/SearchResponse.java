package com.infytel.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SearchResponse implements Serializable {

	private static final long serialVersionUID = 2790416366252688188L;
	private int recordsCount;
	private List<CustomerBean> records = new ArrayList<>();
	/**
	 * @return the recordsCount
	 */
	public int getRecordsCount() {
		return recordsCount;
	}
	/**
	 * @param recordsCount the recordsCount to set
	 */
	public void setRecordsCount(int recordsCount) {
		this.recordsCount = recordsCount;
	}
	/**
	 * @return the records
	 */
	public List<CustomerBean> getRecords() {
		return records;
	}
	/**
	 * @param records the records to set
	 */
	public void setRecords(List<CustomerBean> records) {
		this.records = records;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
