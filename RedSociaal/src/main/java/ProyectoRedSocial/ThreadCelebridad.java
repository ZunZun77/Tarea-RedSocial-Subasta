package ProyectoRedSocial;

public class ThreadCelebridad extends Thread{
    Celebridad celebridad;


    ThreadCelebridad(Celebridad celebridad) {
        this.celebridad = celebridad;
    }

    public void run() {
        
        while (true) {
            if (celebridad.seguidores >= celebridad.contseguidores) {
                celebridad.notifyObservers(3, null);
                celebridad.contseguidores = celebridad.contseguidores * 10;

                
            }
            for(int i = 0; i < celebridad.publicaciones.size(); i++) {
                if (celebridad.publicaciones.get(i).likes >= celebridad.publicaciones.get(i).medidordenivel) {
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
