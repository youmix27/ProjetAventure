package fr.mfraisse;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Map {
    protected String map;
    protected int row;
    protected int col;

    /**
     * Constructor of the map class
     * @param filename of the map (must be inside the src/main/resources/maps directory)
     */
    public Map(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/maps/" + filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            row = 0;
            col = line.length();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
                row++;
            }
            map = sb.toString();
        }catch (Exception e) {
            throw new IllegalArgumentException("File was not found.");
        }
    }

    /**
     * Overload of the constructor with default map filename
     */
    public Map(){
        this("carte v2.txt");
    }

    /**
     * Getter of the class Map
     */
    public String getMap() {
        return map;
    }
    public int getRow() {
        return row;
    }

    /**
     * Method returning if the point on the map corresponding to the given coordinate is a space character.
     * @param col index
     * @param row index
     * @return boolean
     */
    public boolean isMovable(int col, int row) {
        // We verify if the position is not out of bound
        if(col < 0 || col >= this.col || row < 0 || row >= this.row){
            return false;
        }

        return (map.charAt(col + ((this.col + 1) * row)) == ' '); // we add 1 to the number of colon because of the \n character
    }

    /**
     * Takes the file line containing the character original position and translate it into a Point variable
     * @param coordinatesLine containing character position
     * @return coordinates the character will be beginning on
     */
    public Point getCharacterCoordinates(String coordinatesLine){
        if(coordinatesLine.length() < 3){
            throw new IllegalArgumentException("Coordinates line must be at least 3 characters");
        }

        // initializing position variables
        int posX = coordinatesLine.charAt(0) - '0', posY, lastCharIndex = 3;

        // initializing character variables
        int secondCharacter = coordinatesLine.charAt(1) - '0', lastCharacter;

        // We check if the x position is double-digit
        if (secondCharacter >= 0 && secondCharacter < 10){
            posX = posX * 10 + secondCharacter;

            if(coordinatesLine.length() < 4){
                throw new IllegalArgumentException("Coordinates line does not contain y coordinates");
            }

            // we move the index of the y position if x is double-digit
            posY = coordinatesLine.charAt(3) - '0';
            lastCharIndex++;
        }
        else{
            posY = coordinatesLine.charAt(2) - '0';
        }

        // We verify if there is enough characters in to line to have a double-digit y position
        if(coordinatesLine.length() > lastCharIndex) {

            // We check if the y position is double-digit
            lastCharacter = coordinatesLine.charAt(lastCharIndex) - '0';
            if (lastCharacter >= 0 && lastCharacter < 10) {
                posY = posY * 10 + lastCharacter;
            }
        }

        return new Point(posX, posY);
    }

    /**
     * Place a character on the map then move it according to the instructions in the file
     * @param filename containing the character position and following instructions
     * @return position of the character of execution of the instructions
     */
    public Point moveCharacter(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Point coordinates = getCharacterCoordinates(br.readLine());
            //We check if the original position of the character is on a space

            if(!this.isMovable(coordinates.x, coordinates.y)){throw new IllegalArgumentException("Wrong origin position.");}

            String instructionLine = br.readLine();
            //We check if there is content on the second line
            if (instructionLine == null) {throw new IllegalArgumentException("File wasn't as expected.");}

            for(char character : instructionLine.toCharArray()){
                switch (character){
                    case 'N':
                        if(this.isMovable(coordinates.x, coordinates.y - 1)){
                            coordinates.y--;
                        }
                        break;
                    case 'S':
                        if(this.isMovable(coordinates.x, coordinates.y + 1)){
                            coordinates.y++;
                        }
                        break;
                    case 'E':
                        if(this.isMovable(coordinates.x + 1, coordinates.y )){
                            coordinates.x++;
                        }
                        break;
                    case 'O':
                        if(this.isMovable(coordinates.x - 1, coordinates.y)){
                            coordinates.x--;
                        }
                        break;
                    default:
                        break;
                }
            }
            return coordinates;
        }catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File was not found.");
        }catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

