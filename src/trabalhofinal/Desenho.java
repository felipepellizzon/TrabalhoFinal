package trabalhofinal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Desenho implements GLEventListener{
        
        @Override
	public void init(GLAutoDrawable glad) {
		
	}
        
    	@Override
	public void dispose(GLAutoDrawable glad) {
	
        }
        
        @Override
	public void display(GLAutoDrawable glad) {
            GL2 gl = glad.getGL().getGL2();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glColor3f(1f, 0, 0);
            gl.glPointSize(3f);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2i(-1,-1);
            gl.glVertex2i(1, 1);
            gl.glEnd();
            gl.glFlush();
        }
        

	@Override
	public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
	
        }
        
        public GLJPanel criaPanel(){
            GLProfile profile = GLProfile.get(GLProfile.GL2);
            //ESPECIFICA OS RECURSOS DA OPENGL
            GLCapabilities capabilities = new GLCapabilities(profile);
            //Projecao projecao = new projecao();
            //Cria um painel e adiciona um ouvinte GLEventListener
            GLJPanel panel = new GLJPanel(capabilities);
            panel.addGLEventListener(this);
            return panel;
            
        }
    
}
