/**
 * @author burcakotlu
 * @date Apr 3, 2014 
 * @time 11:34:37 AM
 */
package jaxbxjctool;

/**
 * 
 */
public class RsInformation {
	
	String rsId;
	String chrNamewithoutChr;
	int startZeroBased;
	int endZeroBased;
	String observedAlleles;
	
	
	public int getStartZeroBased() {
		return startZeroBased;
	}



	public void setStartZeroBased(int startZeroBased) {
		this.startZeroBased = startZeroBased;
	}



	public int getEndZeroBased() {
		return endZeroBased;
	}



	public void setEndZeroBased(int endZeroBased) {
		this.endZeroBased = endZeroBased;
	}



	public String getRsId() {
		return rsId;
	}



	public void setRsId(String rsId) {
		this.rsId = rsId;
	}


	public String getChrNamewithoutChr() {
		return chrNamewithoutChr;
	}



	public void setChrNamewithoutChr(String chrNamewithoutChr) {
		this.chrNamewithoutChr = chrNamewithoutChr;
	}



	public String getObservedAlleles() {
		return observedAlleles;
	}



	public void setObservedAlleles(String observedAlleles) {
		this.observedAlleles = observedAlleles;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
