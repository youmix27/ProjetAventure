package fr.mfraisse;

import java.awt.*;
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
        }catch (Exception e) {
            throw new IllegalArgumentException("File was not found.");
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

    /**
     * Method returning if the point on the map correpsonding to the given coordinate is a space characted.
     * @param col index
     * @param row index
     * @return boolean
     */
    public boolean isMovable(int col, int row) {
        if(col < 0 || col >= this.col || row < 0 || row >= this.row){
            return false;
        }
        return (map.charAt(col + ((this.col + 2) * row)) == ' '); // adding 2 to the number of colon because of the line separator
    }

    public Point moveCharacter(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/instructions/" + filename))) {
            StringBuilder sb = new StringBuilder();
            String CoordinateLine = br.readLine();

            //We check if there is content on the first line
            if (CoordinateLine == null) {throw new IllegalArgumentException("File wasn't as expected.");}

            int posX = CoordinateLine.charAt(0) - '0', posY = (int) CoordinateLine.charAt(2) - '0';
            //We check if the original position of the character is on a space
            if(!this.isMovable(posX, posY)){throw new IllegalArgumentException("Wrong origin position.");}

            String instructionLine = br.readLine();
            //We check if there is content on the second line
            if (instructionLine == null) {throw new IllegalArgumentException("File wasn't as expected.");}

            for(char character : instructionLine.toCharArray()){
                System.out.print(character);
                switch (character){
                    case 'N':
                        if(this.isMovable(posX, posY + 1)){
                            posY++;
                        }
                        break;
                    case 'S':
                        if(this.isMovable(posX, posY - 1)){
                            posY--;
                        }
                        break;
                    case 'E':
                        if(this.isMovable(posX + 1, posY )){
                            posX++;
                        }
                        break;
                    case 'O':
                        if(this.isMovable(posX - 1, posY)){
                            posX--;
                        }
                        break;
                    default:
                        break;
                }
            }
            return new Point(posX, posY);
        }catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

