package Jogl;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;


import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;


/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class SimpleJoglApp extends JFrame {
    private GLCanvas glCanvas = new GLCanvas();
    private  SimpleGLEventListener Listner = new SimpleGLEventListener();
    static FPSAnimator animator = null;

    /**
     *
     */



    public static void main(String[] args) {
        final SimpleJoglApp app = new SimpleJoglApp();

        animator.start();
        // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
    }


    public SimpleJoglApp() {
        //set the JFrame title
        super("Simple JOGL Application");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
//    glcanvas.addGLEventListener(new SimpleGLEventListener());
        glcanvas.addGLEventListener(Listner);
        animator = new FPSAnimator(glcanvas,60);


        // add the GLCanvas just like we would  any Component
        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);


        //center the JFrame on the screen
        centerWindow();
        setVisible(true);
    }


    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = this.getSize();


        if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;


        this.setLocation (
                (screenSize.width  - frameSize.width ) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}


/**
 * For our purposes only two of the
 * GLEventListeners matter. Those would
 * be init() and display().
 */
class SimpleGLEventListener implements GLEventListener {

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glClearColor(255 / 255f, 255 / 255f, 1.0f, 1.0f);

        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-800.0, 800.0, -500.0, 500.0, -1.0, 1.0);


    }

    /**
     * Take care of drawing here using GL (OpenGL 1.x).
     */
    double x =1;
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL(); // Get the GL context
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // main turtl
        gl.glPushMatrix();

        gl.glTranslated(10,0,0);
        gl.glRotated(x++,0,0,1);
//        gl.glScaled(1,1,1);

        turtle(drawable);

        gl.glPopMatrix();
        // end of translate

        // up-right turtle
        gl.glPushMatrix();

        gl.glTranslated(500,400,0);
        gl.glRotated(x+=0.2,0,0,1);
        gl.glScaled(0.2,0.2,1);

        turtle(drawable);

        gl.glPopMatrix();
        // end of translate

        // up-left turtle
        gl.glPushMatrix();

        gl.glTranslated(-500,400,0);
        gl.glRotated(x+=0.1,0,0,1);
        gl.glScaled(0.2,0.2,1);

        turtle(drawable);

        gl.glPopMatrix();
        // end of translate

        // down-right turtle
        gl.glPushMatrix();

        gl.glTranslated(500,-400,0);
        gl.glRotated(x+=0.2,0,0,1);
        gl.glScaled(0.2,0.2,1);

        turtle(drawable);

        gl.glPopMatrix();
        // end of translate

        // down-left turtle
        gl.glPushMatrix();

        gl.glTranslated(-500,-400,0);
        gl.glRotated(x+=0.2,0,0,1);
        gl.glScaled(0.2,0.2,1);

        turtle(drawable);

        gl.glPopMatrix();
        // end of translate

        gl.glEnd();
        // Clear the screen
        // Set color (RGB values for green)

        // End drawing
    }
    public void turtle(GLAutoDrawable drawable){
        GL gl = drawable.getGL(); // Get the GL context
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        circle(0, 295, 179 / 255f, 229 / 255f, 178 / 255f, 120, drawable);
        gl.glEnd();

        circle(50, 320, 0 / 255f, 8 / 255f, 0 / 255f, 20, drawable);
        gl.glEnd();
        circle(-50, 320, 0 / 255f, 8 / 255f, 0 / 255f, 20, drawable);
        gl.glEnd();

        circle(0, 0, 19 / 255f, 110 / 255f, 15 / 255f, 250, drawable);
        gl.glEnd();
        circle(0, 0, 51 / 255f, 205 / 255f, 52 / 255f, 240, drawable);
        gl.glEnd();
        circle(0, 0, 26 / 255f, 152 / 255f, 27 / 255f, 200, drawable);
        gl.glEnd();
        circle(0, 0, 76 / 255f, 226 / 255f, 76 / 255f, 150, drawable);
        gl.glEnd();
        circle(220, 140, 128 / 255f, 178 / 255f, 127 / 255f, 75, drawable);
        gl.glEnd();
        circle(-220, 140, 128 / 255f, 178 / 255f, 127 / 255f, 75, drawable);
        gl.glEnd();
        circle(-220, -140, 128 / 255f, 178 / 255f, 127 / 255f, 75, drawable);
        gl.glEnd();
        circle(220, -140, 128 / 255f, 178 / 255f, 127 / 255f, 75, drawable);
        gl.glEnd();
        circle(260, 170, 79 / 255f, 125 / 255f, 79 / 255f, 35, drawable);
        gl.glEnd();
        circle(-260, 170, 79 / 255f, 125 / 255f, 79 / 255f, 35, drawable);
        gl.glEnd();
        circle(260, -170, 79 / 255f, 125 / 255f, 79 / 255f, 35, drawable);
        gl.glEnd();
        circle(-260, -170, 79 / 255f, 125 / 255f, 79 / 255f, 35, drawable);
        gl.glEnd();
        // to make tail
        gl.glColor3f(103/255f, 153/255f, 102/255f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(40,-245);
        gl.glVertex2i(-40,-245);
        gl.glVertex2i(0,-355);
        gl.glEnd();

        for (int i = 180; i <= 360; i++) {
            gl.glBegin(GL.GL_LINE_STRIP);

            // double angle = 2 * Math.PI * i / 100; // Divide circle into 100 segments
            float x = (float) (0+35 * Math.cos(Math.toRadians(i)));
            float y = (float) (278+(15 * Math.sin(Math.toRadians(i))));
            // Define the point on the circumference
            gl.glVertex2f(  x, y);
        }
        gl.glEnd();
    }
    public void circle(float cx , float cy , float red , float green , float yellow, float dia , GLAutoDrawable drawable ){
        GL gl = drawable.getGL(); // Get the GL context

        // Clear the screen
        //   gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        // Set color (RGB values for green)
        gl.glColor3f(red, green, yellow);  // Set color to green

        // Begin drawing a filled circle using a triangle fan
        gl.glBegin(GL.GL_POLYGON);

        // Center of the circle


        gl.glVertex2f(cx, cy);  // Center point of the circle

        // Loop to create the circle points
        for (int i = 0; i <= 100; i++) {
            double angle = 2 * Math.PI * i / 100; // Divide circle into 100 segments
            float x = (float) (dia * Math.cos(angle));
            float y = (float) (dia * Math.sin(angle));

            // Define the point on the circumference
            gl.glVertex2f(cx + x, cy + y);
        }

        gl.glEnd(); // End drawing
    }



    /**
     * Called when the GLDrawable (GLCanvas
     * or GLJPanel) has changed in size. We
     * won't need this, but you may eventually
     * need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {}

    /**
     * If the display depth is changed while the
     * program is running this method is called.
     * Nowadays this doesn't happen much, unless
     * a programmer has his program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {}


    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }
    public static  void main(String[] args) {
        new SimpleJoglApp();

    }

}
