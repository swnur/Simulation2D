package simulation;

public class Application {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(0.05, 0.05, 0.1, 0.1);
        simulation.startSimulation();
    }
}