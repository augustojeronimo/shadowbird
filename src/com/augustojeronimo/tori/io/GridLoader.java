package com.augustojeronimo.tori.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class GridLoader
{
  public static int[][] getMap(String relativePath)
  {
    String path = Finder.getPath(relativePath);

    List<List<Integer>> mapRows = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

      String line, divider = "-", comment = "#";

      while ((line = br.readLine()) != null) { 
        if (line.trim().startsWith(comment)) continue;

        String[] tileCodes = line.trim().split(divider);

        List<Integer> row = new ArrayList<>();

        for (String code : tileCodes) {
          row.add(Integer.valueOf(code));
        }

        if (! row.isEmpty()) mapRows.add(row);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    if (mapRows.isEmpty()) return null;


    int fileRows = mapRows.size();
    int fileCols = mapRows.get(0).size();

    int mapWidth = fileCols;
    int mapHeight = fileRows;

    int[][] map = new int[mapWidth][mapHeight];

    for (int y = 0; y < mapHeight; y++) {
      List<Integer> currentRow = mapRows.get(y);

      for (int x = 0; x < mapWidth; x++) {
        map[x][y] = currentRow.get(x);
      }
    }

    return map;
  }
}