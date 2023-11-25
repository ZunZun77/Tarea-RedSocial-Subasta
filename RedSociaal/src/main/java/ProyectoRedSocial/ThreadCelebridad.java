package ProyectoRedSocial;

public class ThreadCelebridad extends Thread{
    Celebridad celebridad;


    ThreadCelebridad(Celebridad celebridad) {
        this.celebridad = celebridad;
    }

    public void run() {
        int contseguidores = 0;
        while (true) {
            if (celebridad.seguidores%10 == 0 && celebridad.seguidores > contseguidores) {
                celebridad.notifyObservers(3, null);
                contseguidores = celebridad.seguidores;
            }
            for(int i = 0; i < celebridad.publicaciones.size(); i++) {
                if (celebridad.publicaciones.get(i).likes%10 == 0 && celebridad.publicaciones.get(i).likes >= celebridad.publicaciones.get(i).medidordenivel) {
                    celebridad.publicaciones.get(i).medidordenivel = celebridad.publicaciones.get(i).medidordenivel * 10;
                    celebridad.notifyObservers(2, celebridad.publicaciones.get(i));
                }

                try {
                    Thread.sleep(1000); // Evitar que el hilo se ejecute demasiado rápido
                } catch (InterruptedException e) {
                    // Manejar la interrupción si es necesario
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
