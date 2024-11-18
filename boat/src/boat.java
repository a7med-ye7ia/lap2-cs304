import com.sun.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;


/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
class SimpleJoglApp extends JFrame {
    private GLCanvas glCanvas = new GLCanvas();
    private SimpleGLEventListener Listner = new SimpleGLEventListener();
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
        animator = new FPSAnimator(glcanvas, 60);


        // add the GLCanvas just like we would  any Component
        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);


        //center the JFrame on the screen
        centerWindow();
        setVisible(true);
    }

    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();


        if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;


        this.setLocation(
                (screenSize.width - frameSize.width) >> 1,
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

        gl.glClearColor(135f / 255, 206f / 255, 234f / 255, 1.0f);

        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 600.0, 0.0, 300.0, -1.0, 1.0);


    }

    double y = 1 , q = 1 , z = 1;

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1 / 255f, 100f / 255, 201f / 255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(0, 0);
        gl.glVertex2i(600, 0);
        gl.glVertex2i(600, 150);
        gl.glVertex2i(0, 150);
        gl.glEnd();
        gl.glColor3f(200f / 255, 200f / 255, 250f / 255);
        gl.glPushMatrix();
        gl.glTranslated(z+=5 , 0 , 0);
        for (int h = 30; h < 150; h += 30) {
            for (int x = 0; x < 600; x ++) {
                gl.glBegin(GL.GL_LINE_STRIP);
                for (int i = 0; i <= 100; i++) {
                    double y = 10 * Math.sin((x + i) * 0.05);
                    gl.glVertex2d(x + i ,h + y);
                }
                gl.glEnd();
            }
        }
        if (z > 20) z = -80 ;
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(0 , 110, 0);
        gl.glTranslated(q+=3, 0, 0);
        //   gl.glRotated(0,0,0,1);
        gl.glScaled(0.2, 0.2, 1);
        if (q >= 600) q = -80;
        Create_Boat(gl);

        gl.glPopMatrix();
        // end of translate
        gl.glEnd();
        gl.glPushMatrix();
        gl.glTranslated(0 , -50, 0);
        gl.glTranslated(y++ , 0, 0);
        //  gl.glRotated(0,0,0,1);
        //  gl.glScaled(0.4, 0.4, 1);
        if (y == 600) y = -500;
        Create_Boat(gl);

        gl.glPopMatrix();
        // end of translate
        gl.glEnd();

    }

    void Create_Boat(GL gl) {
        gl.glColor3f(153f / 255, 75f / 255, 26f / 255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(100, 150);
        gl.glVertex2i(500, 150);
        gl.glVertex2i(480, 110);
        gl.glVertex2i(130, 110);
        gl.glEnd();
        gl.glColor3f(204f / 255, 126f / 255, 51f / 255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(120, 150);
        gl.glVertex2i(480, 150);
        gl.glVertex2i(480, 170);
        gl.glVertex2i(120, 170);
        gl.glEnd();
        gl.glColor3f(102f / 255, 50f / 255, 0f / 255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(280, 170);
        gl.glVertex2i(320, 170);
        gl.glVertex2i(320, 250);
        gl.glVertex2i(280, 250);
        gl.glEnd();
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(300, 250);
        gl.glVertex2i(300, 170);
        gl.glVertex2i(450, 170);

        gl.glEnd();


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
    ) {
    }

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
    ) {
    }


    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }
}