package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
 private int largeurMaison = 4;
 private int hauteurMaison = 4;
 private List<int[]> maisonPositions = new ArrayList<>();
 private List<int[]> stationPositions = new ArrayList<>();

 public Plateau() {
  maisonPositions.add(new int[] { 400, 90 });
  maisonPositions.add(new int[] { 100, 100 });
  maisonPositions.add(new int[] { 450, 150 });
  maisonPositions.add(new int[] { 200, 190 });
  maisonPositions.add(new int[] { 200, 100 });
  maisonPositions.add(new int[] { 450, 250 });

  stationPositions.add(new int[] { 200, 250 });
  stationPositions.add(new int[] { 100, 200 });
 }

 public boolean positionContientMaison(int x, int y) {
  for (int[] maison : maisonPositions) {
   int maisonX = maison[0];
   int maisonY = maison[1];
   if (x >= maisonX && x <= (maisonX + largeurMaison) && y >= maisonY && y <= (maisonY + hauteurMaison)) {
    return true;
   }
  }
  return false;
 }

 public boolean positionContientStation(int x, int y) {
  for (int[] station : stationPositions) {
   int stationX = station[0];
   int stationY = station[1];
   if (x >= stationX && x <= stationX + largeurMaison && y >= stationY && y <= stationY + hauteurMaison) {
    return true;
   }
  }
  return false;
 }

}
