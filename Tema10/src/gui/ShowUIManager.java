package gui;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class ShowUIManager {
    public static void main(String[] args) {
    	
        UIDefaults defaults = UIManager.getDefaults();
        String[] colName = {"Clave", "Valor"};
        String[][] rowData = new String[defaults.size()][2];
        // Da cero: System.out.println(defaults.keySet().size());
        // Paso a TreeSet para mostrarlas ordenadas
        Set<String> claves = new TreeSet<String>();
        for(Enumeration e = defaults.keys(); e.hasMoreElements(); )
        	claves.add(e.nextElement().toString());
        int i = 0;
        Iterator<String> it = claves.iterator();
        while (it.hasNext()) {
            //Object key = e.nextElement();
        	String key = it.next();
            rowData[i][0] = key;
            rowData[i][1] = "" + defaults.get(key);
            i++;
        }
        JFrame frame = new JFrame("Propiedades UIManager valores por defecto");
        JTable table = new JTable(rowData, colName);
        frame.setContentPane(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
