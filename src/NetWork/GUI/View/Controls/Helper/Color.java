package NetWork.GUI.View.Controls.Helper;

public enum Color{
    PRIMARY("#007bff"),
    SECONDARY("#6c757d"),
    SUCCESS("#28a745"),
    DANGER("#dc3545"),
    WARNING("#ffc107"),
    INFO("#17a2b8"),
    WHITE("#ffffff"),
    BORDER_GREY("#ced4da")
    ;

    private Color(String color){
        this.color = color;
    }

    private String color;

    public String getColor(){
        return this.color;
    }

    public java.awt.Color getAWTColor() {
        return java.awt.Color.decode(this.getColor());
    }

    public String toString(){
        return this.color;
    }
}