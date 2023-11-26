package ProyectoRedSocial;

public class Publicacion {
    String texto;
    int likes;
    int dislikes;
    int medidordenivel = 10;
    Publicacion(String texto, int likes, int dislikes) {
        this.texto = texto;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    Publicacion(String texto) {
        this.texto = texto;
        this.likes = 0;
        this.dislikes = 0;
    }

    Publicacion() {
        this.texto = "Pending";
        this.likes = 0;
        this.dislikes = 0;
    }


    public String toString() {
        return "Publicacion: " + this.texto + " Likes: " + this.likes + " Dislikes: " + this.dislikes;
    }

}


