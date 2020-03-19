package dev.agpoon.dino.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scoring extends UI{
    
    private static int score;
    private static int limit;
    private int highScore;
    
    private long LastTime, timer;
    private int speed = 200;
    Font font;
    
    public Scoring(){
        try {
            File file = new File("C:\\Users\\kev\\Documents\\NetBeansProjects\\Dinosaur\\res\\textures\\highscore.txt");
            Scanner sc = new Scanner(file);
            highScore = Integer.parseInt(sc.next());
        } catch (FileNotFoundException ex) {
            
        }
        score = 0;
        limit = 100;
        
        LastTime = System.currentTimeMillis();
    }

    @Override
    public void tick() {
        timer+=System.currentTimeMillis()-LastTime;
        LastTime = System.currentTimeMillis();
        if(timer>speed){
            score+=1;
            timer = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Calibri", Font.BOLD, 20));
        g.drawString("SCORE: "+Integer.toString(score), 390, 30);
        g.drawString("HIGHSCORE: "+Integer.toString(highScore), 30, 30);
    }
    
    public static int getScore(){
        return score;
    }
    
    public static void restart(){
        score = 0;
    }
    
    public static int getLimit(){
        return limit;
    }
    
    public static void addLimit(int limit){
        Scoring.limit += limit;
    }
    
    public void stop(){
        timer = 0;
    }
    public void setHighscore(){
        try {
            PrintWriter outstream = new PrintWriter("C:\\Users\\kev\\Documents\\NetBeansProjects\\Dinosaur\\res\\textures\\highscore.txt");
            outstream.println(score);
            outstream.close();
            
        } catch (FileNotFoundException ex) {

        }
    }
    
    public int getHighscore(){
        return highScore;
    }
    public void newHighScore(){
        try {
            
            File file = new File("C:\\Users\\kev\\Documents\\NetBeansProjects\\Dinosaur\\res\\textures\\highscore.txt");
            Scanner sc;
            sc = new Scanner(file);
            highScore = Integer.parseInt(sc.next());
            
        } catch (FileNotFoundException ex) {

        }

    }
}