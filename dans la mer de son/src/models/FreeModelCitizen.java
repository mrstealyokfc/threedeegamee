package models;

public class FreeModelCitizen {
	private int vaoID;
	private int vertexCount;
	public FreeModelCitizen(int vaoID,int vertexCount) {
		this.vaoID=vaoID;
		this.vertexCount=vertexCount;
	}
	public int getVaoID() {
		return vaoID;
	}
	public int getVertexCount() {
		return vertexCount;
	}
}
