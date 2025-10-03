package com.augustojeronimo.tori.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Finder
{
  private static final String BASE_DIR = ".";

  protected Finder() {}

  public static String getPath(String relativePath)
  {
    return  checkPath(BASE_DIR, relativePath);
  }
  
  protected static String checkPath(String... segments) {
    Path p = Paths.get("", segments);
    return Files.exists(p) ? p.toString() : null;
  }
}
