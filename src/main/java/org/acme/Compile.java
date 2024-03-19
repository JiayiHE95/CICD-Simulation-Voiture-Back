package org.acme;
public class Compile {
    int position = 0;
    public void move(String direction) {
        switch (direction) {
        case "avancer":
            position = position + 1;
            break;
        case "reculer":
            position = position - 1;
            break;
        default:
            System.out.println("Mauvaise direction");
            break;
       }
    }
}
