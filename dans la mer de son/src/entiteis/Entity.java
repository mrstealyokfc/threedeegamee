package entiteis;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;

//praise the data integration thought entity 
public class Entity {
	private TexturedModel model;
	private Vector3f position;
	private float rotX,rotY,rotZ;
	private float scale;
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	public void move(float dx, float dy, float dz) {
		this.position.x+=dx;
		this.position.y+=dy;
		this.position.z+=dz;
	}
	public void rotate(float rx,float ry,float rz) {
		this.rotX+=rx;
		this.rotY+=ry;
		this.rotZ+=rz;
	}
	
	public void setModel(TexturedModel model) {
		this.model = model;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	public TexturedModel getModel() {
		return model;
	}
	public Vector3f getPosition() {
		return position;
	}
	public float getRotX() {
		return rotX;
	}
	public float getRotY() {
		return rotY;
	}
	public float getRotZ() {
		return rotZ;
	}
	public float getScale() {
		return scale;
	}
	
	
}
