package org.example;

public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;
    public Reloj(){
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }
    public Reloj(int hor, int min, int sec){
        if (hor > 23 || min > 59 || sec > 59 || hor < 0 || min < 0 || sec < 0){
            throw new IllegalArgumentException("Argumentos ilegales");
        }
        this.horas = hor;
        this.minutos = min;
        this.segundos = sec;
    }
    public Reloj(int sec){
        if (sec < 0 || sec >= 86400){
            throw new IllegalArgumentException("Argumentos ilegales");
        }
        this.horas = (int) (sec/3600);
        this.minutos = (int) (sec - 3600*horas)/60;
        this.segundos = (int) (sec - 3600*horas - 60*minutos);
    }
    
    @Override
    public String toString(){
        return String.format("[%02d:%02d:%02d]", this.horas, this.minutos, this.segundos);
    }
    
    public void setReloj(int sec){
        if (sec < 0 || sec >= 86400){
            throw new IllegalArgumentException("Argumentos ilegales");
        }
        this.horas = (int) (sec/3600);
        this.minutos = (int) (sec - 3600*horas)/60;
        this.segundos = (int) (sec - 3600*horas - 60*minutos);
    }

    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        if (horas > 23) throw new IllegalArgumentException("Argumento invalido (horas <= 23)");
        this.horas = horas;
    }
    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        if (minutos > 23) throw new IllegalArgumentException("Argumento invalido (minutos <= 59)");
        this.minutos = minutos;
    }
    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        if (segundos > 23) throw new IllegalArgumentException("Argumento invalido (segundos <= 59)");
        this.segundos = segundos;
    }

    public void tick() {
        this.segundos++;
        if (this.segundos == 60){
            this.minutos++;
            this.segundos = 0;
            if (this.minutos == 60){
                this.horas++;
                this.minutos = 0;
                if (this.horas == 24){
                    this.horas = 0;
                }
            }
        }
    }

    public void tickDecrement() {
        this.segundos--;
        if (this.segundos == -1) {
            this.minutos--;
            this.segundos = 0;
            if (this.minutos == -1){
                this.horas--;
                this.minutos = 0;
                if (this.horas == -1){
                    this.horas = 23;
                    this.minutos = 59;
                    this.segundos = 59;
                }
            }
        }
    }

    public int aSegundos(){
        return (this.horas*3600 + this.minutos*60 + this.segundos);
    }

    public void addReloj(Reloj rel) {
        this.horas = rel.getHoras();
        this.minutos = rel.getMinutos();
        this.segundos = rel.getSegundos();
    }

    public Reloj restaReloj(Reloj rel) {
        return new Reloj((int) Math.abs(this.aSegundos() - rel.aSegundos()));
    }

}
