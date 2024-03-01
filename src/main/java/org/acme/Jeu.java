package org.acme;

public class Jeu {
    private String title;
    private Voiture voiture;

    public Jeu(String title){
        this.title = title;
        this.voiture = new Voiture("V");
    }

    public String Title (int position){
        if(this.title==null) return "#";
        if(position<0) return this.title;
        StringBuilder begin = new StringBuilder();
        begin.append("#".repeat(position));
        begin.append(this.title);

        return begin.toString();
    }

    /* Réaliser une fonction qui anime le titre du jeu */
    public void animateTitle() throws InterruptedException {

            for (int i = 0; i < 100; i++) {
                System.out.print("\r" + this.Title(i));
                Thread.sleep(100);
            }

    }


}
