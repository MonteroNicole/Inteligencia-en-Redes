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



}
