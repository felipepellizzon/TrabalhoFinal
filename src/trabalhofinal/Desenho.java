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
    
        private float alpha;
	private float beta;
	private float delta;
        private float gamma;
        private float omega;
        private float phi;
        private float pi;
        private float mi;
        private float zeta;
        
        public Desenho(){
		alpha = 0;
		beta = 0;
		delta = 0f;
                gamma = 0f;
                omega = 0f;
                phi = 0f;
                pi =0f;
                //mi = 0f;
                zeta = 0f;
        }
        
        @Override
	public void init(GLAutoDrawable glad) {
            GL2 gl = glad.getGL().getGL2();
		gl.glClearColor(255, 255, 255, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
                GLU glu = new GLU();
		glu.gluOrtho2D(-100.0, 100.0, -100, 100.0);
	}
        
    	@Override
	public void dispose(GLAutoDrawable glad) {
	
        }
        
        @Override
	public void display(GLAutoDrawable glad) {
            
            GL2 gl = glad.getGL().getGL2();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            DesenhoLinha(gl);
            DesenhoCirculo(gl);
            //DesenhoTriangulo(gl);
            //DesenhoQuadrado(gl);
            gl.glFlush();
        }
        
        private void DesenhoLinha(GL2 gl) {
		gl.glBegin(GL2.GL_LINES);
                        gl.glColor3f(255,0,0);
			gl.glVertex2f(25f, 50f);
			gl.glVertex2f(50f, 0f);
		gl.glEnd();
	}
        
        private void DesenhoCirculo(GL2 gl) {
        int numVertices = 20;
        double radius = 0.5;
        // clear the window
        gl.glColor3f(255, 0, 0); //set pen color to black
        // approximate  a circle with a polygon
        gl.glBegin(GL2.GL_POLYGON);
        //gl.glBegin(GL2.GL_TRIANGLE_FAN);
        
            double angle = 0;
            double angleIncrement = 2 * Math.PI / numVertices;
            for (int i = 0; i < numVertices; i++) {
                angle = i * angleIncrement;
                double x = radius * Math.cos(angle);
                double y = radius * Math.sin(angle);
                gl.glVertex2d(x, y);
            }
        
        gl.glEnd();

	}
        
        private void DesenhoTriangulo(GL2 gl) {
		gl.glBegin(GL2.GL_TRIANGLES);
                        gl.glColor3f(255,0,0);
			gl.glVertex2f(25f, 50f);
			gl.glVertex2f(50f, 0f);
			gl.glVertex2f(0f, 0f);
		gl.glEnd();
	}
        
        private void DesenhoQuadrado(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS);
                        gl.glColor3f(255,0,0);
			gl.glVertex2f(25f, 50f);
			gl.glVertex2f(50f, 0f);
			gl.glVertex2f(0f, 0f);
                        gl.glVertex2f(0f, 0f);
		gl.glEnd();
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
