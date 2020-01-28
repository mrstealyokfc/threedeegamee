package shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram{
	private static final String vertexFile="src/shaders/vertexShader.txt";
	private static final String fragmentFile="src/shaders/fragmentShader.txt";
	
	private int transformationMatrixLocation;
	public StaticShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		transformationMatrixLocation=super.getUniformLocation("transformationMatrix");
		
	}
	public void loadTransFormationMatrix(Matrix4f matrix) {
		super.loadMatrix(transformationMatrixLocation, matrix);
	}

}
