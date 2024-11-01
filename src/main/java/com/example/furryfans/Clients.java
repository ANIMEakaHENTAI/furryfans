package com.example.furryfans;

public class Clients {
    public int Id_client;
    public String Surname;
    public String Name;
    public String Telefone;
    public String City;
    public String Address;
    public String Email;

    public Clients(int Id_client, String Surname, String Name, String Telefone, String City, String Address, String Email) {
        this.setId_client(Id_client);
        this.setSurname(Surname);
        this.setName(Name);
        this.setTelefone(Telefone);
        this.setCity(City);
        this.setAddress(Address);
        this.setEmail(Email);
    }

    @Override
    public String toString() {
        return String.format(String.valueOf(this.getId_client()), this.getSurname(), this.getName(), this.getTelefone(),
                this.getCity(), this.getAddress(), this.getEmail());
    }

    public int getId_client() {
        return Id_client;
    }

    public void setId_client(int Id_client) {
        this.Id_client = Id_client;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCity() { return City; }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() { return Address; }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() { return Email; }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
