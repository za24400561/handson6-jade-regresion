import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new SLRBehaviour());
    }

    private class SLRBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            DataSet ds = new DataSet();                                   // a. dataset hardcodeado
            SimpleLinearRegression slr = new SimpleLinearRegression(ds.getX(), ds.getY()); // b. betas
            System.out.println("[" + myAgent.getLocalName() + "] Ecuación: " + slr.getEquation()); // c.

            double[] xs = {50.0, 100.0, 150.0};                           // d. tres predicciones
            for (double x : xs)
                System.out.printf("[%s] y = %.4f + %.4f * (%.1f) = %.4f%n", myAgent.getLocalName(),
                        slr.getBeta0(), slr.getBeta1(), x, slr.predict(x)); // e.

            System.out.printf("[%s] R^2 = %.4f%n", myAgent.getLocalName(), slr.calculateRSquared()); // f.
            myAgent.doDelete();                                           // 5. el agente muere
        }
    }

    @Override
    protected void takeDown() {
        System.out.println("[" + getLocalName() + "] Agente finalizado.");
    }
}
