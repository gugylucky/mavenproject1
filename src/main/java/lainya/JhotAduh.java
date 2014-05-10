/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lainya;

/**
 *
 * @author Susilo
 */
import java.awt.geom.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.liner.ElbowLiner;
import org.jhotdraw.draw.tool.DelegationSelectionTool;
import org.jhotdraw.geom.*;

public class JhotAduh implements Runnable{
           
                //koor point text area 1
                static  final int KOORA11 = 10;
                static  final int KOORA12 = 10;
                static  final int KOORA21 = 100;
                static  final int KOORA22 = 100;
                //koor point text area 2
                static  final int KOORB11 = 420;
                static  final int KOORB12 = 320;
                static  final int KOORB21 = 510;
                static  final int KOORB22 = 410;
                //koor point text area 3
                static  final int KOORC11 = 220;
                static  final int KOORC12 = 10;
                static  final int KOORC21 = 310;
                static  final int KOORC22 = 100;
            
                //ukuran window
                static final int VER = 500;
                static final int HOR = 600;
                
                public void run() {
                
                // Create a simple drawing consisting of three
                // text areas and an elbow connection.
                //area 1
                TextAreaFigure ta = new TextAreaFigure();
                ta.setBounds(new Point2D.Double(KOORA11,KOORA12),new Point2D.Double(KOORA21,KOORA22));
                //area 2
                TextAreaFigure tb = new TextAreaFigure();
                tb.setBounds(new Point2D.Double(KOORB11,KOORB12),new Point2D.Double(KOORB21,KOORB22));
                //area 3
                TextAreaFigure tc = new TextAreaFigure();
                tc.setBounds(new Point2D.Double(KOORC11,KOORC12),new Point2D.Double(KOORC21,KOORC22));
                ConnectionFigure cf = new LineConnectionFigure();
                //buat sambungan text area 1 ama 2 jadi zig zag
                cf.setLiner(new ElbowLiner());
                cf.setStartConnector(ta.findConnector(Geom.center(ta.getBounds()), cf));
                cf.setEndConnector(tb.findConnector(Geom.center(tb.getBounds()), cf));
                Drawing drawing = new DefaultDrawing();
                drawing.add(ta);
                drawing.add(tb);
                drawing.add(tc);
                drawing.add(cf);
                
                
                
                // Show the drawing
                JFrame f = new JFrame("naonlah");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //ukuran drawing
                f.setSize(HOR,VER); 
                
                // Set up the drawing view
                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.getContentPane().add(view.getComponent());
                
                // Set up the drawing editor
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);
                editor.setTool(new DelegationSelectionTool());
                
                f.show();
            }
        }
