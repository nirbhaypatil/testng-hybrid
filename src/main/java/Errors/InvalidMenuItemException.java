package Errors;

public class InvalidMenuItemException extends RuntimeException{

    String menuOption;

    public InvalidMenuItemException(String menuOption){
        this.menuOption = menuOption;
    }

    @Override
    public String getMessage(){
        return "Invalid menu option: "+menuOption;
    }
}
