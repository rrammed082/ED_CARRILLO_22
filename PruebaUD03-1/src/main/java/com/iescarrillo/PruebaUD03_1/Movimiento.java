package com.iescarrillo.PruebaUD03_1;

public class Movimiento 
{
	protected String mConcepto;
	protected double mImporte;

	public double getImporte() 
	{
		return mImporte;
	}

	public String getConcepto()
	{
		return mConcepto;
	}

	public void setConcepto(String newMConcepto)
	{
		mConcepto = newMConcepto;
	}

	public void setImporte(double newMImporte)
	{
		mImporte = newMImporte;
	}
}