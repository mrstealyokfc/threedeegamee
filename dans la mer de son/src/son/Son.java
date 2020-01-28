package son;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import dans.Dans;
import dans.Loader;
import dans.Rend;
import entiteis.Entity;
import mer.Paddle;
import models.FreeModelCitizen;
import models.TexturedModel;
import shaders.StaticShader;
import textures.ModelTexture;

public class Son {
	public static void main(String[] args) {
		Dans.createDisplay();
		Loader loader=new Loader();
		Rend rend =new Rend();
		StaticShader shad=new StaticShader();
		float xRotation=0;
		float[][] indexes= {
			{
				-1f,1f,0f,//front top left
				-1f,-1f,0f,//front bottom left
				0f,-1f,0f,//front bottom right
				0f,1f,0f,//front top right
				-1f,1f,-1f,//back top left
				-1f,-1f,-1f,//back bottom left
				0f,-1f,-1f,//back bottom right
				0f,1f,-1f,//back top right
			},
			
			{
				1f,1f,0f,
				0f,1f,0f,
				1,-1,0f,
				0,-1,0f,
			}
		};
		int[][] connections={
			{
				0,1,2,
				0,2,3,
				0,4,1,
				1,5,4,
				1,5,6,
				1,6,2,
				7,3,2,
				6,2,7,
				4,5,6,
				4,7,6,
				7,4,0,
				0,3,7,
				
			},
			
			{
				0,1,2,
				2,1,3,
			}
			
		};
		float[][] textureMap={
			{
				1,1,
				0,1,
				1,0,
				0,0,
			},
			
			{
				1,1,
				0,1,
				1,0,
				0,0,
			}
		};
		
		FreeModelCitizen[] models= {
			loader.loadToVAO(indexes[0],textureMap[0],connections[0]),
			loader.loadToVAO(indexes[1],textureMap[1],connections[1])
		};
		
		ModelTexture[] textures= {
			new ModelTexture(loader.loadTexture("not")),
			new ModelTexture(loader.loadTexture("not"))
		};
		
		TexturedModel[] texmods= {
			new TexturedModel(models[0],textures[0]),
			new TexturedModel(models[1],textures[1])
		};
		Entity entity =new Entity(texmods[0],new Vector3f(0f,0f,0f),-30f,30f,0f,0.5f);
		Entity entity2 =new Entity(texmods[0],new Vector3f(-0.5f,0f,0f),-30f,30f,0f,0.2f);
		Entity entity3 =new Entity(texmods[0],new Vector3f(0.5f,0f,0f),-30f,30f,0f,0.2f);
		
		//GL11.glEnable(GL11.GL_DEPTH_TEST);
		//GL11.glDepthFunc(GL11.GL_LESS);
		float xDir=0.01f,yDir=0.015f,zDir=0.005f;
		while(!Display.isCloseRequested()) {
			//GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			rend.prepare();
			shad.start();
			entity.rotate(0.1f, 0.1f, 1f);
			entity2.rotate(5f, 2f, 3f);
			entity3.rotate(0.3f, 0.2f, 0.1f);

			entity.move(xDir,0,0);
			entity2.move(zDir,0,0);
			entity3.move(yDir,0,0);
			if(entity.getPosition().x>1f||entity.getPosition().x<-0.35f) {
				xDir*=-1;
			}
			if(entity3.getPosition().x>1f||entity3.getPosition().x<-0.35f) {
				yDir*=-1;
			}
			if(entity2.getPosition().x>1f||entity2.getPosition().x<-0.35f) {
				zDir*=-1;
			}
			
			rend.render(entity,shad);
			//rend.render(entity2,shad);
			//rend.render(entity3,shad);
			xRotation+=0.5;
			Dans.updateDisplay();
			//loader.eviscerate();
		}
		shad.eviscerate();
		loader.eviscerate();
		Dans.eviscerateDisplay();
	}
}
