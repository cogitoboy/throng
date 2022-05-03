package com.winsomesoftware.ui;

import com.winsomesoftware.lafore.arrays.structures.Low;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class ScreenIo {

    public String rootContext = "<throng>";
    public static final String suffix = " % ";
    public static final String spaceBuffer = "                 ";
    Scanner scanner = new Scanner(System.in);

    public Integer getInteger(String context, String question) {
        String input = getInput(context, question);

        int num = 0;

        var valid = false;

        while(!valid) {
            try {
                num = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                displayOutput("Invalid response, must be a number. Found: " + input + ". Try again");
                input = getInput(context, question);
            }
        }

        return num;

    }

    public Boolean getBoolean(String context, String question) {

        String input = getInput(context, question);

        while((!"Y".equalsIgnoreCase(input)
                &&  !"N".equalsIgnoreCase(input))){
            input = getInput(context, question);
        }

        return ("Y".equalsIgnoreCase(input));

    }

    public String getInput(String context, String question) {
        this.rootContext = context;
        System.out.print("<"+ rootContext+"> % " + question);
        return scanner.nextLine();
    }

    public String[] getCommand(String context) {

        this.rootContext = context;

        System.out.print("<"+ rootContext+"> % ");
        String s = scanner.nextLine();

        return s.split(" ");
    }


    public void displayOutput(Low lowArray) {
        System.out.println("   -- Low Array --");
        System.out.println("   --------------");
        for(int i = 0; i < 20; i++) {

            System.out.println("   | i: "+ i + " | " + lowArray.getElem(i) );
        }
        System.out.println("   --------------");
    }
    public void displayOutput(String content) {
        String displayString = content.toString();


        int index = 0;

        while(index < displayString.length()) {

            int nextEndIndex = index + 80;
            if(nextEndIndex >= displayString.length())
                nextEndIndex = displayString.length();

            System.out.println(spaceBuffer.substring(0, rootContext.length() + 2) + displayString.substring(index, nextEndIndex));
            index = nextEndIndex;
        }

    }

}

