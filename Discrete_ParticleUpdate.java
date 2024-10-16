import java.util.*;

/**
 * Particle update strategy
 * 
 * Every Swarm.evolve() itereation the following methods are called
 * 		- begin(Swarm) : Once at the begining of each iteration
 * 		- update(Swarm,Particle) : Once for each particle
 * 		- end(Swarm) : Once at the end of each iteration
 * 
 * @author carlosandres.mendez
 */
public class Discrete_ParticleUpdate {

    Discrete_PSO_Swarm swarm;

    //A random weight r1.
    private final double WEIGHT_R1 = 0.2d;
    //The cognitive acceleration coefficient c1.
    private final double COGNIT_COEFFICIENT = 0.5d;

    //A random weight r2.
    private final double WEIGHT_R2 = 0.2d;
    //The social coefficient
    private final double SOCIAL_COEFFICIENT = 0.5d;

    
    public Discrete_ParticleUpdate() {
    }

    /** Update particle's velocity and position */
    public void update(Discrete_PSO_Swarm swarm, Discrete_Particle particle) {
        for (int i = 0; i < particle.position.size(); i++) {
            particle.position.set(i); particle.position.get(i));
        }
    }

    public class Particle {
    private int position, velocity, bestPosition;   
    public Particle(int position, int velocity) {
        this.position = position;
        this.velocity = velocity;
        this.bestPosition = position;
    }

    public void update(int globalBestPosition) {
        velocity += 0.5 * Math.random() * (bestPosition - position)
                  + 0.5 * Math.random() * (globalBestPosition - position);
        position += velocity;

        if (evaluate(position) < evaluate(bestPosition))
            bestPosition = position;
    }

    private int evaluate(int pos) {
        return pos * pos; // Ejemplo de función de evaluación
    }

    public int getPosition() {
        return position;
    }
}    
        
    
    }


class Particle {
    int[] position;  // Asignación de contenedores a máquinas
    int[] velocity;  // Velocidad de cambio de asignación
    int[] bestPosition;  // Mejor solución local de la partícula

    public Particle(int numContainers, int numMachines) {
        position = new int[numContainers];
        velocity = new int[numContainers];
        bestPosition = new int[numContainers];

        // Inicializar posición y velocidad aleatoriamente
        for (int i = 0; i < numContainers; i++) {
            position[i] = (int) (Math.random() * numMachines);
            velocity[i] = 0;
        }
        System.arraycopy(position, 0, bestPosition, 0, numContainers);
    }

    public void update(int[] globalBestPosition, double c1, double c2, double w) {
        // Actualizar la velocidad y posición de la partícula
        for (int i = 0; i < position.length; i++) {
            velocity[i] = (int) (w * velocity[i] 
                        + c1 * Math.random() * (bestPosition[i] - position[i])
                        + c2 * Math.random() * (globalBestPosition[i] - position[i]));

            position[i] = Math.abs(position[i] + velocity[i]) % position.length;  // Asegura que esté en rango
        }

        // Actualizar la mejor posición si es necesario
        if (evaluate(position) < evaluate(bestPosition)) {
            System.arraycopy(position, 0, bestPosition, 0, position.length);
        }
    }

    private int evaluate(int[] pos) {
        // Evaluar la función objetivo: número de máquinas utilizadas o costo total
        return calculateCost(pos);  // Suponiendo una función de costo
    }

    private int calculateCost(int[] pos) {
        // Lógica para calcular el costo total o número de máquinas
        return 0;  // Placeholder
    }

    public int[] getPosition() {
        return position;
    }
}
