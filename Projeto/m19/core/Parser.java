package m19.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.Serializable;

import m19.app.exception.UserRegistrationFailedException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.UserRegistFailedException;

public class Parser{

  private Library _library;

  Parser(Library lib) {
    _library = lib;
  }

  void parseFile(String filename) throws IOException, BadEntrySpecificationException, UserRegistFailedException{
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;

      while ((line = reader.readLine()) != null)
        parseLine(line);
    }
  }

  private void parseLine(String line) throws BadEntrySpecificationException, UserRegistFailedException  {
    String[] components = line.split(":");

    switch(components[0]) {
      case "DVD":
        parseDVD(components, line);
        break;
      case "BOOK":
        parseBook(components, line);
        break;
      case "USER":
        parseUser(components, line);
        break;
        
      default:
        throw new BadEntrySpecificationException("Invalid type " + components[0] +
                                                " in line " + line);
    }
  }

  private void parseDVD(String[] components, String line) throws BadEntrySpecificationException {
    if (components.length != 7)
      throw new BadEntrySpecificationException("Wrong number of fields (6) in " + line);
    //Dvd dvd = new Dvd(components[1], components[2], Integer.parseInt(components[3]),
     //                 Categoria.valueOf(components[4]), Integer.parseInt(components[5]),
       //               Integer.parseInt(components[6]));
    _library.registarDVD(components[1], components[2], Integer.parseInt(components[3]),
                    Categoria.valueOf(components[4]), /*Integer.parseInt*/(components[5]),
                    Integer.parseInt(components[6]));
    // add dvd to _library
  }

  private void parseBook(String[] components, String line) throws BadEntrySpecificationException {
    if (components.length != 7)
      throw new BadEntrySpecificationException("Wrong number of fields (6) in " + line);

    /*Livro book = new Livro(components[1], components[2], Integer.parseInt(components[3]),
                         Categoria.valueOf(components[4]), Integer.parseInt(components[5]),
                         Integer.parseInt(components[6]));*/
    _library.registarLivro(components[1], components[2], Integer.parseInt(components[3]),
    Categoria.valueOf(components[4]), /*Integer.parseInt*/(components[5]),
    Integer.parseInt(components[6]));
    // add book to _library
  }

  private void parseUser(String[] components, String line) throws BadEntrySpecificationException, UserRegistFailedException{
    if (components.length != 3)
      throw new BadEntrySpecificationException("Wrong number of fields (2) in " + line);
    //Utente user = new Utente(_library.totalUtentes(),components[1], components[2]);
    try{
      _library.registarUtente(components[1], components[2]);
    } catch (UserRegistFailedException e){
      throw new UserRegistFailedException(components[1], components[2]);
    }

    
    
    // add user to _library
    // Pode ser necessário ter um try-catch adicional neste método
  }

 }