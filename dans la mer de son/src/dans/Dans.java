package dans;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class Dans {
	private static final int WIDTH=1000;
	private static final int HEIGHT=800;
	private static final int FPS=120;
	public static void createDisplay() {
		
		ContextAttribs daisl =new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(),daisl);
		}catch(LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	public static void updateDisplay() {
		Display.sync(FPS);
		Display.update();
	}
	public static void eviscerateDisplay() {
		Display.destroy();
	}
}
