package com.grupo3.Caso1.Model;

import java.io.ByteArrayInputStream;

public class ReporteRepuesto {
	private String fileName;
	private ByteArrayInputStream stream;
	private int length;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ByteArrayInputStream getStream() {
		return stream;
	}

	public void setStream(ByteArrayInputStream stream) {
		this.stream = stream;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}


}
