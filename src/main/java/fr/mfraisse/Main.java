package fr.mfraisse;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        System.out.println(map.getMap());
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "txt file", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            Point characterPosition = map.moveCharacter(chooser.getSelectedFile().getAbsolutePath());
            System.out.println("The new position of your character will be (" + characterPosition.x + ", " + characterPosition.y + ")");
        }
    }
}