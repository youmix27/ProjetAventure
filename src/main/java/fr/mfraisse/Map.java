package fr.mfraisse;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    protected String map;
    protected int row;
    protected int col;


    public Map(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/maps/" + filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            row = 0;
            col = line.length();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                row++;
            }
            map = sb.toString();
            for (String car : map.split(",")) {
                System.out.println(car);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Overload of the constructor with default map
     */
    public Map(){
        this("carte v2.txt");
    }

    public String getMap() {
        return map;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public char getElement(int col, int row) {
        return map.charAt(row + (col * row + 1));
    }
}

