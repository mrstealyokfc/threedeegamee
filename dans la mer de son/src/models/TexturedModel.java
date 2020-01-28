package models;

import textures.ModelTexture;

public class TexturedModel {
	private FreeModelCitizen rawModel;
	private ModelTexture texture;
	public TexturedModel(FreeModelCitizen model,ModelTexture texture) {
		this.rawModel=model;
		this.texture=texture;
	}
	public FreeModelCitizen getRawModel() {
		return rawModel;
	}
	public ModelTexture getTexture() {
		return texture;
	}
}
