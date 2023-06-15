package cl.talentodigital.sprint_JSP.models;

public class NumberOfUserbyRol {
    private int rol;
    private int quantity;

    public NumberOfUserbyRol() {
    }

    public NumberOfUserbyRol(int rol, int quantity) {
        this.rol = rol;
        this.quantity = quantity;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
